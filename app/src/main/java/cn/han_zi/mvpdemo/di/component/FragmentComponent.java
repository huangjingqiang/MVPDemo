package cn.han_zi.mvpdemo.di.component;

import android.app.Activity;
import cn.han_zi.mvpdemo.di.module.FragmentModule;
import cn.han_zi.mvpdemo.di.scope.FragmentScope;
import dagger.Component;

@FragmentScope
@Component(dependencies = AppComponent.class, modules = FragmentModule.class)
public interface FragmentComponent {

    Activity getActivity();

}
