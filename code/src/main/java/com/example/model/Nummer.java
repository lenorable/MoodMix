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
    private ArrayList<String> gevoelens;

    public static ArrayList<Nummer> nummers = new ArrayList<Nummer>();

    public Nummer(String naam, String maker, double lengte, String bestandnaam, ArrayList<String> gevoelens) {
        this.naam = naam;
        this.maker = maker;
        this.lengte = lengte;
        this.bestandnaam = bestandnaam;
        this.gevoelens = gevoelens;

        nummers.add(this);
        System.out.println(nummers);
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

    public ArrayList<String> getGevoelens() {
        return gevoelens;
    }

    public String getBestandNaam(){
        return bestandnaam;
    }

}
