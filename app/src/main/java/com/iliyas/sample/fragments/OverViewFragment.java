package com.iliyas.sample.fragments;

import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;
import com.iliyas.sample.R;
import com.iliyas.sample.adapters.FoodPagerAdapter;
import com.iliyas.sample.adapters.SliderImageAdapter;
import com.poliveira.apps.parallaxlistview.ParallaxScrollView;
import com.smarteist.autoimageslider.IndicatorView.animation.type.IndicatorAnimationType;
import com.smarteist.autoimageslider.SliderAnimations;
import com.smarteist.autoimageslider.SliderView;

import java.util.ArrayList;
import java.util.List;


public class OverViewFragment extends Fragment {
    private View mView, slideView;
    ParallaxScrollView mScrollView;

    TabLayout tabLayout;
    ViewPager2 viewPager;

    public OverViewFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        mView = inflater.inflate(R.layout.fragment_over_view, container, false);

        mScrollView = mView.findViewById(R.id.view);
        mScrollView.setParallaxView(getActivity().getLayoutInflater().inflate(R.layout.content_scrolling, mScrollView, false));

        SliderView sliderView = mView.findViewById(R.id.imageSlider);

        SliderImageAdapter adapter = new SliderImageAdapter(getActivity(), list_images());
        sliderView.setSliderAdapter(adapter);

        sliderView.setIndicatorAnimation(IndicatorAnimationType.WORM); //set indicator animation by using IndicatorAnimationType. :WORM or THIN_WORM or COLOR or DROP or FILL or NONE or SCALE or SCALE_DOWN or SLIDE and SWAP!!
        sliderView.setSliderTransformAnimation(SliderAnimations.SIMPLETRANSFORMATION);
        sliderView.setAutoCycleDirection(SliderView.AUTO_CYCLE_DIRECTION_BACK_AND_FORTH);
        sliderView.setIndicatorSelectedColor(Color.WHITE);
        sliderView.setIndicatorUnselectedColor(Color.GRAY);
        sliderView.setScrollTimeInSec(4); //set scroll delay in seconds :
        sliderView.startAutoCycle();

        viewPager = mView.findViewById(R.id.view_pager);
        tabLayout = mView.findViewById(R.id.tabs);

        viewPager.setAdapter(createCardAdapter());
        new TabLayoutMediator(tabLayout, viewPager,
                new TabLayoutMediator.TabConfigurationStrategy() {
                    @Override public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                        if(position == 0) {
                            tab.setText("Pizza");
                        } else if(position == 1){
                            tab.setText("Sushi");
                        } else {
                            tab.setText("Drinks");
                        }
                    }
                }).attach();

        return mView;
    }
    private FoodPagerAdapter createCardAdapter() {
        FoodPagerAdapter adapter = new FoodPagerAdapter(getActivity());
        return adapter;
    }

    private List list_images(){
        List listImage = new ArrayList();
        listImage.add("https://media-cdn.tripadvisor.com/media/photo-s/10/01/7c/23/chicken-n-spag-promo.jpg");
        listImage.add("https://media-cdn.tripadvisor.com/media/photo-s/1a/de/2e/de/lunch-promo.jpg");
        listImage.add("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTa6EwIz3H0Zi1iIqiTttTQ9upr-rbkzIJawA&usqp=CAU");

        return listImage;
    }
}