package com.example.rxjava_retrofit_mvp_md.http.api;

import com.example.rxjava_retrofit_mvp_md.http.listener.HttpOnNextListener;
import com.example.rxjava_retrofit_mvp_md.utils.Utils;
import com.trello.rxlifecycle.components.support.RxAppCompatActivity;

import retrofit2.Retrofit;
import rx.Observable;
import rx.functions.Func0;

/**
 * Created by KomoriWu
 * on 2017-03-25.
 */

public abstract class BaseApi<T> implements Func0<T> {
    private RxAppCompatActivity mRxAppCompatActivity;
    private HttpOnNextListener mListener;
    private boolean mIsShowProgress;
    private boolean mIsCancel;
    private String mBaseUrl;
    private int mConnectionTime;

    public abstract Observable getObservable(Retrofit retrofit);

    public BaseApi(RxAppCompatActivity rxAppCompatActivity, HttpOnNextListener listener) {
        this.mRxAppCompatActivity = rxAppCompatActivity;
        this.mListener = listener;
        setBaseUrl(Utils.URL);
        setConnectionTime(6);
        setShowProgress(true);
    }

    public RxAppCompatActivity getRxAppCompatActivity() {
        return mRxAppCompatActivity;
    }

    public void setRxAppCompatActivity(RxAppCompatActivity mRxAppCompatActivity) {
        this.mRxAppCompatActivity = mRxAppCompatActivity;
    }

    public HttpOnNextListener getListener() {
        return mListener;
    }

    public void setListener(HttpOnNextListener mListener) {
        this.mListener = mListener;
    }

    public boolean isShowProgress() {
        return mIsShowProgress;
    }

    public void setShowProgress(boolean showProgress) {
        mIsShowProgress = showProgress;
    }

    public String getBaseUrl() {
        return mBaseUrl;
    }

    public void setBaseUrl(String baseUrl) {
        this.mBaseUrl = baseUrl;
    }

    public int getConnectionTime() {
        return mConnectionTime;
    }

    public void setConnectionTime(int connectionTime) {
        this.mConnectionTime = connectionTime;
    }

    public boolean isIsCancel() {
        return mIsCancel;
    }

    public void setIsCancel(boolean mIsCancel) {
        this.mIsCancel = mIsCancel;
    }

    @Override
    public T call() {
        return null;
    }
}
