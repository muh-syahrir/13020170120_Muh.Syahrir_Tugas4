package com.example.moviecatalogue;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ArrayList<Movie> data = new ArrayList<>();
    private RecyclerView recyclerview;
    private RecyclerView.LayoutManager layoutManager;
    String[] judul,desc,genre, durasi, sutradara, tahun;
    TypedArray photo;
    private Toolbar toolbar;

    public void prepare(){
        judul = getResources().getStringArray(R.array.judul);
        desc = getResources().getStringArray(R.array.desc);
        genre = getResources().getStringArray(R.array.genre);
        durasi = getResources().getStringArray(R.array.durasi);
        sutradara = getResources().getStringArray(R.array.sutradara);
        tahun = getResources().getStringArray(R.array.tahun);
        photo = getResources().obtainTypedArray(R.array.photo);
    }

    public void addItem(){
        for (int i=0; i<judul.length; i++){
            Movie movie = new Movie(judul[i],desc[i],genre[i],durasi[i],sutradara[i],tahun[i],photo.getResourceId(i,-1));
            data.add(movie);
        }
    }

    public void getData(){
        prepare();
        addItem();
    }

    public void tampilDataGrid(){
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setTitle("Movie Catalogue");
        recyclerview = (RecyclerView) findViewById(R.id.recyclerview);

        layoutManager = new GridLayoutManager(this, 2);

        recyclerview.setLayoutManager(layoutManager);

        MovieAdapterGrid movieAdaptergrid = new MovieAdapterGrid(this, data);
        recyclerview.setAdapter(movieAdaptergrid);
        recyclerview.setHasFixedSize(true);
        movieAdaptergrid.notifyDataSetChanged();
    }

    public void tampilDataList(){
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setTitle("Movie Catalogue");
        recyclerview = (RecyclerView) findViewById(R.id.recyclerview);

        recyclerview.setLayoutManager(new LinearLayoutManager(this));

        MovieAdapterList movieAdapterlist = new MovieAdapterList(this, data);
        recyclerview.setAdapter(movieAdapterlist);
        movieAdapterlist.notifyDataSetChanged();
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setTitle("Movie Catalogue");
        getData();
        tampilDataList();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.id_List:
                tampilDataList();
                break;
            case R.id.id_Grid:
                tampilDataGrid();
                break;
            case R.id.id_about:
                startActivity(new Intent(MainActivity.this, About.class));
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
