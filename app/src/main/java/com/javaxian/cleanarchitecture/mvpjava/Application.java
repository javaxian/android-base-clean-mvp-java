package com.javaxian.cleanarchitecture.mvpjava;

import android.support.multidex.MultiDexApplication;

import com.javaxian.cleanarchitecture.mvpjava.domain.component.Components;
import com.javaxian.cleanarchitecture.mvpjava.domain.component.DaggerComponents;
import com.javaxian.cleanarchitecture.mvpjava.domain.module.RealmModule;
import com.javaxian.cleanarchitecture.mvpjava.domain.module.RetrofitModule;

public class Application extends MultiDexApplication {

    private static Application instance;
    private Components components;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;

        //If you don't use dagger2 call this realm configuration "RealmConfig.getInstance().initRealm(this);"

        components = DaggerComponents.builder()
                .realmModule(new RealmModule(this))
                .retrofitModule(new RetrofitModule())
                .build();
    }

    public static Application getInstance() {
        return instance;
    }
}
