package com.sanjay.calapplication.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.sanjay.calapplication.R;
import com.sanjay.calapplication.models.UserModel;

import java.util.List;

public class TestRecyclerViewAdapter extends RecyclerView.Adapter<TestRecyclerViewAdapter.MyViewHolder> {

     List<UserModel> userModelList;

    public TestRecyclerViewAdapter(List<UserModel> userModelList) {
        this.userModelList = userModelList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        holder.userId.setText(userModelList.get(position).getUserId());
        holder.id.setText(userModelList.get(position).getId());
        holder.title.setText(userModelList.get(position).getTitle());
        holder.body.setText(userModelList.get(position).getBody());
    }

    @Override
    public int getItemCount() {
        if(userModelList!=null)
        {
           return this.userModelList.size();
        }
        else
        return 0;
    }

    public void updateuserlist(List<UserModel> userModels) {
        this.userModelList =userModelList;
        notifyDataSetChanged();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        TextView userId;
        TextView id;
        TextView title;
        TextView body;
        public MyViewHolder(@NonNull View itemView) {

            super(itemView);
            userId = itemView.findViewById(R.id.tv_user_id);
            id = itemView.findViewById(R.id.tv_id);
            title = itemView.findViewById(R.id.tv_title);
            body = itemView.findViewById(R.id.tv_body);
        }
    }
}
