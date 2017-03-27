package com.example.rxjava_retrofit_mvp_md.article;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.rxjava_retrofit_mvp_md.R;
import com.example.rxjava_retrofit_mvp_md.application.MyApplication;
import com.example.rxjava_retrofit_mvp_md.beans.Article;
import com.example.rxjava_retrofit_mvp_md.utils.Utils;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by KomoriWu
 * on 2017-03-24.
 */

public class ArticleAdapter extends RecyclerView.Adapter<ArticleAdapter.ArticleViewHolder> {
    private Context mContext;
    private List<Article> mArticleArrayList;

    public ArticleAdapter(Context mContext) {
        this.mContext = mContext;
        mArticleArrayList = new ArrayList<>();
    }

    public void addArticleList(List<Article> articleList, boolean isClearList) {
        if (articleList != null) {
            if (isClearList) {
                mArticleArrayList.clear();
            }
            mArticleArrayList.addAll(articleList);
            notifyDataSetChanged();
        }
    }

    @Override
    public ArticleViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_article, null);
        return new ArticleViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ArticleViewHolder holder, int position) {
        Article article = mArticleArrayList.get(position);
        MyApplication.getImageLoader(mContext).displayImage(article.getCoverUrl(), holder.ivCover,
                Utils.getImageOptions(R.mipmap.loading));
        MyApplication.getImageLoader(mContext).displayImage(article.getHeadImgUrl(), holder.ivHeadImg,
                Utils.getImageOptions(true));
        holder.tvViews.setText(article.getViews());
        holder.tvUsername.setText(article.getUserName());
        holder.tvLikes.setText(article.getLikes());
        holder.tvTitle.setText(article.getTitle());
        holder.tvContent.setText(article.getBriefContent());
        holder.tvTime.setText(article.getTime());
    }

    @Override
    public int getItemCount() {
        return mArticleArrayList == null ? 0 : mArticleArrayList.size();
    }

    public class ArticleViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.iv_article_cover)
        ImageView ivCover;
        @BindView(R.id.iv_article_head_img)
        ImageView ivHeadImg;
        @BindView(R.id.tv_article_views)
        TextView tvViews;
        @BindView(R.id.tv_username)
        TextView tvUsername;
        @BindView(R.id.tv_article_likes)
        TextView tvLikes;
        @BindView(R.id.tv_article_title)
        TextView tvTitle;
        @BindView(R.id.tv_article_content)
        TextView tvContent;
        @BindView(R.id.tv_article_time)
        TextView tvTime;

        public ArticleViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
