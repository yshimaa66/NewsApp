//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.example.newsapp.Model;

import com.google.gson.annotations.SerializedName;

public class SourcesItem {
    @SerializedName("country")
    private String country;
    @SerializedName("name")
    private String name;
    @SerializedName("description")
    private String description;
    @SerializedName("language")
    private String language;
    @SerializedName("id")
    private String id;
    @SerializedName("category")
    private String category;
    @SerializedName("url")
    private String url;

    public SourcesItem() {
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCountry() {
        return this.country;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return this.description;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getLanguage() {
        return this.language;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return this.id;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getCategory() {
        return this.category;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUrl() {
        return this.url;
    }

    public String toString() {
        return "SourcesItem{country = '" + this.country + '\'' + ",name = '" + this.name + '\'' + ",description = '" + this.description + '\'' + ",language = '" + this.language + '\'' + ",id = '" + this.id + '\'' + ",category = '" + this.category + '\'' + ",url = '" + this.url + '\'' + "}";
    }
}
