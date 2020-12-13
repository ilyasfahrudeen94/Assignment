package com.iliyas.sample.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.iliyas.sample.R;
import com.iliyas.sample.adapters.SliderImageAdapter;
import com.smarteist.autoimageslider.SliderView;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link SlideImageFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SlideImageFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public SlideImageFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment SlideImageFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static SlideImageFragment newInstance(String param1, String param2) {
        SlideImageFragment fragment = new SlideImageFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.content_scrolling, container, false);
        SliderView sliderView = view.findViewById(R.id.imageSlider);
        sliderView.setSliderAdapter(new SliderImageAdapter(getActivity(), list_images()));
        return view;
    }

    private List list_images(){
        List listImage = new ArrayList();
        listImage.add("https://media-cdn.tripadvisor.com/media/photo-s/10/01/7c/23/chicken-n-spag-promo.jpg");
        listImage.add("https://media-cdn.tripadvisor.com/media/photo-s/1a/de/2e/de/lunch-promo.jpg");
        listImage.add("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTa6EwIz3H0Zi1iIqiTttTQ9upr-rbkzIJawA&usqp=CAU");

        return listImage;
    }
}