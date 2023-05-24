package com.sanjay.calapplication;

import com.sanjay.calapplication.api.User;
import com.sanjay.calapplication.models.OtpModel;
import com.sanjay.calapplication.models.UserModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface InterfaceApi {
    @FormUrlEncoded
    @POST("token")
    Call<User> api(@Field("UserName") String username,@Field("Password") String password,@Field("grant_type") String grant_type);

     @GET("posts")
    Call<List<UserModel>> getUsermodel();

    Call<UserModel> models();

//    Call<UserModel> models();
    @GET("QueryStringReceiver")
    Call<List<OtpModel>> getOtpModel();
}
