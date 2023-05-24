package com.sanjay.calapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.sanjay.calapplication.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    ActivityMainBinding binding;

    double ans = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        //  binding.btnPlus.setOnClickListener( this);
        binding.btnPlus.setOnClickListener(this);
        binding.btnMinus.setOnClickListener(this);
        binding.btnDivide.setOnClickListener(this);
        binding.btnMultiply.setOnClickListener(this);
        binding.modulo.setOnClickListener(this);
        binding.etPlace1.setOnClickListener(this);
        binding.etPlace2.setOnClickListener(this);
        binding.etPlace3.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        if (view == binding.btnPlus) {
            double a = Double.parseDouble(binding.etPlace1.getText().toString());
            double b = Double.parseDouble(binding.etPlace2.getText().toString());
            ans = a +b;
            Log.d("", "Successfully added"+ans);
        } else {
            Log.d("TAG", "adding error: ");
        }
        if (view == binding.btnMinus) {
            double a = Double.parseDouble(binding.etPlace1.getText().toString());
            double b = Double.parseDouble(binding.etPlace2.getText().toString());
            ans = a -b;
            Log.e("", "Successfully minus"+ans);
        } else {
            Log.d("TAG", "minus error: ");
        }

        if (view == binding.btnMultiply) {
            double a = Double.parseDouble(binding.etPlace1.getText().toString());
            double b = Double.parseDouble(binding.etPlace2.getText().toString());
            ans = a *b;
            Log.e("", "Successfully multiplied"+ans);
        } else {
            Log.d("TAG", "multiply error: ");
        }

        if (view == binding.btnDivide) {
            double a = Double.parseDouble(binding.etPlace1.getText().toString());
            double b = Double.parseDouble(binding.etPlace2.getText().toString());
            ans = a/b;
            Log.e("", "Successfully divided"+ans);
        } else {
            Log.d("TAG", "divide error: ");
        }

    }
}