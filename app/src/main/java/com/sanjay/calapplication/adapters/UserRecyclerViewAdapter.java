package com.sanjay.calapplication.adapters;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.sanjay.calapplication.R;
import com.sanjay.calapplication.activity.UserActivity;
import com.sanjay.calapplication.databinding.ItemBinding;
import com.sanjay.calapplication.models.UserModel;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class UserRecyclerViewAdapter extends RecyclerView.Adapter<UserRecyclerViewAdapter.ViewHolder> {

    Context context;
    List<UserModel> userModels;

    public UserRecyclerViewAdapter(Context context, List<UserModel> userModels) {
        this.context = context;
        this.userModels = userModels;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item,parent,false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        UserModel userModel = userModels.get(position);

        holder.body.setText(userModel.getBody());
        holder.id.setText(userModel.getId());
        holder.userId.setText(userModel.getUserId());
        holder.title.setText(userModel.getTitle());
    }

    @Override
    public int getItemCount() {
        return userModels.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        TextView userId;
        TextView id;
        TextView title;
        TextView body;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            userId = itemView.findViewById(R.id.tv_user_id);
            id = itemView.findViewById(R.id.tv_id);
            title = itemView.findViewById(R.id.tv_title);
            body = itemView.findViewById(R.id.tv_body);
        }
    }


}
