package com.example.rxjava_retrofit_mvp_md.article.view;

import com.example.rxjava_retrofit_mvp_md.base.BaseView;
import com.example.rxjava_retrofit_mvp_md.beans.Article;
import com.example.rxjava_retrofit_mvp_md.beans.ArticleBody;

import java.util.List;

/**
 * Created by KomoriWu
 * on 2017-03-24.
 */

public interface ArticleView extends BaseView {
    void addArticles(ArticleBody articleBody);

    @Override
    void showProgress();

    @Override
    void hideProgress();

    @Override
    void showLoadFailMsg(Throwable e);
}
