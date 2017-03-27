package com.example.rxjava_retrofit_mvp_md.beans;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by KomoriWu
 * on 2017-03-25.
 */

public class ArticleBody {
    @SerializedName("page")
    int page;
    @SerializedName("size")
    int size;
    @SerializedName("count")
    int count;
    @SerializedName("article")
    ArrayList<Article> articleArrayList;

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public ArrayList<Article> getArticleArrayList() {
        return articleArrayList;
    }

    public void setArticleArrayList(ArrayList<Article> articleArrayList) {
        this.articleArrayList = articleArrayList;
    }
}
