package com.sanjay.calapplication.viewModel;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.sanjay.calapplication.InterfaceApi;
import com.sanjay.calapplication.api.ApiUser;
import com.sanjay.calapplication.models.UserModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UserModelListViewModel extends ViewModel {
    private final MutableLiveData<List<UserModel>> userModelList;
    public UserModelListViewModel()
    {
        userModelList = new MutableLiveData<>();
    }
    public MutableLiveData<List<UserModel>> getUserModelListObserver()
    {
        return userModelList;
    }

    public void makeApiCall()
    {
        InterfaceApi serviceApi = ApiUser.getUser().create(InterfaceApi.class);
        Call<List<UserModel>> call = serviceApi.getUsermodel();
        call.enqueue(new Callback<List<UserModel>>() {
            @Override
            public void onResponse(@NonNull Call<List<UserModel>> call, @NonNull Response<List<UserModel>> response) {
               userModelList.postValue(response.body());
            }

            @Override
            public void onFailure(@NonNull Call<List<UserModel>> call, @NonNull Throwable t) {
               userModelList.postValue(null);
            }
        });

    }
}
