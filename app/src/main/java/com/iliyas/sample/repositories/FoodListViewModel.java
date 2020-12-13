package com.iliyas.sample.repositories;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.iliyas.sample.models.FoodItemData;
import com.iliyas.sample.networkcall.GetDataService;
import com.iliyas.sample.networkcall.RetrofitInstance;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FoodListViewModel extends ViewModel {

    MutableLiveData<ArrayList<FoodItemData>> userLiveData;
    MutableLiveData<ArrayList<FoodItemData>> userLiveData2;
    ArrayList<FoodItemData> foodItemArrayList;
    ArrayList<FoodItemData> foodItemArrayList2;


    public FoodListViewModel() {
        userLiveData = new MutableLiveData<>();

        // call your Rest API in init method
        init();
    }

    public MutableLiveData<ArrayList<FoodItemData>> getUserMutableLiveData() {
        return userLiveData;
    }


    public void init(){
        populateListOne();
        apiCall();
        userLiveData.setValue(foodItemArrayList);
    }

    public void populateListOne(){
        foodItemArrayList = new ArrayList<>();
        foodItemArrayList.add(new FoodItemData("Pepporani","Chicken, Ham, Pineapple", "300grams, 36cm", "https://drop.ndtv.com/albums/COOKS/pasta-vegetarian/pastaveg_640x480.jpg", 0, "001"));
        foodItemArrayList.add(new FoodItemData("Double Cheese","Cheese", "140 grams, 40cm", "https://simply-delicious-food.com/wp-content/uploads/2017/10/easy-tomato-cream-rigatoni-3.jpg", 0, "001"));
        foodItemArrayList.add(new FoodItemData("Singaporia","Pineapple, Chicken, Mutton", "125 grams, 30cm", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRd3u3AEijb7C3Vaidi2316Nkp58asI2Xz1jQ&usqp=CAU", 0, "001"));
        foodItemArrayList.add(new FoodItemData("Brust Pasta","Cheese, Chicken, Capsicum", "300 grams, 25cm", "https://drop.ndtv.com/albums/COOKS/pasta-vegetarian/pastaveg_640x480.jpg", 0, "001"));

    }

    private void apiCall(){
        GetDataService service = RetrofitInstance.getRetrofitInstance().create(GetDataService.class);

        /** Call the method with parameter in the interface to get the notice data*/
        Call<FoodItemData > call = service.getApiData();

        call.enqueue(new Callback<FoodItemData>() {
            @Override
            public void onResponse(Call<FoodItemData> call, Response<FoodItemData> response) {
                //Here we get response so we can update the view accordingly
            }

            @Override
            public void onFailure(Call<FoodItemData> call, Throwable t) {

            }
        });
    }




}
