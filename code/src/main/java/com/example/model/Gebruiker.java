package com.example.model;

import java.io.Serializable;
import java.security.Principal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Gebruiker implements Serializable, Principal{
    private String gebruikerNaam;
    private String role;

    private Setting settings;

    private List<Playlist> playlists = new ArrayList<Playlist>();
    private List<Bericht> berichten = new ArrayList<Bericht>();
    
    public static ArrayList<Gebruiker> alleGebruikers = new ArrayList<>();

    public Gebruiker(String gebruikerNaam, String role){
        this.gebruikerNaam = gebruikerNaam;

        this.role = role;
        this.settings = new Setting();

        alleGebruikers.add(this);
    }

    public String getGebruikerNaam() {
        return gebruikerNaam;
    }

    public String getName(){ //voor security
        return gebruikerNaam;
    }

    public String getRole(){
        return role;
    }

    public Setting getSetting(){
        return this.settings;
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

