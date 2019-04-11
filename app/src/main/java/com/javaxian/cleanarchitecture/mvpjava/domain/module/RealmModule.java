package com.javaxian.cleanarchitecture.mvpjava.domain.module;

import android.content.Context;

import com.javaxian.cleanarchitecture.mvpjava.data.preference.SettingsData;

import dagger.Module;
import dagger.Provides;
import io.realm.Realm;
import io.realm.RealmConfiguration;

@Module
public class RealmModule {

    private Realm realm;
    private RealmConfiguration realmConfig;

    public RealmModule(Context context){
        initRealm(context);
    }

    private synchronized void initRealm(Context context) {
        Realm.init(context);
        Realm.setDefaultConfiguration(getRealmConfig());
    }


    public Realm getRealm() {

        if(realm==null){
            realm = Realm.getInstance(getRealmConfig());
        }else if(realm.isClosed()){
            realm = Realm.getInstance(getRealmConfig());
        }

        return realm;
    }

    @Provides
    public RealmModule getRealmModule(){
        return this;
    }

    private synchronized RealmConfiguration getRealmConfig() {
        if (realmConfig == null)
            realmConfig = new RealmConfiguration
                    .Builder()
                    .name("earthquake.realm")
                    .schemaVersion(1)
                    .deleteRealmIfMigrationNeeded()
                    .encryptionKey(SettingsData.getInstance().getEncryptionKey())
                    .build();

        return realmConfig;
    }
}
