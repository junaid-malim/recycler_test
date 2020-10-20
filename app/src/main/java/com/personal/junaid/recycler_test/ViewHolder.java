package com.personal.junaid.recycler_test;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Cache;
import com.squareup.picasso.LruCache;
import com.squareup.picasso.Picasso;

public class ViewHolder extends RecyclerView.ViewHolder {

    View mView;

    public ViewHolder(@NonNull View itemView) {
        super(itemView);

        mView=itemView;

    }

    public void setDetails(MainActivity context,String name, String price, String image){

        TextView tvname=mView.findViewById(R.id.name);
        TextView tvprice=mView.findViewById(R.id.price);
        ImageView ivimage=mView.findViewById(R.id.image);

        tvname.setText(name);
        tvprice.setText(price);

        Picasso p=new Picasso.Builder(context).memoryCache(new LruCache(240000)).build();
        p.load(image).resize(1080,1080).centerInside().placeholder(R.drawable.progress_animation).error(R.drawable.error_icon).into(ivimage);

    }

}
