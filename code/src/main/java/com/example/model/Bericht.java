package com.example.model;

import java.util.List;

public class Bericht {
    private List<Gebruiker> likes;
    private String text;
    private Nummer muziek;
    private int id;
    private Gebruiker maker;

    public Bericht(String text, Nummer muziek, int id, Gebruiker maker) {
        this.text = text;
        this.muziek = muziek;
        this.id = id;
        this.maker = maker;
    }

    public Bericht(String text, int id, Gebruiker maker) {
        this.text = text;
        this.id = id;
        this.maker = maker;
    }

    public String getText() {
        return text;
    }

    public Nummer getMuziek() {
        return muziek;
    }

    public Gebruiker getMaker() {
        return maker;
    }

    public String addLike(Gebruiker liker){
        try {
            likes.add(liker);
            return "succes!";
        } catch (Exception e){
            return e.getMessage();
        }
    }
}
