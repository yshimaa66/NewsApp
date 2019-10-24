//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.example.newsapp.Model;

import com.google.gson.annotations.SerializedName;
import java.util.List;

public class SourcesResponse {
    @SerializedName("sources")
    private List<SourcesItem> sources;
    @SerializedName("status")
    private String status;
    public String message;
    public String code;

    public SourcesResponse() {
    }

    public void setSources(List<SourcesItem> sources) {
        this.sources = sources;
    }

    public List<SourcesItem> getSources() {
        return this.sources;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return this.status;
    }

    public String toString() {
        return "SourcesResponse{sources = '" + this.sources + '\'' + ",status = '" + this.status + '\'' + "}";
    }
}
