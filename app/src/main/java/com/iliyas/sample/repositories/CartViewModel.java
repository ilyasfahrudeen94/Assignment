package com.iliyas.sample.repositories;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.iliyas.sample.models.FoodItemData;

import java.util.ArrayList;

public class CartViewModel extends ViewModel {

    private final MutableLiveData<FoodItemData> selectedItem = new MutableLiveData<FoodItemData>();
    public void selectItem(FoodItemData item) {
        selectedItem.setValue(item);
    }
    public LiveData<FoodItemData> getSelectedItem() {
        return selectedItem;
    }


}