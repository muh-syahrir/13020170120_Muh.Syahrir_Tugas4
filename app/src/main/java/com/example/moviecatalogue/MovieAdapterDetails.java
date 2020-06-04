package com.example.moviecatalogue;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MovieAdapterDetails extends RecyclerView.Adapter<MovieAdapterDetails.MyViewHolder>{
    private Context context;
    private ArrayList<MovieDetails> data;

    public MovieAdapterDetails(Context context, ArrayList<MovieDetails> data) {
        this.context = context;
        this.data = data;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_cast, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        MovieDetails movie = data.get(position);
        holder.photocast.setImageResource(movie.getPhotocast());
        holder.nama.setText(movie.getNama());
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private ImageView photocast;
        private TextView nama;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            photocast = itemView.findViewById(R.id.photocast);
            nama = itemView.findViewById(R.id.nama);
        }
    }
}
