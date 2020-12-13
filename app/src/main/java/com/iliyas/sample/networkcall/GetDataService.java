package com.iliyas.sample.networkcall;

import com.iliyas.sample.models.FoodItemData;

import retrofit2.Call;
import retrofit2.http.GET;

public interface GetDataService {
    @GET("data/restarunt/details/")
    Call<FoodItemData> getApiData();
}
