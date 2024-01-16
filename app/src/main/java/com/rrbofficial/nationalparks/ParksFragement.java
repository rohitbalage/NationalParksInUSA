package com.rrbofficial.nationalparks;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.rrbofficial.nationalparks.adapter.ParkRecyclerViewAdapter;
import com.rrbofficial.nationalparks.data.AsyncResponse;
import com.rrbofficial.nationalparks.data.Repository;
import com.rrbofficial.nationalparks.model.Park;

import java.util.List;


public class ParksFragement extends Fragment {

    private RecyclerView recyclerView;

    private ParkRecyclerViewAdapter parkRecyclerViewAdapter;

    private List<Park> parkList;




    public ParksFragement() {
        // Required empty public constructor
    }

    public static ParksFragement newInstance() {
        ParksFragement fragment = new ParksFragement();
        Bundle args = new Bundle();

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {

        }
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Repository.getParks(new AsyncResponse() {
            @Override
            public void proecessPark(List<Park> parks) {
                parkRecyclerViewAdapter = new ParkRecyclerViewAdapter(parks);
                recyclerView.setAdapter(parkRecyclerViewAdapter);
            }
        });

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

       View view = inflater.inflate(R.layout.fragment_parks, container, false);

       recyclerView = view.findViewById(R.id.park_recycler);
       recyclerView.setHasFixedSize(true);
       recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

       return view;

    }
}