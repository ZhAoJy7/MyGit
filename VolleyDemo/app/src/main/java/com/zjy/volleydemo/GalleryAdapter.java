package com.zjy.volleydemo;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import io.supercharge.shimmerlayout.ShimmerLayout;

public class GalleryAdapter extends ListAdapter<item,MyViewHolder> {

    protected GalleryAdapter(@NonNull DiffUtil.ItemCallback<item> DIFFCALLBACK) {
        super(DIFFCALLBACK);
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
         MyViewHolder holder= new MyViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.gallery_cell, parent));
         holder.itemView.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {

             }
         });
         return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        ShimmerLayout shimmerLayout=holder.itemView.findViewById(R.id.shimmerLayoutCell);
        shimmerLayout.setShimmerColor(0x55ffffff);
        shimmerLayout.setShimmerAngle(0);
        shimmerLayout.startShimmerAnimation();
        ImageView imageView=holder.itemView.findViewById(R.id.imageView);
        Glide.with(holder.itemView)
                .load(getItem(position).previewUrl)
                .placeholder(R.drawable.ic_photo_black_24dp)
                .into(imageView);
    }

    class DIFFCALLBACK extends DiffUtil.ItemCallback<item>{

        @Override
        public boolean areItemsTheSame(@NonNull item oldItem, @NonNull item newItem) {
            return oldItem==newItem;
        }

        @Override
        public boolean areContentsTheSame(@NonNull item oldItem, @NonNull item newItem) {
            return oldItem.id==newItem.id;
        }
    }
}
class MyViewHolder extends RecyclerView.ViewHolder {
    public MyViewHolder(@NonNull View itemView) {
        super(itemView);
    }
}