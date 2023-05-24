package com.sanjay.calapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.sanjay.calapplication.api.ApiClient;
import com.sanjay.calapplication.api.User;
import com.sanjay.calapplication.databinding.ActivityForApiBinding;

//import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ActivityForApi extends AppCompatActivity implements View.OnClickListener {
      ActivityForApiBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityForApiBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        binding.btnApi.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        if(view==binding.btnApi)
        {
          apiTest();
            Log.e("TAG", "onClick: " );
        }

    }
    public void apiTest()
    {
        Log.e("TAG", "apiTest: " );
        InterfaceApi apiService = ApiClient.getClient().create(InterfaceApi.class);

        Call<User> call = apiService.api(binding.etUserName.getText().toString(),binding.etPassword.getText().toString(),"password");

        call.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                if(response.body()!=null){
                    Toast.makeText(ActivityForApi.this, "Divesh", Toast.LENGTH_SHORT).show();
                    Log.e("", "onResponse: "+response.body().getAccess_token());
                    Log.e("TAG", "onResponse: "+response.body().getExpires_in());
                    Log.e("TAG", "onResponse: "+response.body().getToken_type());
                }
                else
                {
                    Toast.makeText(ActivityForApi.this, "error", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {

            }
        });
    }
}