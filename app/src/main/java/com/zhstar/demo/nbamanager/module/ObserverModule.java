package com.zhstar.demo.nbamanager.module;

import android.content.Context;

import com.zhstar.demo.nbamanager.services.LoginObserver;

import dagger.Module;
import dagger.Provides;

@Module
public class ObserverModule {

    Context context;

    public ObserverModule(Context context) {
        this.context = context;
    }

    @Provides
    LoginObserver provideLoginObserver() {
        return new LoginObserver(context);
    }
}
