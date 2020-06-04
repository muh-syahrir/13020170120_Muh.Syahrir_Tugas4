package com.example.moviecatalogue;

public class MovieDetails {
    private String nama;
    private int photocast;

    public MovieDetails(String nama, int photocast) {
        this.nama = nama;
        this.photocast = photocast;
    }

    public String getNama() {
        return nama;
    }

    public int getPhotocast() {
        return photocast;
    }
}
