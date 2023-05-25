package com.sanjay.calapplication.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.sanjay.calapplication.InterfaceApi;
import com.sanjay.calapplication.R;
import com.sanjay.calapplication.api.ApiUser;
import com.sanjay.calapplication.databinding.ActivityOtpBinding;
import com.sanjay.calapplication.models.OtpModel;
import com.sanjay.calapplication.models.UserModel;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class OtpActivity extends AppCompatActivity {

    ActivityOtpBinding otpBinding;
    private EditText edtPhone, edtOTP;
    ArrayList<List<OtpModel>> otpModelList = new ArrayList();
    LinearLayoutManager linearLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        otpBinding = ActivityOtpBinding.inflate(getLayoutInflater());
        View view = otpBinding.getRoot();
        setContentView(view);
        edtPhone = findViewById(R.id.et_mobile);
        edtOTP = findViewById(R.id.et_otp);
        edtPhone.setLayoutParams(edtPhone.getLayoutParams());

        apppp();
        otpBinding.btnButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (TextUtils.isEmpty(edtPhone.getText().toString())) {
                    Toast.makeText(OtpActivity.this, "Enter the valid mobile number", Toast.LENGTH_SHORT).show();
                } else {
                    String phone = "+91" + edtPhone.getText().toString();
                    Log.d("TAG", "onClick: " + phone);
                }

            }
        });
    }

    private void apppp() {

        InterfaceApi interfaceApi = ApiUser.getUser().create(InterfaceApi.class);
        Call<List<OtpModel>> call = interfaceApi.getOtpModel();
        call.enqueue(new Callback<List<OtpModel>>() {
            @Override
            public void onResponse(Call<List<OtpModel>> call, Response<List<OtpModel>> response) {
                if(response.body()!=null)
                {
                    List<OtpModel> otpModelArrayList = response.body();
                    otpModelList.add(response.body());
                    Log.e("TAG", "onResponse: "+response.body() );
                    linearLayoutManager = new LinearLayoutManager(OtpActivity.this);
                }
            }

            @Override
            public void onFailure(Call<List<OtpModel>> call, Throwable t) {

            }
        });
    }

}