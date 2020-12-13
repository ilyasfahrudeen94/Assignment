package com.iliyas.sample.adapters;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.iliyas.sample.R;
import com.smarteist.autoimageslider.SliderViewAdapter;

import java.util.ArrayList;
import java.util.List;

public class SliderImageAdapter extends SliderViewAdapter<SliderImageAdapter.SliderAdapterVH>{

    Context context;
    List list_image;

    public SliderImageAdapter(Context context, List list_image){
        this.context = context;
        this.list_image = list_image;

    }

    @Override
    public SliderAdapterVH onCreateViewHolder(ViewGroup parent) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.image_slide_view, null);
        return new SliderAdapterVH(inflate);
    }

    @Override
    public void onBindViewHolder(SliderAdapterVH viewHolder, int position) {
        Glide.with(viewHolder.itemView)
                .load(list_image.get(position))
                .fitCenter()
                .into(viewHolder.imageViewBackground);
      /*  if(position% 2 == 0) {
            Glide.with(viewHolder.itemView)
                    .load(R.drawable.sample_one)
                    .fitCenter()
                    .into(viewHolder.imageViewBackground);
        } else {
            Glide.with(viewHolder.itemView)
                    .load(R.drawable.sample_1)
                    .fitCenter()
                    .into(viewHolder.imageViewBackground);
        }*/

    }

    @Override
    public int getCount() {
        return list_image.size();
    }

    class SliderAdapterVH extends SliderViewAdapter.ViewHolder {

        ImageView imageViewBackground;
        View itemView;


        public SliderAdapterVH(View itemView) {
            super(itemView);
            imageViewBackground = itemView.findViewById(R.id.iv_auto_image_slider);
            this.itemView = itemView;

        }
    }
}
