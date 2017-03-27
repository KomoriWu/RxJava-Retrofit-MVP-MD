package com.example.rxjava_retrofit_mvp_md.article.presenter;

import android.content.Context;

import com.example.rxjava_retrofit_mvp_md.article.model.ArticleModel;
import com.example.rxjava_retrofit_mvp_md.article.model.ArticleModelImpl;
import com.example.rxjava_retrofit_mvp_md.article.view.ArticleView;
import com.example.rxjava_retrofit_mvp_md.beans.ArticleBody;
import com.example.rxjava_retrofit_mvp_md.utils.Utils;

/**
 * Created by KomoriWu
 * on 2017-03-24.
 */

public class ArticlePresenterImpl implements ArticlePresenter, ArticleModelImpl.
        OnLoadArticleListListener {
    private Context mContext;
    private ArticleModel mArticleModel;
    private ArticleView mArticleView;

    public ArticlePresenterImpl(Context context, ArticleView articleView) {
        this.mContext = context;
        this.mArticleView = articleView;
        mArticleModel = new ArticleModelImpl();
    }

    @Override
    public void LodeArticles(String page, String size) {
        mArticleView.showProgress();
        mArticleModel.lodeArticles(mContext, Utils.URL, page, size, this);
    }


    @Override
    public void onSuccess(ArticleBody articleBody) {
        mArticleView.hideProgress();
        mArticleView.addArticles(articleBody);
    }

    @Override
    public void onFailure(Throwable e) {
        mArticleView.hideProgress();
        mArticleView.showLoadFailMsg(e);
    }


}
