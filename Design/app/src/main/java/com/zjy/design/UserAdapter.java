package com.zjy.design;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Switch;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.UserViewHolder> {


    private List<User> userList;
    public UserAdapter(List<User> userList){
        this.userList=userList;
    }

    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView=LayoutInflater.from(parent.getContext()).inflate(R.layout.useritem,parent,false);
        UserViewHolder userViewHolder=new UserViewHolder(itemView);
        return userViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHolder holder, int position) {
        User user=userList.get(position);
        holder.username.setText(user.getUserName());
        holder.id.setText(Integer.toString(user.getId()));
    }

    @Override
    public int getItemCount() {
        return userList.size();
    }

    class UserViewHolder extends RecyclerView.ViewHolder{
        TextView username;
        TextView id;
        Switch aSwitch;

        public UserViewHolder(View itemView) {
            super(itemView);
            this.username = itemView.findViewById(R.id.textView_username);
            this.id = itemView.findViewById(R.id.textView_id);
            aSwitch=itemView.findViewById(R.id.switch_ban);
        }
    }
}
