package com.example.rxjava_retrofit_mvp_md.beans;

import com.example.rxjava_retrofit_mvp_md.http.HttpService;
import com.example.rxjava_retrofit_mvp_md.http.api.BaseApi;
import com.example.rxjava_retrofit_mvp_md.http.listener.HttpOnNextListener;
import com.trello.rxlifecycle.components.support.RxAppCompatActivity;

import java.util.HashMap;
import java.util.Map;

import retrofit2.Retrofit;
import rx.Observable;

/**
 * Created by KomoriWu
 * on 2017-03-26.
 */

public class ArticleApi extends BaseApi {
    private String mPage;
    private String mSize;

    public ArticleApi(RxAppCompatActivity rxAppCompatActivity, String page, String size,
                      HttpOnNextListener listener) {
        super(rxAppCompatActivity, listener);
        this.mPage = page;
        this.mSize = size;
        setShowProgress(false);
    }

    @Override
    public Observable getObservable(Retrofit retrofit) {
        Map<String, String> map = new HashMap<>();
        map.put("page", mPage);
        map.put("size", mSize);
        HttpService service = retrofit.create(HttpService.class);
        return service.getAllArticles(map);
    }
}
