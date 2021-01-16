package com.example.aplikasifootball.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.aplikasifootball.R;
import com.example.aplikasifootball.adapter.AdapterLastEvent;
import com.example.aplikasifootball.adapter.AdapterNextEvent;
import com.example.aplikasifootball.httpclient.ApiInterface;
import com.example.aplikasifootball.httpclient.RetrofitClient;
import com.example.aplikasifootball.model.ResponseLastEvent;
import com.example.aplikasifootball.model.ResponseNextEvent;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link LastEventFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class LastEventFragment extends Fragment {

    String idLeague;

    @BindView(R.id.rvNextEvent)
    RecyclerView rvLastEvent;

    AdapterLastEvent adapter;
    ApiInterface apiInterface;
    public LastEventFragment() {
        // Required empty public constructor
    }


    public static LastEventFragment newInstance(String idLeague) {
        LastEventFragment fragment = new LastEventFragment();
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
        View view = inflater.inflate(R.layout.fragment_next_event, container, false);

        ButterKnife.bind(this,view);

        apiInterface= RetrofitClient.getRetrofitClient().create(ApiInterface.class);

        adapter=new AdapterLastEvent(getContext(),apiInterface);
        rvLastEvent.setLayoutManager(new LinearLayoutManager(getContext()));
        rvLastEvent.setAdapter(adapter);
        rvLastEvent.addItemDecoration(new DividerItemDecoration(getContext(),DividerItemDecoration.VERTICAL));

        nextEvent();


        return view;
    }

    public void nextEvent(){
        Call<ResponseLastEvent> api=apiInterface.getLastEventByLeague(idLeague);

        api.enqueue(new Callback<ResponseLastEvent>() {
            @Override
            public void onResponse(Call<ResponseLastEvent> call, Response<ResponseLastEvent> response) {
                if (response.isSuccessful()){
                    adapter.setItems(response.body().getEvents());
                    adapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onFailure(Call<ResponseLastEvent> call, Throwable t) {

            }
        });

    }
}