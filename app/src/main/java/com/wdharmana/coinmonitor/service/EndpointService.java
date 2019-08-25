package com.wdharmana.coinmonitor.service;

import com.wdharmana.coinmonitor.BuildConfig;
import com.wdharmana.coinmonitor.model.RateResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.Path;

public interface EndpointService {

    @Headers("X-CoinAPI-Key: "+ BuildConfig.COIN_API_KEY)
    @GET("exchangerate/{id}")
    Call<RateResponse> getRateByCode(@Path("id") String id);

}
