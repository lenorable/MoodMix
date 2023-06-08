package com.example.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.example.manager.PersistenceManager;

public class Nummer implements Serializable{
    private String naam;
    private String maker;
    private double lengte; //dit kan mis als local time? kom ik later op terug! 
    private String bestandnaam; //dit kan worden omgezet naar path?
    private List<Gevoel> gevoelens;

    public Nummer(String naam, String maker, double lengte, String bestandnaam, List<Gevoel> gevoelens) {
        this.naam = naam;
        this.maker = maker;
        this.lengte = lengte;
        this.bestandnaam = bestandnaam;
        this.gevoelens = gevoelens;
        // PersistenceManager.saveMusic(PersistenceManager.updateMusicListSingle(this)); //adding this number to the existing list and saving it
    }

    public String getNaam() {
        return naam;
    }

    public String getMaker() {
        return maker;
    }

    public double getLengte() {
        return lengte;
    }

    public List<Gevoel> getGevoelens() {
        return gevoelens;
    }

    public String getBestandNaam(){
        return bestandnaam;
    }

}
