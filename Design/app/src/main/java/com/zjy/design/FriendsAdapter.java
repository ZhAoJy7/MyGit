package com.zjy.design;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Switch;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class FriendsAdapter extends RecyclerView.Adapter<FriendsAdapter.FriendsViewHolder> {

    private List<User> userList;
    public FriendsAdapter(List<User> userList){
        this.userList=userList;
    }

    @NonNull
    @Override
    public FriendsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView= LayoutInflater.from(parent.getContext()).inflate(R.layout.friendsitem,parent,false);
        FriendsAdapter.FriendsViewHolder friendsViewHolder=new FriendsAdapter.FriendsViewHolder(itemView);
        return friendsViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull FriendsViewHolder holder, int position) {
        User user=userList.get(position);
        holder.username.setText(user.getUserName());
        holder.id.setText(Integer.toString(user.getId()));
    }



    @Override
    public int getItemCount() {
        return userList.size();
    }
    class FriendsViewHolder extends RecyclerView.ViewHolder{
        TextView username;
        TextView id;
        Button btn_cancel;

        public FriendsViewHolder(View itemView) {
            super(itemView);
            this.username = itemView.findViewById(R.id.textView_username);
            this.id = itemView.findViewById(R.id.textView_id);
            this.btn_cancel=itemView.findViewById(R.id.btn_cancel);
        }
    }
}
