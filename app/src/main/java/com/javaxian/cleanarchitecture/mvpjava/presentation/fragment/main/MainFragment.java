package com.javaxian.cleanarchitecture.mvpjava.presentation.fragment.main;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.javaxian.cleanarchitecture.mvpjava.R;
import com.javaxian.cleanarchitecture.mvpjava.presentation.fragment.AttachFragment;

public class MainFragment  extends AttachFragment {

    private View rootView;

    public static MainFragment newInstance() {
        MainFragment mainFragment = new MainFragment();
        mainFragment.setHasOptionsMenu(true);
        return mainFragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        rootView = inflater.inflate(R.layout.fragment_main,container,false);

        initResources();
        initPresenter();

        return rootView;
    }

    private void initResources(){

    }

    private void initPresenter(){

    }

    //To change fragment call callback.onFragmentChanged(NewFragment.newInstance(),R.id.container); method
}
