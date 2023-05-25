package com.example.model;

import java.util.List;

public class Nummer {
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

}
