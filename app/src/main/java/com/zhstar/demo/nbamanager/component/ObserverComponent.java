package com.zhstar.demo.nbamanager.component;

import com.zhstar.demo.nbamanager.activity.LoginActivity;
import com.zhstar.demo.nbamanager.module.ObserverModule;

import dagger.Component;


@Component(modules = ObserverModule.class)
public interface ObserverComponent {
    void inject(LoginActivity activity);
}
