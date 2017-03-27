package com.example.rxjava_retrofit_mvp_md.http;

import com.example.rxjava_retrofit_mvp_md.beans.ArticleBody;
import com.example.rxjava_retrofit_mvp_md.utils.Utils;

import java.util.Map;

import retrofit2.http.GET;
import retrofit2.http.QueryMap;
import rx.Observable;

/**
 * Created by KomoriWu
 * on 2017-03-24.
 */

public interface HttpService {
    @GET(Utils.GET_ALL_ARTICLES)
    Observable<ArticleBody> getAllArticles(@QueryMap Map<String, String> map);
}
