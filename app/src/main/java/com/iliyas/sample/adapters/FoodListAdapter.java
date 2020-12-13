package com.iliyas.sample.adapters;

import android.app.Activity;
import android.util.Log;
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
import com.iliyas.sample.models.FoodItemData;
import com.iliyas.sample.R;
import com.iliyas.sample.repositories.CartViewModel;

import java.util.ArrayList;

public class FoodListAdapter extends RecyclerView.Adapter<FoodListAdapter.FoodViewHolder> {

    Activity context;
    ArrayList<FoodItemData> foodItemDataArrayList;
    ClickAddListener clickAddListener;

    public FoodListAdapter(Activity context, ArrayList<FoodItemData> foodItemData, ClickAddListener clickAddListener) {
        this.context = context;
        this.foodItemDataArrayList = foodItemData;
        this.clickAddListener = clickAddListener;
    }

    @NonNull
    @Override
    public FoodViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View rootView = LayoutInflater.from(context).inflate(R.layout.food_recycler_view,parent,false);
        return new FoodViewHolder(rootView);    }

    @Override
    public void onBindViewHolder(@NonNull FoodViewHolder holder, int position) {
        FoodItemData user = foodItemDataArrayList.get(position);

        holder.tv_name.setText(user.getTitle());
        holder.tv_description.setText(user.getDescription());
        holder.tv_details.setText(user.getDetails());

        Glide.with(holder.itemView)
                .load(user.getImgUrl())
                .fitCenter()
                .into(holder.img_food);
      //  holder.txtView_title.setText(user.getTitle());
        holder.add_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("details: ", user.getTitle());
                clickAddListener.onAddClicked();
            }
        });


    }

    @Override
    public int getItemCount() {
        return foodItemDataArrayList.size();
    }

    class FoodViewHolder extends RecyclerView.ViewHolder{
        Button add_button;
        ImageView img_food;
        TextView tv_name, tv_description, tv_details;
        public FoodViewHolder(@NonNull View itemView) {
            super(itemView);
            add_button = itemView.findViewById(R.id.rv_food_addBtn);
            img_food = itemView.findViewById(R.id.rv_food_img);
            tv_name = itemView.findViewById(R.id.rv_food_name);
            tv_description = itemView.findViewById(R.id.rv_food_description);
            tv_details = itemView.findViewById(R.id.rv_food_details);
        }
    }

}
