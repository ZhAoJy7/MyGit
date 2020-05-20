package com.zjy.design;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    private List<Picture> pictureList;

    public MyAdapter(List<Picture> pictureList){
        this.pictureList=pictureList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView= LayoutInflater.from(parent.getContext()).inflate(R.layout.pictureitem,parent,false);
        MyViewHolder myViewHolder=new MyViewHolder(itemView);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Picture picture=pictureList.get(position);
        holder.username.setText(picture.getUsername());
        holder.pictureItem.setImageBitmap(picture.getBitmap());
    }

    @Override
    public int getItemCount() {
        return pictureList.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{
        TextView username;
        Button button;
        ImageView pictureItem;

        public MyViewHolder(View itemView) {
            super(itemView);
            this.username = itemView.findViewById(R.id.textView_username);
            this.button = itemView.findViewById(R.id.button);
            this.pictureItem = itemView.findViewById(R.id.imageView);
        }
    }
}
