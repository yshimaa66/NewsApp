package com.example.newsapp;

import android.annotation.SuppressLint;
import android.app.SearchManager;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.SearchView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.newsapp.Model.ArticlesItem;
import com.example.newsapp.Model.NewsResponse;
import com.example.newsapp.Model.SourcesItem;
import com.example.newsapp.Model.SourcesResponse;
import com.example.newsapp.Remote.RetrofitClient;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements SearchView.OnQueryTextListener {

    public ProgressBar progressBar;
    public TabLayout tabLayout;
    public Toolbar toolbar;
    public RecyclerView recyclerView;
    public NewsAdapter adapter;
    public List<ArticlesItem> newslist;
    protected ConstraintLayout main;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        super.setContentView(R.layout.activity_main);





        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);



        progressBar = findViewById(R.id.progress_bar);
        tabLayout = findViewById(R.id.tablayout);
        recyclerView = findViewById(R.id.sources_rcview);

        getSources();



        tabLayout.setBackgroundColor(getResources().getColor(R.color.colorPrimaryBlue));

        toolbar.setBackgroundColor(getResources().getColor(R.color.colorPrimaryDarkBlue));

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        newslist = new ArrayList<>();

        adapter = new NewsAdapter(newslist, this);

        recyclerView.setAdapter(adapter);



    }


    public void getSources() {

        RetrofitClient.getClient().getNewsSources(Constants.Api_key)
                .enqueue(new Callback<SourcesResponse>() {
                    @Override
                    public void onResponse(Call<SourcesResponse> call, Response<SourcesResponse> response) {

                        if ("ok".equals(response.body().getStatus())) {

                            List<SourcesItem> sourcesItems = response.body().getSources();

                            initTablayout(sourcesItems);

                        } else {

                            Toast.makeText(MainActivity.this, response.body().message, Toast.LENGTH_SHORT).show();

                        }


                    }

                    @Override
                    public void onFailure(Call<SourcesResponse> call, Throwable t) {

                        Toast.makeText(MainActivity.this, "Please try again later"

                                        + " as " + t.getLocalizedMessage()

                                , Toast.LENGTH_SHORT).show();

                    }
                });


    }

    private void initTablayout(List<SourcesItem> sourcesItems) {


        for (SourcesItem source : sourcesItems) {


            TabLayout.Tab tab = tabLayout.newTab();
            tab.setText(source.getName());
            tab.setTag(source);
            tabLayout.addTab(tab);


        }


        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {


                SourcesItem sourcesItem = ((SourcesItem) tab.getTag());
                String sourceId = sourcesItem.getId();
                getNewsbyId(sourceId);


            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

    }

    public List<ArticlesItem> newsListt;

    private void getNewsbyId(String sourceId) {

        RetrofitClient.getClient().getNewsBySourceId(Constants.Api_key, sourceId)
                .enqueue(new Callback<NewsResponse>() {
                    @Override
                    public void onResponse(Call<NewsResponse> call, Response<NewsResponse> response) {

                        progressBar.setVisibility(View.GONE);

                        if ("ok".equals(response.body().getStatus())) {

                            List<ArticlesItem> newsList = response.body().getArticles();

                            newsListt = newsList;

                            adapter.changeData(newsList);


                        } else {

                            Toast.makeText(MainActivity.this, "Something went wrong", Toast.LENGTH_SHORT).show();

                        }


                    }

                    @Override
                    public void onFailure(Call<NewsResponse> call, Throwable t) {


                        Toast.makeText(MainActivity.this, "Please try again later"

                                        + " as " + t.getLocalizedMessage()

                                , Toast.LENGTH_SHORT).show();


                    }
                });


    }


    @SuppressLint("ResourceType")
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
/*
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.id.action_search,menu);

        MenuItem searchitem = menu.findItem(R.id.action_search);
        SearchView searchView = (SearchView) searchitem.getActionView();

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                adapter.getFilter().filter(newText);
                return false;
            }
        });
*/

        SearchManager searchManager =
                (SearchManager) getSystemService(this.SEARCH_SERVICE);
        SearchView searchView = (SearchView) menu.findItem(R.id.action_search)
                .getActionView();
        searchView.setSearchableInfo(searchManager
                .getSearchableInfo(getComponentName()));
        searchView.setOnQueryTextListener(this);


        return true;
    }


    @Override
    public boolean onQueryTextSubmit(String query) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {

        newText = newText.toLowerCase();
        List<ArticlesItem> newList = new ArrayList<>();

        progressBar.setVisibility(View.VISIBLE);
        for (ArticlesItem article : newsListt) {
            String newsString = article.getTitle().toLowerCase();


            if (newsString.contains(newText)) {

                progressBar.setVisibility(View.GONE);
                newList.add(article);
            }
        }

        adapter.updateList(newList);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.red) {



            tabLayout.setBackgroundColor(getResources().getColor(R.color.colorPrimaryRed));

            toolbar.setBackgroundColor(getResources().getColor(R.color.colorPrimaryDarkRed));

            //menu.setBackgroundColor(getResources().getColor(R.color.colorAccent));



            //setTheme(R.style.RedTheme);



        }


        if (id == R.id.blue) {



            tabLayout.setBackgroundColor(getResources().getColor(R.color.colorPrimaryBlue));

            toolbar.setBackgroundColor(getResources().getColor(R.color.colorPrimaryDarkBlue));

            //menu.setBackgroundColor(getResources().getColor(R.color.colorAccent));



            //setTheme(R.style.RedTheme);



        }


        if (id == R.id.green) {



            tabLayout.setBackgroundColor(getResources().getColor(R.color.colorPrimaryGreen));

            toolbar.setBackgroundColor(getResources().getColor(R.color.colorPrimaryDarkGreen));

            //menu.setBackgroundColor(getResources().getColor(R.color.colorAccent));



            //setTheme(R.style.RedTheme);



        }


        if (id == R.id.Orange) {



            tabLayout.setBackgroundColor(getResources().getColor(R.color.colorPrimaryOrange));

            toolbar.setBackgroundColor(getResources().getColor(R.color.colorPrimaryDarkOrange));

            //menu.setBackgroundColor(getResources().getColor(R.color.colorAccent));



            //setTheme(R.style.RedTheme);



        }


        if (id == R.id.pink) {



            tabLayout.setBackgroundColor(getResources().getColor(R.color.colorPrimaryPink));

            toolbar.setBackgroundColor(getResources().getColor(R.color.colorPrimaryDarkPink));

            //menu.setBackgroundColor(getResources().getColor(R.color.colorAccent));



            //setTheme(R.style.RedTheme);



        }


        if (id == R.id.purple) {



            tabLayout.setBackgroundColor(getResources().getColor(R.color.colorPrimaryPurple));

            toolbar.setBackgroundColor(getResources().getColor(R.color.colorPrimaryDarkPurple));

            //menu.setBackgroundColor(getResources().getColor(R.color.colorAccent));



            //setTheme(R.style.RedTheme);



        }

        if (id == R.id.yellow) {



            tabLayout.setBackgroundColor(getResources().getColor(R.color.colorPrimaryYellow));

            toolbar.setBackgroundColor(getResources().getColor(R.color.colorPrimaryDarkYellow));

            //menu.setBackgroundColor(getResources().getColor(R.color.colorAccent));



            //setTheme(R.style.RedTheme);



        }





        return super.onOptionsItemSelected(item);
    }



}
