package com.example.lyton.adapter;


import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.lyton.R;
import com.example.lyton.model.Spot;

import java.util.List;

public class SpotAdapter extends RecyclerView.Adapter<SpotAdapter.ViewHolder> {
    private List<Spot> spots;

    public SpotAdapter(List<Spot> spots) {
        this.spots = spots;
    }


    @NonNull
    @Override
    public SpotAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.spot_items,parent,false);
        return new SpotAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.spotTextView.setText(spots.get(position).getName());
        holder.locationTextView.setText(spots.get(position).getCountry() + " " +
                spots.get(position).getCity());
        Glide.with(holder.imageView)
                .load(spots.get(position).getPhotoUri())
                .override(300,400)
                .into(holder.imageView);
        holder.spotLinearLayout.setOnClickListener(v -> {
            Uri uri = Uri.parse("geo:0,0?q=" + spots.get(position).getAddress());
            Intent map = new Intent(Intent.ACTION_VIEW, uri);
            if (map.resolveActivity(v.getContext().getPackageManager()) != null) {
                v.getContext().startActivity(map);
            }
        });
    }

    @Override
    public int getItemCount() {
        return spots.size();
    }

    public void updateData(List<Spot> spots) {
        this.spots = spots;
        notifyDataSetChanged();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView imageView;
        private TextView spotTextView;
        private TextView locationTextView;
        private LinearLayout spotLinearLayout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.spot_image_view);
            spotTextView = itemView.findViewById(R.id.spot_name_text_view);
            locationTextView = itemView.findViewById(R.id.location_text_view);
            spotLinearLayout = itemView.findViewById(R.id.spot_linear_layout);
        }
    }
}
