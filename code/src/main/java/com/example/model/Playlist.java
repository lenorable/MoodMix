package com.example.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Playlist implements Serializable{
    private Gebruiker maker;
    private String naam;
    private List<Nummer> nummers = new ArrayList<Nummer>();

    public Playlist(Gebruiker maker, String naam) {
        this.maker = maker;
        this.naam = naam;
    }

    public Gebruiker getMaker() {
        return maker;
    }

    public String getNaam() {
        return naam;
    }

    public List<Nummer> getNummers(){
        return nummers;
    }
    
    public String addNummer(Nummer muziek){
        try {
            nummers.add(muziek);
            return "succes!";
        } catch (Exception e){
            return e.getMessage();
        }
    }
}
