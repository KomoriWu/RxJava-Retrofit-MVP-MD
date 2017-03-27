package com.example.rxjava_retrofit_mvp_md.article.model;

import android.content.Context;

/**
 * Created by KomoriWu
 * on 2017-03-24.
 */

public interface ArticleModel {
    void lodeArticles(Context context,String url, String page, String size, ArticleModelImpl.
            OnLoadArticleListListener onLoadArticleListListener);
}
