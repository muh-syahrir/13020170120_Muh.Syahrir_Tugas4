package com.example.moviecatalogue;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MovieAdapterList extends RecyclerView.Adapter<MovieAdapterList.MyViewHolder> {
    private Context context;
    private ArrayList<Movie> data;

    public MovieAdapterList(Context context, ArrayList<Movie> data) {
        this.context = context;
        this.data = data;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final MovieAdapterList.MyViewHolder holder, final int position) {
        final Movie movie = data.get(position);
        holder.judul.setText(movie.getJudul());
        holder.desc.setText(movie.getDesc());
        holder.photo.setImageResource(movie.getPhoto());
        holder.linear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), Details.class);
                intent.putExtra("judul", movie.getJudul());
                intent.putExtra("desc", movie.getDesc());
                intent.putExtra("photo", movie.getPhoto());
                intent.putExtra("genre", movie.getGenre());
                intent.putExtra("durasi", movie.getDurasi());
                intent.putExtra("sutradara", movie.getSutradara());
                intent.putExtra("tahun", movie.getTahun());
                v.getContext().startActivities(new Intent[]{intent});
            }
        });
        holder.hapus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data.remove(position);
                notifyItemRemoved(position);
                notifyItemRangeChanged(position, data.size());

            }
        });
    }


    @Override
    public int getItemCount() {
        return data.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView judul, desc, genre, durasi, sutradara, tahun;
        private ImageView photo;
        private LinearLayout linear;
        private Button hapus;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            judul = itemView.findViewById(R.id.judul);
            desc = itemView.findViewById(R.id.desc);
            photo = itemView.findViewById(R.id.photo);
            genre = itemView.findViewById(R.id.genre);
            durasi = itemView.findViewById(R.id.durasi);
            sutradara = itemView.findViewById(R.id.sutradara);
            tahun = itemView.findViewById(R.id.tahun);
            linear = itemView.findViewById(R.id.linear);
            hapus = itemView.findViewById(R.id.hapus);
        }


    }
}
