package com.example.model;

import java.security.Principal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Gebruiker implements Principal{
    private String gebruikerNaam;
    private List<Playlist> playlists = new ArrayList<Playlist>();
    private List<Bericht> berichten = new ArrayList<Bericht>();

    private String role;

    public static List<Gebruiker> alleGebruikers = new ArrayList<>();

    public Gebruiker(String gebruikerNaam, String role){
        this.gebruikerNaam = gebruikerNaam;

        this.role = role;

        alleGebruikers.add(this);
    }

    public String getGebruikerNaam() {
        return gebruikerNaam;
    }

    public String getName(){ //voor security
        return gebruikerNaam;
    }

    public List<Playlist> getPlaylists() {
        return playlists;
    }

    public List<Bericht> getBerichten() {
        return berichten;
    }

    public String getRole(){
        return role;
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

