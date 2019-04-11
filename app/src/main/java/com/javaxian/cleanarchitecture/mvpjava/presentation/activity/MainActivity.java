package com.javaxian.cleanarchitecture.mvpjava.presentation.activity;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.javaxian.cleanarchitecture.mvpjava.R;
import com.javaxian.cleanarchitecture.mvpjava.domain.callback.OnFragmentChangedListener;
import com.javaxian.cleanarchitecture.mvpjava.presentation.fragment.main.MainFragment;

public class MainActivity extends AppCompatActivity implements OnFragmentChangedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initFragment();
    }

    @Override
    public void onFragmentChanged(Fragment fragment, int container) {
        getSupportFragmentManager()
                .beginTransaction()
                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                .replace(container, fragment, fragment.getClass().getName())
                .addToBackStack(fragment.getClass().getName())
                .commit();
    }

    private void initFragment(){

        Fragment fragment = MainFragment.newInstance();

        getSupportFragmentManager()
                .beginTransaction()
                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                .replace(R.id.container, fragment)
                .commit();
    }
}
