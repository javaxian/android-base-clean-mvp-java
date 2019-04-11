package com.javaxian.cleanarchitecture.mvpjava.domain.base;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;

import com.javaxian.cleanarchitecture.mvpjava.Application;

public abstract class BasePreferences {

    private SharedPreferences preferences;
    private SharedPreferences.Editor editor;

    public abstract String onPreferName();

    @SuppressLint("CommitPrefEdits")
    public SharedPreferences getPreferences() {
        if (preferences == null) {
            String preferName = onPreferName();
            if (TextUtils.isEmpty(preferName))
                throw new NullPointerException("Prefer name can not be null");

            preferences = Application.getInstance().getSharedPreferences(preferName, Context.MODE_PRIVATE);
            editor = preferences.edit();
        }
        return preferences;
    }

    @SuppressLint("CommitPrefEdits")
    public SharedPreferences.Editor getEditor() {
        if (editor == null)
            editor = getPreferences().edit();
        return editor;
    }

    public void cleanPreferences() {
        getEditor().clear().commit();
    }
}
