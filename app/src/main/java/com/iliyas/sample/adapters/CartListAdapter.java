package com.iliyas.sample.adapters;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.iliyas.sample.ClickAddListener;
import com.iliyas.sample.R;
import com.iliyas.sample.models.FoodItemData;

import java.util.ArrayList;

public class CartListAdapter extends RecyclerView.Adapter<CartListAdapter.FoodViewHolder>{

    Activity context;
    ArrayList<FoodItemData> foodItemDataArrayList;

    public CartListAdapter(Activity context, ArrayList<FoodItemData> foodItemData) {
        this.context = context;
        this.foodItemDataArrayList = foodItemData;
    }
    @NonNull
    @Override
    public FoodViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View rootView = LayoutInflater.from(context).inflate(R.layout.rv_cart,parent,false);
        return new FoodViewHolder(rootView);
    }

    @Override
    public void onBindViewHolder(@NonNull FoodViewHolder holder, int position) {
        FoodItemData user = foodItemDataArrayList.get(position);
        holder.tv_name.setText(user.getTitle());
        int price = (position+1) * 13;
        holder.tv_price.setText("$ "+price);
        Glide.with(holder.itemView)
                .load(user.getImgUrl())
                .fitCenter()
                .into(holder.img_food);

    }

    @Override
    public int getItemCount() {
        return foodItemDataArrayList.size();
    }

    class FoodViewHolder extends RecyclerView.ViewHolder{
        ImageView img_food;
        TextView tv_name, tv_price;
        public FoodViewHolder(@NonNull View itemView) {
            super(itemView);
            img_food = itemView.findViewById(R.id.cart_img);
            tv_name = itemView.findViewById(R.id.cart_food_name);
            tv_price = itemView.findViewById(R.id.cart_price);
        }
    }

}
