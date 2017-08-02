package cn.han_zi.mvpdemo.httplib;

import android.content.Context;

import com.facebook.stetho.okhttp3.StethoInterceptor;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import cn.han_zi.mvpdemo.BuildConfig;
import cn.han_zi.mvpdemo.config.Constans;
import cn.han_zi.mvpdemo.httplib.interceptor.CacheInterceptor;
import okhttp3.Cache;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Create by xjs
 * _______date : 17/8/2
 * _______description:
 */
public class RetrofitManager implements HttpManager {

    private static RetrofitManager retrofitManager;

    private Context context;

    private OkHttpClient okHttpClient;

    private Retrofit retrofit;

    //缓存对象
    private Cache cache;

    //日志拦截器
    public HttpLoggingInterceptor httpLoggingInterceptor;

    //参数拦截器

    private RetrofitManager(Context context){
        this.context = context;
        initRetrofit();

        initOkHttp();
    }

    /**
     * 同步锁，解决多线程初始化
     * @param context
     * @return
     */
    public static RetrofitManager getInstance(Context context){
        if (retrofitManager == null){
            synchronized (RetrofitManager.class){
                if (retrofitManager == null){
                    retrofitManager = new RetrofitManager(context);
                }
            }
        }
        return retrofitManager;
    }

    /**
     * 创建retrofit
     * @param service
     * @param <T>
     * @return
     */
    public <T> T getApiService(Class<T> service){
        return retrofit.create(service);
    }

    /**
     * 获取缓存
     * @return
     */
    public Cache getCache(){
        return cache;
    }

    /**
     * 删除缓存
     * @throws IOException
     */
    public void clearCache() throws IOException {
        cache.delete();
    }

    private void initRetrofit() {
        retrofit = new Retrofit.Builder()
                .baseUrl(Constans.SERVER_PATH)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(okHttpClient)
                .build();
    }

    private void initOkHttp(){
        File cacheFile = new File(context.getCacheDir(),"okhttpCache");
        cache = new Cache(cacheFile,1024 * 1024 * 100);  //100M
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        if (BuildConfig.DEBUG){
            httpLoggingInterceptor = new HttpLoggingInterceptor();
            httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
            builder.addNetworkInterceptor(new StethoInterceptor());
        }

        okHttpClient = builder.connectTimeout(20, TimeUnit.SECONDS)
                .writeTimeout(20,TimeUnit.SECONDS)
                .readTimeout(20,TimeUnit.SECONDS)
                .retryOnConnectionFailure(true)  //重连
                .addInterceptor(new HttpLoggingInterceptor())
                .addInterceptor(new CacheInterceptor())
                .cache(cache)
                .build();
    }


}
