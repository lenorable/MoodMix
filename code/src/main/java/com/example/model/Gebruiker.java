package com.example.model;

import java.util.List;

public class Gebruiker {
    private String naam;
    private String gebruikerNaam;
    private List<Playlist> playlists;
    private List<Bericht> berichten;
    private int id;
    private String password; //dit voelt sws fout

    public Gebruiker(String naam, String gebruikerNaam, int id, String password) {
        this.naam = naam;
        this.gebruikerNaam = gebruikerNaam;
        this.id = id;
        this.password = password;
    }

    public String getGebruikerNaam() {
        return gebruikerNaam;
    }

    public List<Playlist> getPlaylists() {
        return playlists;
    }

    public List<Bericht> getBerichten() {
        return berichten;
    }

    public String addPlaylists(Playlist playlist){
        try {
            playlists.add(playlist);
            return "succes!";
        } catch (Exception e){
            return e.getMessage();
        }
    }

    public String addBericht(Bericht post){
        try {
            berichten.add(post);
            return "succes!";
        } catch (Exception e){
            return e.getMessage();
        }
    }
}

