//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.example.newsapp.Model;

import com.google.gson.annotations.SerializedName;

public class ArticlesItem {
    @SerializedName("publishedAt")
    private String publishedAt;
    @SerializedName("author")
    private String author;
    @SerializedName("urlToImage")
    private String urlToImage;
    @SerializedName("description")
    private String description;
    @SerializedName("source")
    private Source source;
    @SerializedName("title")
    private String title;
    @SerializedName("url")
    private String url;
    @SerializedName("content")
    private String content;

    public ArticlesItem() {
    }

    public void setPublishedAt(String publishedAt) {
        this.publishedAt = publishedAt;
    }

    public String getPublishedAt() {
        return this.publishedAt;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getAuthor() {
        return this.author;
    }

    public void setUrlToImage(String urlToImage) {
        this.urlToImage = urlToImage;
    }

    public String getUrlToImage() {
        return this.urlToImage;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return this.description;
    }

    public void setSource(Source source) {
        this.source = source;
    }

    public Source getSource() {
        return this.source;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return this.title;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUrl() {
        return this.url;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getContent() {
        return this.content;
    }

    public String toString() {
        return "ArticlesItem{publishedAt = '" + this.publishedAt + '\'' + ",author = '" + this.author + '\'' + ",urlToImage = '" + this.urlToImage + '\'' + ",description = '" + this.description + '\'' + ",source = '" + this.source + '\'' + ",title = '" + this.title + '\'' + ",url = '" + this.url + '\'' + ",content = '" + this.content + '\'' + "}";
    }
}
