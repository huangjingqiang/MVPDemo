package cn.han_zi.mvpdemo.di.component;


import javax.inject.Singleton;

import cn.han_zi.mvpdemo.MyApp;
import cn.han_zi.mvpdemo.di.module.AppModule;
import cn.han_zi.mvpdemo.di.module.HttpModule;
import dagger.Component;

@Singleton
@Component(modules = {AppModule.class, HttpModule.class})
public interface AppComponent {

    MyApp getContext();  // 提供App的Context
}
