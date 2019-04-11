package com.javaxian.cleanarchitecture.mvpjava.domain.component;

import com.javaxian.cleanarchitecture.mvpjava.domain.module.RealmModule;
import com.javaxian.cleanarchitecture.mvpjava.domain.module.RetrofitModule;
import com.javaxian.cleanarchitecture.mvpjava.presentation.activity.MainActivity;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {RetrofitModule.class, RealmModule.class})
public interface Components {

    void inject(MainActivity target);
}
