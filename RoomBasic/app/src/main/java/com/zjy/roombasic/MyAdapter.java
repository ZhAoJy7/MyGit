package com.zjy.roombasic;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    List<Word> allWords=new ArrayList<>();

    public MyAdapter(boolean useCardView) {
        this.useCardView = useCardView;
    }

    boolean useCardView=false;

    public void setAllWords(List<Word> allWords) {
        this.allWords = allWords;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater=LayoutInflater.from(parent.getContext());
        View itemView=layoutInflater.inflate(R.layout.cell_normal,parent,false);
        if(useCardView){
            itemView=layoutInflater.inflate(R.layout.cell_card,parent,false);
        }
        return new MyViewHolder(itemView);
        //return null;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Word word=allWords.get(position);
        holder.tv_id.setText(String.valueOf(position+1));
        holder.tv_CH.setText(word.getMeaning());
        holder.tv_EN.setText(word.getWord());
    }

    @Override
    public int getItemCount() {
        return allWords.size();
    }

    static class MyViewHolder extends RecyclerView.ViewHolder{
        TextView tv_CH,tv_EN,tv_id;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_CH=itemView.findViewById(R.id.textView_CH);
            tv_id=itemView.findViewById(R.id.textView_id);
            tv_EN=itemView.findViewById(R.id.textView_EN);

        }
    }
}

