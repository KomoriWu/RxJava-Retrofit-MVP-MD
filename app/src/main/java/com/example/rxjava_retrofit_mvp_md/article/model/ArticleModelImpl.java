package com.example.rxjava_retrofit_mvp_md.article.model;

import android.content.Context;
import android.util.Log;

import com.example.rxjava_retrofit_mvp_md.beans.ArticleApi;
import com.example.rxjava_retrofit_mvp_md.beans.ArticleBody;
import com.example.rxjava_retrofit_mvp_md.http.HttpManager;
import com.example.rxjava_retrofit_mvp_md.http.HttpService;
import com.example.rxjava_retrofit_mvp_md.http.listener.HttpOnNextListener;
import com.example.rxjava_retrofit_mvp_md.utils.Utils;
import com.trello.rxlifecycle.components.support.RxAppCompatActivity;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by KomoriWu
 * on 2017-03-24.
 */

public class ArticleModelImpl implements ArticleModel {
    public static final String TAG = ArticleModelImpl.class.getSimpleName();

    @Override
    public void lodeArticles(Context context, String url, String page, String size,
                             final OnLoadArticleListListener onLoadArticleListListener) {

        ArticleApi articleApi = new ArticleApi((RxAppCompatActivity) context, page, size,
                new HttpOnNextListener<ArticleBody>() {
                    @Override
                    public void onNext(ArticleBody articleBody) {
                        onLoadArticleListListener.onSuccess(articleBody);
                    }

                    @Override
                    public void onError(Throwable e) {
                        super.onError(e);
                        onLoadArticleListListener.onFailure(e);
                    }
                });
        HttpManager.getInstance().doHttpDeal(articleApi);

    }


    public interface OnLoadArticleListListener {
        void onSuccess(ArticleBody articleBody);

        void onFailure(Throwable e);
    }

}
