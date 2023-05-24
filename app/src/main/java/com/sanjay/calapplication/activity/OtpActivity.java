package com.sanjay.calapplication.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.PhoneAuthOptions;
import com.sanjay.calapplication.R;
import com.sanjay.calapplication.databinding.ActivityOtpBinding;

public class OtpActivity extends AppCompatActivity {

    ActivityOtpBinding otpBinding;
    private EditText edtPhone, edtOTP;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        otpBinding = ActivityOtpBinding.inflate(getLayoutInflater());
        View view = otpBinding.getRoot();
        setContentView(view);
        edtPhone = findViewById(R.id.et_mobile);
        edtOTP = findViewById(R.id.et_otp);
        otpBinding.btnButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (TextUtils.isEmpty(edtPhone.getText().toString()))
                {
                    Toast.makeText(OtpActivity.this, "Enter the valid mobile number", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    String phone = "+91" + edtPhone.getText().toString();
                    Log.d("TAG", "onClick: "+ phone);
                }

            }
        });
    }

    }
}