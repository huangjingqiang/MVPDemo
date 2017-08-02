package cn.han_zi.mvpdemo.di.component;

import android.app.Activity;

import cn.han_zi.mvpdemo.MainActivity;
import cn.han_zi.mvpdemo.di.module.ActivityModule;
import cn.han_zi.mvpdemo.di.scope.ActivityScope;
import dagger.Component;

@ActivityScope
@Component(dependencies = AppComponent.class, modules = ActivityModule.class)
public interface ActivityComponent {
    Activity getActivity();

}
