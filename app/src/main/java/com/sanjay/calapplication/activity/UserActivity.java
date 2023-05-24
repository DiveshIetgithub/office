package com.sanjay.calapplication.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.sanjay.calapplication.InterfaceApi;
import com.sanjay.calapplication.R;
import com.sanjay.calapplication.adapters.UserRecyclerViewAdapter;
import com.sanjay.calapplication.api.ApiUser;
import com.sanjay.calapplication.databinding.ActivityUserBinding;
import com.sanjay.calapplication.models.UserModel;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UserActivity extends AppCompatActivity {
    ActivityUserBinding binding;
    /*UserRecyclerViewAdapter userRecyclerViewAdapter;
    LinearLayoutManager linearLayoutManager;
    ArrayList<UserModel> models = new ArrayList<>();
    InterfaceApi interfaceApi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityUserBinding.inflate(getLayoutInflater());
        userRecyclerViewAdapter = new UserRecyclerViewAdapter(this,models);


        linearLayoutManager = new LinearLayoutManager(this);
        binding.recyclerView.setLayoutManager(linearLayoutManager);
        binding.recyclerView.setAdapter(userRecyclerViewAdapter);



        View view = binding.getRoot();
        setContentView(view);


        InterfaceApi serviceApi = ApiUser.getUser().create(InterfaceApi.class);
        Call<UserModel> call = serviceApi.models();
        Log.e("dasdas",""+call);
        call.enqueue(new Callback<UserModel>() {
            @Override
            public void onResponse(Call<UserModel> call, Response<UserModel> response) {
                if(response.body()!=null)
                {
                    userRecyclerViewAdapter = new UserRecyclerViewAdapter(UserActivity.this,models);
                    binding.recyclerView.setLayoutManager(linearLayoutManager);
                    binding.recyclerView.setAdapter(userRecyclerViewAdapter);
                    binding.recyclerView.setAdapter(userRecyclerViewAdapter);

                    Toast.makeText(UserActivity.this, "hjdsbhulh", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(UserActivity.this, "data not found in recyclerview", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<UserModel> call, Throwable t) {

            }
        });

    }
*/

}