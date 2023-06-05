package com.example.model;

import java.security.Principal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.management.relation.Role;

public class Gebruiker implements Principal{
    private String naam;
    private String gebruikerNaam;
    private List<Playlist> playlists = new ArrayList<Playlist>();
    private List<Bericht> berichten = new ArrayList<Bericht>();

    private int id;
    private String password; //dit voelt sws fout
    private String role;

    private static List<Gebruiker> allGebruikers = new ArrayList<>();

    public Gebruiker(String naam, String gebruikerNaam, int id, String password, String role){
        this.naam = naam;
        this.gebruikerNaam = gebruikerNaam;
        this.id = id;
        this.password = password;
        this.role = role;

        allGebruikers.add(this);
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

    public static List<Gebruiker> getAllGebruikers() {
        return Collections.unmodifiableList(allGebruikers);
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

    public boolean checkPassword(String pass){
        return pass.equals(this.password);
    }
}

