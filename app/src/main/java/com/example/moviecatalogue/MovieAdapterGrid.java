package com.example.moviecatalogue;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MovieAdapterGrid extends RecyclerView.Adapter<MovieAdapterGrid.MyViewHolder> {
    private Context context;
    private ArrayList<Movie> data;

    public MovieAdapterGrid(Context context, ArrayList<Movie> data) {
        this.context = context;
        this.data = data;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.grid, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Movie movie =data.get(position);
        holder.judul.setText(movie.getJudul());
        holder.photo.setImageResource(movie.getPhoto());
    }

    @Override
    public int getItemCount()  {
        return data.size();
    }
    public class MyViewHolder extends RecyclerView.ViewHolder{
        private TextView judul;
        private ImageView photo;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(v.getContext(),judul.getText(),Toast.LENGTH_SHORT).show();
                }
            });
            judul = (TextView) itemView.findViewById(R.id.judul);
            photo = (ImageView) itemView.findViewById(R.id.photo);
        }
    }
}
