package com.example.rxjava_retrofit_mvp_md.base;

/**
 * Created by KomoriWu
 * on 2017-03-26.
 */

public interface BaseView {
    void showProgress();

    void hideProgress();

    void showLoadFailMsg(Throwable e);
}
