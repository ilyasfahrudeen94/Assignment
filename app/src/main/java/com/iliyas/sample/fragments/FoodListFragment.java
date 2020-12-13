package com.iliyas.sample.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.iliyas.sample.ClickAddListener;
import com.iliyas.sample.R;
import com.iliyas.sample.adapters.FoodListAdapter;
import com.iliyas.sample.models.FoodItemData;
import com.iliyas.sample.repositories.CartViewModel;
import com.iliyas.sample.repositories.FoodListViewModel;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FoodListFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FoodListFragment extends Fragment{

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    FoodListViewModel viewModel;
    RecyclerView recyclerView;
    FoodListAdapter recyclerViewAdapter;

    CartViewModel cartViewModel;
    // TODO: Rename and change types of parameters
    private Integer mParam1;
    private String mParam2;

    public FoodListFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment FoodListFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static FoodListFragment newInstance(Integer position) {
        FoodListFragment fragment = new FoodListFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_PARAM1, position);
     //   args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getInt(ARG_PARAM1);
          //  mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_food_list, container, false);
        recyclerView = view.findViewById(R.id.rv_food_list);
        viewModel = new ViewModelProvider(getActivity()).get(FoodListViewModel.class);
        viewModel.getUserMutableLiveData().observe(getActivity(), foodListUpdateObserver);
        cartViewModel = new ViewModelProvider(requireActivity()).get(CartViewModel.class);

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
     //   view.setBackgroundColor(ContextCompat.getColor(getContext(), COLOR_MAP[mParam1]));

    }

    Observer<ArrayList<FoodItemData>> foodListUpdateObserver = new Observer<ArrayList<FoodItemData>>() {
        @Override
        public void onChanged(ArrayList<FoodItemData> foodArrayList) {
            recyclerViewAdapter = new FoodListAdapter(getActivity(), foodArrayList, new ClickAddListener() {
                @Override
                public void onAddClicked() {
                    System.out.println("clicked ====");
                    cartViewModel.selectItem(foodArrayList.get(0));
                }
            });
            recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
            recyclerView.setAdapter(recyclerViewAdapter);
        }
    };


}