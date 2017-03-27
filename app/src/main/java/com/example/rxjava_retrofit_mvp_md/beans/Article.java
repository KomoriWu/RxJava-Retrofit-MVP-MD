package com.example.rxjava_retrofit_mvp_md.beans;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by KomoriWu
 * on 2017-03-24.
 */

public class Article implements Serializable {
    @SerializedName("coll_time")
    private String collectionTime;
    @SerializedName("id")
    private String id;
    @SerializedName("userAccount")
    private String userAccount;
    @SerializedName("userName")
    private String userName;
    @SerializedName("headImg")
    private String headImgUrl;
    @SerializedName("cover")
    private String coverUrl;
    @SerializedName("views")
    private String views;
    @SerializedName("likes")
    private String likes;
    @SerializedName("time")
    private String time;
    @SerializedName("titel")
    private String title;
    @SerializedName("brief_content")
    private String briefContent;
    @SerializedName("detail_content")
    private String detailContent;
    @SerializedName("album_500_500")
    private String albumUrl;
    @SerializedName("file_link")
    private String fileLink;

    public Article() {
    }

    public String getCollectionTime() {
        return collectionTime;
    }

    public void setCollectionTime(String collectionTime) {
        this.collectionTime = collectionTime;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserAccount() {
        return userAccount;
    }

    public void setUserAccount(String userAccount) {
        this.userAccount = userAccount;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getHeadImgUrl() {
        return headImgUrl;
    }

    public void setHeadImgUrl(String headImgUrl) {
        this.headImgUrl = headImgUrl;
    }

    public String getCoverUrl() {
        return coverUrl;
    }

    public void setCoverUrl(String coverUrl) {
        this.coverUrl = coverUrl;
    }

    public String getViews() {
        return views;
    }

    public void setViews(String views) {
        this.views = views;
    }

    public String getLikes() {
        return likes;
    }

    public void setLikes(String likes) {
        this.likes = likes;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBriefContent() {
        return briefContent;
    }

    public void setBriefContent(String briefContent) {
        this.briefContent = briefContent;
    }

    public String getDetailContent() {
        return detailContent;
    }

    public void setDetailContent(String detailContent) {
        this.detailContent = detailContent;
    }

    public String getAlbumUrl() {
        return albumUrl;
    }

    public void setAlbumUrl(String albumUrl) {
        this.albumUrl = albumUrl;
    }

    public String getFileLink() {
        return fileLink;
    }

    public void setFileLink(String fileLink) {
        this.fileLink = fileLink;
    }
}
