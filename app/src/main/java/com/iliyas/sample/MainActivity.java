package com.iliyas.sample;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.andremion.counterfab.CounterFab;
import com.iliyas.sample.fragments.OverViewFragment;
import com.iliyas.sample.fragments.SlideImageFragment;
import com.iliyas.sample.models.FoodItemData;
import com.iliyas.sample.networkcall.GetDataService;
import com.iliyas.sample.networkcall.RetrofitInstance;
import com.iliyas.sample.repositories.CartViewModel;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity{

    CounterFab fab_btn;
    CartViewModel viewModel;
    ArrayList<FoodItemData> cartArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        new SlideImageFragment();

        loadFragment(new OverViewFragment());

        fab_btn = findViewById(R.id.cart_fab);

        fab_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(cartArrayList.size() != 0) {
                    Intent intent = new Intent(MainActivity.this, CartActivity.class);
                    intent.putExtra("my_cart", cartArrayList);
                    startActivity(intent);
                } else {
                    Toast.makeText(MainActivity.this, "Cart Empty", Toast.LENGTH_LONG).show();
                }
            }
        });

        cartArrayList = new ArrayList<>();
        viewModel = new ViewModelProvider(this).get(CartViewModel.class);
        viewModel.getSelectedItem().observe(this, item -> {
            cartArrayList.add(item);
            fab_btn.increase();
        });

    }


    private void loadFragment(Fragment fragment) {
// create a FragmentManager
        FragmentManager fm = getSupportFragmentManager();
// create a FragmentTransaction to begin the transaction and replace the Fragment
        FragmentTransaction fragmentTransaction = fm.beginTransaction();
// replace the FrameLayout with new Fragment
        fragmentTransaction.replace(R.id.frameLayout, fragment);
        fragmentTransaction.commit(); // save the changes
    }




}