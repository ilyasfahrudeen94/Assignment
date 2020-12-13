package com.iliyas.sample;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.TextView;

import com.iliyas.sample.adapters.CartListAdapter;
import com.iliyas.sample.models.FoodItemData;

import java.util.ArrayList;

public class CartActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    CartListAdapter cartListAdapter;
    ArrayList<FoodItemData> myList;
    TextView total;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        myList = (ArrayList<FoodItemData>) getIntent().getSerializableExtra("my_cart");

        recyclerView = findViewById(R.id.rv_cart_list);
        cartListAdapter = new CartListAdapter(this, myList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(cartListAdapter);

        total = findViewById(R.id.tv_total);
        total.setText("$ "+getTotal());

    }

    private double getTotal(){
        double total = 0.0;
        if(myList != null){
            for(int i = 0; i <=myList.size(); i++){
                total =total +(i * 13);
            }
        }
        return total;
    }
}