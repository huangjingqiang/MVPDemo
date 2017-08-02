package cn.han_zi.mvpdemo.httplib.interceptor;

import java.io.IOException;

import cn.han_zi.mvpdemo.MyApp;
import cn.han_zi.mvpdemo.httplib.NetWorkUtils;
import okhttp3.CacheControl;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Create by xjs
 * _______date : 17/8/2
 * _______description:
 */
public class CacheInterceptor implements Interceptor {
    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();
        if (!NetWorkUtils.isNetWorkConnect(MyApp.getInstance())){
            request = request.newBuilder()
                    .cacheControl(CacheControl.FORCE_CACHE)
                    .build();
        }
        Response response = chain.proceed(request);
        if (NetWorkUtils.isNetWorkConnect(MyApp.getInstance())){
            //有网络，不缓存
            return response.newBuilder()
                    .header("Cache-Control", "public, max-age=" + 0)
                    .removeHeader("Pragma")
                    .build();
        }else {
            //缓存时间 一天
            int maxTime = 1 * 24 * 60 * 60;
            return response.newBuilder()
                    .header("Cache-Control", "public, only-if-cached, max-stale=" + maxTime)
                    .removeHeader("Pragma")
                    .build();
        }
    }
}
