package com.example.aplikasifootball.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.aplikasifootball.R;
import com.example.aplikasifootball.model.EventsItem;

import java.util.ArrayList;
import java.util.List;

public class AdapterNextEvent extends RecyclerView.Adapter<AdapterNextEvent.ViewHolder> {

    Context context;
    List<EventsItem> items;

    public AdapterNextEvent(Context context) {
        this.context = context;
        this.items = new ArrayList<>();
    }

    public void setItems(List<EventsItem> items) {
        this.items = items;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_event,parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {

        holder.tvHome.setText(items.get(position).getStrHomeTeam());
        holder.tvAway.setText(items.get(position).getStrAwayTeam());

        holder.tvTanggal.setText(items.get(position).getStrTimestamp());
        holder.tvSkor.setText( items.get(position).getIntAwayScore()+" : "+items.get(position).getIntAwayScore());


    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        ImageView ivHome,ivAway;
        TextView tvHome,tvAway,tvTanggal,tvSkor;
        View itemView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            ivHome=itemView.findViewById(R.id.ivHome);
            ivAway=itemView.findViewById(R.id.ivAway);
            tvHome=itemView.findViewById(R.id.tvHome);
            tvAway=itemView.findViewById(R.id.tvAway);
            tvTanggal=itemView.findViewById(R.id.tvTanggal);
            tvSkor=itemView.findViewById(R.id.tvSkor);

            this.itemView=itemView;
        }
    }
}
