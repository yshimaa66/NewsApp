//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.example.newsapp.Remote;

import com.example.newsapp.Interface.NewsService;
import retrofit2.Retrofit;
import retrofit2.Retrofit.Builder;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {
    private static Retrofit retrofit;

    public RetrofitClient() {
    }

    public static Retrofit getInstance() {
        String baseurl = "https://newsapi.org/v2/";
        if (retrofit == null) {
            retrofit = (new Builder()).baseUrl(baseurl).addConverterFactory(GsonConverterFactory.create()).build();
        }

        return retrofit;
    }

    public static NewsService getClient() {
        return (NewsService)getInstance().create(NewsService.class);
    }
}
