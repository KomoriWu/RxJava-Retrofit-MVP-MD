package com.example.rxjava_retrofit_mvp_md.http;

import android.app.ProgressDialog;
import android.content.DialogInterface;

import com.example.rxjava_retrofit_mvp_md.http.api.BaseApi;
import com.example.rxjava_retrofit_mvp_md.http.listener.HttpOnNextListener;
import com.example.rxjava_retrofit_mvp_md.utils.Utils;
import com.trello.rxlifecycle.components.support.RxAppCompatActivity;

import rx.Subscriber;

/**
 * Created by KomoriWu
 * on 2017-03-26.
 */

public class ProgressSubscriber<T> extends Subscriber<T> {
    private boolean mIsShowProgress;
    private HttpOnNextListener mHttpOnNextListener;
    private RxAppCompatActivity mRxAppCompatActivity;
    private ProgressDialog mProgressDialog;
    private BaseApi mApi;

    public ProgressSubscriber(BaseApi api) {
        this.mApi = api;
        this.mIsShowProgress = api.isShowProgress();
        this.mHttpOnNextListener = api.getListener();
        this.mRxAppCompatActivity = api.getRxAppCompatActivity();
        if (api.isShowProgress()) {
            initProgressDialog(api.isIsCancel());
        }
    }

    private void initProgressDialog(boolean cancel) {
        if (mProgressDialog == null && mRxAppCompatActivity != null) {
            mProgressDialog = new ProgressDialog(mRxAppCompatActivity);
            mProgressDialog.setCancelable(cancel);
            if (cancel) {
                mProgressDialog.setOnCancelListener(new DialogInterface.OnCancelListener() {
                    @Override
                    public void onCancel(DialogInterface dialogInterface) {
                        if (mHttpOnNextListener != null) {
                            mHttpOnNextListener.onCancel();
                        }
                        onCancelProgress();
                    }
                });
            }
        }
    }

    public void onCancelProgress() {
        if (!this.isUnsubscribed()) {
            this.unsubscribe();
        }
    }

    private void showProgressDialog() {
        if (!mIsShowProgress) return;
        if (mProgressDialog == null || mRxAppCompatActivity == null) return;
        if (!mProgressDialog.isShowing()) {
            mProgressDialog.show();
        }
    }

    private void dismissProgressDialog() {
        if (!mIsShowProgress) return;
        if (mProgressDialog != null && mProgressDialog.isShowing()) {
            mProgressDialog.dismiss();
        }
    }

    @Override
    public void onStart() {
        showProgressDialog();
    }

    @Override
    public void onCompleted() {
        dismissProgressDialog();
    }

    @Override
    public void onError(Throwable e) {
        dismissProgressDialog();
        if (mHttpOnNextListener != null) {
            mHttpOnNextListener.onError(e);
            Utils.showAlertDialog(mRxAppCompatActivity, e.getMessage());
        }
    }

    @Override
    public void onNext(T t) {
        if (mHttpOnNextListener != null) {
            mHttpOnNextListener.onNext(t);
        }
    }
}
