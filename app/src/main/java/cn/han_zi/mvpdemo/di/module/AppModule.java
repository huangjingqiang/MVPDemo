package cn.han_zi.mvpdemo.di.module;


import javax.inject.Singleton;

import cn.han_zi.mvpdemo.MyApp;
import dagger.Module;
import dagger.Provides;

@Module
public class AppModule {
    private final MyApp application;

    public AppModule(MyApp application) {
        this.application = application;
    }

    @Provides
    @Singleton
    MyApp provideApplicationContext() {
        return application;
    }
}
