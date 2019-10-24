//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.example.newsapp.Model;

import com.google.gson.annotations.SerializedName;
import java.util.List;

public class NewsResponse {
    @SerializedName("totalResults")
    private int totalResults;
    @SerializedName("articles")
    private List<ArticlesItem> articles;
    @SerializedName("status")
    private String status;

    public NewsResponse() {
    }

    public void setTotalResults(int totalResults) {
        this.totalResults = totalResults;
    }

    public int getTotalResults() {
        return this.totalResults;
    }

    public void setArticles(List<ArticlesItem> articles) {
        this.articles = articles;
    }

    public List<ArticlesItem> getArticles() {
        return this.articles;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return this.status;
    }

    public String toString() {
        return "NewsResponse{totalResults = '" + this.totalResults + '\'' + ",articles = '" + this.articles + '\'' + ",status = '" + this.status + '\'' + "}";
    }
}
