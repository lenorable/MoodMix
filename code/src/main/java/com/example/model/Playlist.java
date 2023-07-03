package com.example.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Playlist implements Serializable{
    private Gebruiker maker;
    private String naam;
    private String sumary;
    private List<String> nummers = new ArrayList<String>();

    public Playlist(Gebruiker maker, String naam, String sum) {
        this.maker = maker;
        this.naam = naam;
        this.sumary = sum;
    }

    public Gebruiker getMaker() {
        return maker;
    }

    public String getNaam() {
        return naam;
    }

    public String getSum(){
        return sumary;
    }

    public List<String> getNummers(){
        return nummers;
    }

    public void changeSummary(String sum){
        this.sumary = sum;
    }
    
    public String addNummer(String muziek){
        try {
            nummers.add(muziek);
            return "succes!";
        } catch (Exception e){
            return e.getMessage();
        }
    }
}
