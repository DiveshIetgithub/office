package com.sanjay.calapplication.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.hardware.lights.LightState;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.sanjay.calapplication.InterfaceApi;
import com.sanjay.calapplication.R;
import com.sanjay.calapplication.adapters.TestRecyclerViewAdapter;
import com.sanjay.calapplication.adapters.UserRecyclerViewAdapter;
import com.sanjay.calapplication.api.ApiUser;
import com.sanjay.calapplication.models.UserModel;
import com.sanjay.calapplication.viewModel.UserModelListViewModel;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TestActivity extends AppCompatActivity {
    RecyclerView recycler;
    ArrayList<List<UserModel>> userModelList= new ArrayList<>();
    UserModelListViewModel userModelListViewModel;
    TestRecyclerViewAdapter adapter;
    UserRecyclerViewAdapter userRecyclerViewAdapter;
    LinearLayoutManager linearLayoutManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        recycler = findViewById(R.id.recycler);

        recycler.setLayoutManager(new LinearLayoutManager(this));
        // recycler.addItemDecoration(this, DividerItemDecoration.VERTICAL);
        //adapter = new TestRecyclerViewAdapter(userModelList);


        apppp();

        // userModelListViewModel=ViewModelProviders.of(this).get(UserModelListViewModel.class);
        /*userModelListViewModel = ViewModelProviders.of(this).get(UserModelListViewModel.class);
        userModelListViewModel.getUserModelListObserver().observe(this, new Observer<List<UserModel>>() {
            @Override
            public void onChanged(List<UserModel> userModels) {
                if(userModels!=null)
                {
                    userModelList=userModels;
                    adapter.updateuserlist(userModels);
                }
                if(userModels==null)
                {
                    recycler.setVisibility(View.GONE);

                }
            }
        });
        userModelListViewModel.makeApiCall();

    }*/


    }

    public void apppp(){
        userModelList.clear();
        InterfaceApi interfaceApi = ApiUser.getUser().create(InterfaceApi.class);
        Call<List<UserModel>> call = interfaceApi.getUsermodel();
        call.enqueue(new Callback<List<UserModel>>() {
            @Override
            public void onResponse(Call<List<UserModel>> call, Response<List<UserModel>> response) {
                if(response.body() != null){
                    List<UserModel> userModelArrayList = response.body();
                    userModelList.add(response.body());

                    Log.e("dfjbvgdj",""+response.body());

                    userRecyclerViewAdapter = new UserRecyclerViewAdapter(TestActivity.this, userModelArrayList);
                    linearLayoutManager = new LinearLayoutManager(TestActivity.this);

                    recycler.setLayoutManager(linearLayoutManager);
                    recycler.setAdapter(userRecyclerViewAdapter);
                    userRecyclerViewAdapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onFailure(Call<List<UserModel>> call, Throwable t) {

            }
        });


    }
}