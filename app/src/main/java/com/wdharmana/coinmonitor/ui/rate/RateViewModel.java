package com.wdharmana.coinmonitor.ui.rate;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.google.gson.Gson;
import com.wdharmana.coinmonitor.BuildConfig;
import com.wdharmana.coinmonitor.model.RateResponse;
import com.wdharmana.coinmonitor.service.EndpointService;
import com.wdharmana.coinmonitor.service.RetrofitClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RateViewModel extends ViewModel {

    String TAG =  RateViewModel.class.getSimpleName();

    public MutableLiveData<RateResponse> rateLiveData = new MutableLiveData<>();
    public MutableLiveData<Boolean> showLoader = new MutableLiveData<>();

    void getExchangeRate(String coinCode) {

        showLoader.postValue(true);

        EndpointService client = RetrofitClient.getRetrofitInstance().create(EndpointService.class);

        Call<RateResponse> call = client.getRateByCode(coinCode);
        call.enqueue(new Callback<RateResponse>() {
            @Override
            public void onResponse(Call<RateResponse> call, Response<RateResponse> response) {

                showLoader.postValue(false);

                if(response.isSuccessful()) {
                    RateResponse rateResponse = response.body();
                    rateLiveData.postValue(rateResponse);
                }
                Log.e(TAG, new Gson().toJson(response));

            }

            @Override
            public void onFailure(Call<RateResponse> call, Throwable t) {

                showLoader.postValue(false);
                Log.e(TAG, new Gson().toJson(t));

            }
        });

    }

}
