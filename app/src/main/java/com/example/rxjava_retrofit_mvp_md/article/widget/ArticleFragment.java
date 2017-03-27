package com.example.rxjava_retrofit_mvp_md.article.widget;


import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.example.rxjava_retrofit_mvp_md.R;
import com.example.rxjava_retrofit_mvp_md.article.ArticleAdapter;
import com.example.rxjava_retrofit_mvp_md.article.presenter.ArticlePresenter;
import com.example.rxjava_retrofit_mvp_md.article.presenter.ArticlePresenterImpl;
import com.example.rxjava_retrofit_mvp_md.article.view.ArticleView;
import com.example.rxjava_retrofit_mvp_md.base.BaseFragment;
import com.example.rxjava_retrofit_mvp_md.beans.ArticleBody;
import com.example.rxjava_retrofit_mvp_md.refresh.RefreshLayout;
import com.example.rxjava_retrofit_mvp_md.refresh.SpaceItemDecoration;
import com.example.rxjava_retrofit_mvp_md.refresh.SwipeRefreshLayoutDirection;
import com.example.rxjava_retrofit_mvp_md.utils.Utils;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by KomoriWu
 * on 2017-03-24.
 */

public class ArticleFragment extends BaseFragment implements ArticleView,
        RefreshLayout.OnRefreshListener {
    public static final String TAG = ArticleFragment.class.getSimpleName();
    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;
    @BindView(R.id.layout_refresh)
    RefreshLayout refreshLayout;
    @BindView(R.id.layout_article)
    LinearLayout layoutArticle;
    private int mPage;
    private int mSize = 8;
    private ArticleAdapter mArticleAdapter;
    private ArticlePresenter mArticlePresenter;

    @Override
    public View initView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_article, null);
        ButterKnife.bind(this, view);
        initData();
        return view;
    }

    private void initData() {
        mArticlePresenter = new ArticlePresenterImpl(getActivity(), this);
        refreshLayout.setDirection(SwipeRefreshLayoutDirection.BOTH);
        refreshLayout.setOnRefreshListener(this);
        refreshLayout.setColorScheme(R.color.colorPrimary, R.color.colorAccent,
                R.color.light_primary_color);
        onRefresh(SwipeRefreshLayoutDirection.TOP);
        recyclerView.setHasFixedSize(true);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        int spacingInPixels = getResources().getDimensionPixelSize(R.dimen.item_space);
        recyclerView.addItemDecoration(new SpaceItemDecoration(spacingInPixels));
        mArticleAdapter = new ArticleAdapter(getActivity());
        recyclerView.setAdapter(mArticleAdapter);
    }

    @Override
    public void showProgress() {
        refreshLayout.post(new Runnable() {
            @Override
            public void run() {
                refreshLayout.setRefreshing(true);
            }
        });
    }

    @Override
    public void addArticles(ArticleBody articleBody) {
        mArticleAdapter.addArticleList(articleBody.getArticleArrayList(),
                mPage == 1 ? true : false);
        if (articleBody.getCount() <= mPage * mSize) {
            Utils.showSnackBar(layoutArticle, getString(R.string.the_last_page));
            hideProgress();
            refreshLayout.setDirection(SwipeRefreshLayoutDirection.TOP);
        }
    }

    @Override
    public void hideProgress() {
        refreshLayout.post(new Runnable() {
            @Override
            public void run() {
                refreshLayout.setRefreshing(false);
            }
        });
    }

    @Override
    public void showLoadFailMsg(Throwable e) {
//        Utils.showSnackBar(layoutArticle, e.getMessage());
    }


    @Override
    public void onRefresh(SwipeRefreshLayoutDirection direction) {
        if (direction == SwipeRefreshLayoutDirection.TOP) {
            mPage = 1;
            refreshLayout.setDirection(SwipeRefreshLayoutDirection.BOTH);
        } else {
            mPage++;
        }

        mArticlePresenter.LodeArticles(mPage + "", mSize + "");
    }
}
