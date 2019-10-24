//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.example.newsapp.Interface;

import com.example.newsapp.Model.ArticlesItem;
import com.example.newsapp.Model.NewsResponse;
import com.example.newsapp.Model.SourcesResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface NewsService {
    @GET("sources")
    Call<SourcesResponse> getNewsSources(@Query("apiKey") String apiKey);


    @GET("everything")
    Call<NewsResponse> getNewsBySourceId(@Query("apiKey") String apiKey
            ,@Query("sources") String sourceId);


}
