package com.example.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

// @JsonIgnoreProperties("alleGevoelens")
public class Gevoel implements Serializable{
    public String type;

    public static ArrayList<Gevoel> alleGevoelens = new ArrayList<Gevoel>();

    public Gevoel(String type) {
        this.type = type;
        alleGevoelens.add(this);
    }

    public String getGevoel(){
        return type;
    }
}
