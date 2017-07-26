package cn.han_zi.mvpdemo;

import android.app.Application;

import cn.han_zi.mvpdemo.base.InitializeService;
import cn.han_zi.mvpdemo.di.component.AppComponent;
import cn.han_zi.mvpdemo.di.component.DaggerAppComponent;
import cn.han_zi.mvpdemo.di.module.AppModule;
import cn.han_zi.mvpdemo.di.module.HttpModule;

/**
 * Create by xjs
 * _______date : 17/7/24
 * _______description:
 */
public class MyApp extends Application{
    private static MyApp instance;
    public static AppComponent appComponent;

    public static synchronized MyApp getInstance(){
        return instance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;

        //子线程完成其他初始化，解决启动白屏问题
        InitializeService.start(getApplicationContext());

    }

    public static AppComponent getAppComponent(){
        if (appComponent == null){
            appComponent = DaggerAppComponent.builder()
                    .appModule(new AppModule(instance))
                    .httpModule(new HttpModule())
                    .build();
        }
        return appComponent;
    }

}
