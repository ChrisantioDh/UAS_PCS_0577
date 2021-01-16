package com.example.aplikasifootball.fragments;

import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.aplikasifootball.R;
import com.example.aplikasifootball.adapter.AdapterNextEvent;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.http.Url;

public class NextEventFragment extends Fragment {

    String idLeague;

    @BindView(R.id.rvNextEvent)
    RecyclerView rvNextEvent;

    AdapterNextEvent adapter;


    public NextEventFragment() {
        // Required empty public constructor
    }

    public static NextEventFragment newInstance(String idLeague) {
        NextEventFragment fragment = new NextEventFragment();
        Bundle args = new Bundle();
        args.putString("id", idLeague);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            idLeague = getArguments().getString("id");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_next_event, container, false);

        ButterKnife.bind(this,view);

        return view;
    }
}