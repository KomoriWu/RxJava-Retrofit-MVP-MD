package com.example.rxjava_retrofit_mvp_md.main.presenter;


import com.example.rxjava_retrofit_mvp_md.R;
import com.example.rxjava_retrofit_mvp_md.main.view.MainView;

/**
 * Created by KomoriWu
 * on 2017-03-24.
 */


public class MainPresenterImpl implements MainPresenter {
    private MainView mMainView;

    public MainPresenterImpl(MainView mMainView) {
        this.mMainView = mMainView;
    }

    @Override
    public void switchNavigation(int id) {
        switch (id) {
            case R.id.fab:

                break;
            case R.id.nav_home:
                mMainView.switchHome();
                break;
            case R.id.nav_community:
                mMainView.switchCommunity();
                break;
            case R.id.nav_instructions:
                mMainView.switchInstructions();
                break;
            case R.id.nav_about_us:
                mMainView.switchAboutUs();
                break;
        }
    }
}
