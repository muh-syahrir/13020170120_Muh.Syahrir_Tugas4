package com.example.moviecatalogue;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class Details extends AppCompatActivity {
    private TextView judul,desc,genre,durasi,sutradara,tahun;
    private ImageView photo;
    private RecyclerView recyclerView;
    private Toolbar toolbar;
    String getjudul,getdesc,getgenre,getdurasi,getsutradara,gettahun;
    int getphoto;
    String[] nama;
    TypedArray photocast;
    private ArrayList<MovieDetails> data = new ArrayList<>();

    public void prepare(){
        switch (getjudul){
            case "Kingdom":
                nama = getResources().getStringArray(R.array.kingdom);
                photocast = getResources().obtainTypedArray(R.array.castkingdom);
                break;
            case "Mr. Robot":
                nama = getResources().getStringArray(R.array.mrrobot);
                photocast = getResources().obtainTypedArray(R.array.castmrrobot);
                break;
            case "The Flash":
                nama = getResources().getStringArray(R.array.theflash);
                photocast = getResources().obtainTypedArray(R.array.casttheflash);
                break;
            case "Money Heist S1":
                nama = getResources().getStringArray(R.array.moneyheist);
                photocast = getResources().obtainTypedArray(R.array.castmoneyheist);
                break;
            case "Smallville":
                nama = getResources().getStringArray(R.array.smallville);
                photocast = getResources().obtainTypedArray(R.array.castsmallville);
                break;
            case "The Big Bang Theory":
                nama = getResources().getStringArray(R.array.thebigbangtheory);
                photocast = getResources().obtainTypedArray(R.array.castthebigbangtheory);
                break;
            case "Stranger Things":
                nama = getResources().getStringArray(R.array.strangerthing);
                photocast = getResources().obtainTypedArray(R.array.caststrangerthing);
                break;
            case "Strangers From Hell":
                nama = getResources().getStringArray(R.array.strangerfromhell);
                photocast = getResources().obtainTypedArray(R.array.caststrangerfromhell);
                break;
            case "13 Reasons Why":
                nama = getResources().getStringArray(R.array.reasonwhy);
                photocast = getResources().obtainTypedArray(R.array.cast13reasonwhy);
                break;
            case "Sex Education":
                nama = getResources().getStringArray(R.array.sexeducation);
                photocast = getResources().obtainTypedArray(R.array.castsexeducation);
                break;
            case "Orange Is the New Black":
                nama = getResources().getStringArray(R.array.orangeisthenewblack);
                photocast = getResources().obtainTypedArray(R.array.castorangeisthenewblack);
                break;
            case "Adventure Time":
                nama = getResources().getStringArray(R.array.adventuretime);
                photocast = getResources().obtainTypedArray(R.array.castadventuretime);
                break;
            case "Rick and Morty":
                nama = getResources().getStringArray(R.array.rickandmorty);
                photocast = getResources().obtainTypedArray(R.array.castrickandmorty);
                break;
            case "The Simpsons":
                nama = getResources().getStringArray(R.array.thesimpson);
                photocast = getResources().obtainTypedArray(R.array.castthesimpson);
                break;
            case "Family Guy":
                nama = getResources().getStringArray(R.array.familyguy);
                photocast = getResources().obtainTypedArray(R.array.castfamilyguy);
                break;
            case "Sesame Street":
                nama = getResources().getStringArray(R.array.sesamestreet);
                photocast = getResources().obtainTypedArray(R.array.castsesamestreet);
                break;
            case "South Park":
                nama = getResources().getStringArray(R.array.southpark);
                photocast = getResources().obtainTypedArray(R.array.castsouthpark);
                break;
            case "BoJack Horseman":
                nama = getResources().getStringArray(R.array.bojackhorseman);
                photocast = getResources().obtainTypedArray(R.array.castbojackhorseman);
                break;
            case "Futurama":
                nama = getResources().getStringArray(R.array.futurama);
                photocast = getResources().obtainTypedArray(R.array.castfuturama);
                break;
            case "JoJo Bizarre Adventure":
                nama = getResources().getStringArray(R.array.jojobizarre);
                photocast = getResources().obtainTypedArray(R.array.castjojobizarre);
                break;
        }
    }

    public  void addItem(){
        for (int i = 0; i<nama.length; i++){
            MovieDetails movie =new MovieDetails(nama[i], photocast.getResourceId(i, -1));
            data.add(movie);
        }
    }

    public void getData(){
        prepare();
        addItem();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        recyclerView = findViewById(R.id.cast);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

        MovieAdapterDetails movieAdapterDetails = new MovieAdapterDetails(this, data);
        recyclerView.setAdapter(movieAdapterDetails);
        movieAdapterDetails.notifyDataSetChanged();

        toolbar = findViewById(R.id.toolbar);
        judul = findViewById(R.id.judul);
        desc = findViewById(R.id.desc);
        genre = findViewById(R.id.genre);
        durasi = findViewById(R.id.durasi);
        sutradara = findViewById(R.id.sutradara);
        tahun = findViewById(R.id.tahun);
        photo = findViewById(R.id.photo);
        setSupportActionBar(toolbar);
        toolbar.setNavigationIcon(R.drawable.ic_arrow_back_black_24dp);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        getjudul = getIntent().getStringExtra("judul");
        getdesc = getIntent().getStringExtra("desc");
        getgenre = getIntent().getStringExtra("genre");
        getdurasi = getIntent().getStringExtra("durasi");
        getsutradara = getIntent().getStringExtra("sutradara");
        gettahun = getIntent().getStringExtra("tahun");
        getphoto = getIntent().getIntExtra("photo",0);

        getData();

        judul.setText(getjudul);
        desc.setText(getdesc);
        genre.setText(getgenre);
        durasi.setText(getdurasi);
        sutradara.setText(getsutradara);
        tahun.setText(gettahun);
        photo.setImageResource(getphoto);
    }
}
