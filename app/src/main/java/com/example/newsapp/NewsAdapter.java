package com.example.newsapp;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.newsapp.Model.ArticlesItem;

import java.util.ArrayList;
import java.util.List;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.Viewholder>  {

    List<ArticlesItem> newslist;
    Context context;


    public NewsAdapter(List<ArticlesItem> newslist, Context context) {
        this.newslist = newslist;
        this.context = context;
    }

    @NonNull
    @Override
    public Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_news,parent,false);


        return new Viewholder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull Viewholder holder, final int position) {

        final ArticlesItem articlesItem = newslist.get(position);

        String replacedZ = articlesItem.getPublishedAt().replace("Z", "  ");

        String replacedT = replacedZ.replace("T", " ");


        holder.time.setText(replacedT);
        holder.title.setText(articlesItem.getTitle());
        Glide.with(holder.itemView).load(articlesItem.getUrlToImage()).into(holder.articleImage);

        holder.desc.setText(articlesItem.getDescription());


        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {




                Intent i = new Intent(context, ArticleBody.class);
                i.putExtra("url", articlesItem.getUrl());
                context.startActivity(i);


            }
        });

        holder.sharebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
                sharingIntent.setType("text/plain");
                String shareBody = articlesItem.getUrl();
                sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "Subject Here");
                sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, shareBody);
                context.startActivity(Intent.createChooser(sharingIntent, "Share via"));



            }
        });


    }

    @Override
    public int getItemCount() {
        return newslist== null ? 0 : newslist.size();
    }

    public void changeData(List<ArticlesItem> newsList) {

        this.newslist=newsList;
        notifyDataSetChanged();

    }


    public class Viewholder extends RecyclerView.ViewHolder {



        public TextView time;
        public TextView title;
        public ProgressBar progressBar;
        public ImageView articleImage;
        public TextView desc;
        public Button sharebtn;

        public Viewholder(@NonNull View itemView) {
            super(itemView);


            time =  itemView.findViewById(R.id.time);
            title =  itemView.findViewById(R.id.title);
            progressBar = itemView.findViewById(R.id.progress_bar);
            articleImage = itemView.findViewById(R.id.article_image);
            desc =  itemView.findViewById(R.id.desc);
            sharebtn=itemView.findViewById(R.id.sharebtn);

        }
    }

    public void updateList(List<ArticlesItem>  newList){


        newslist = new ArrayList<>();
        newslist.addAll(newList);
        notifyDataSetChanged();


    }
}
