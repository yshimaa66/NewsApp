//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.example.newsapp.Model;

import com.google.gson.annotations.SerializedName;

public class Source {
    @SerializedName("name")
    private String name;
    @SerializedName("id")
    private String id;

    public Source() {
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return this.id;
    }

    public String toString() {
        return "Source{name = '" + this.name + '\'' + ",id = '" + this.id + '\'' + "}";
    }
}
