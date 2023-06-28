package com.example.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

public class Setting implements Serializable{
    private double volume;
    private String theme;
    private ArrayList<String> gevoelens;

    private ArrayList<Nummer> que;

    // private ?? lastlogin

    public Setting() {
        this.volume = 1;
        this.theme = "default";
    }

    public void setVolume(int volume){
        this.volume = volume;
    }

    public void setGevoelens(ArrayList<String> gevoelens){
        this.gevoelens = gevoelens;
    }

    public void resetQue(){
        this.que = null;
    }

    public void setQueItem(Nummer nummer){
        if (this.que == null){
            que = new ArrayList<Nummer>();
        }

        this.que.add(nummer);
    }

    public HashMap<String, String> getSettings(){
        HashMap<String, String> settings = new HashMap<String, String>();

        settings.put("volume", String.valueOf(volume));
        settings.put("theme", theme);
        
        return settings;
    }

    public ArrayList<String> getGevoelens(){
        return this.gevoelens;
    }

    public ArrayList<Nummer> getQue(){
        return this.que;
    }

    public ArrayList<String> getQueUrls(){
        ArrayList<String> urls = new ArrayList<String>();

        for (Nummer nummer : this.que) {
            urls.add(nummer.getBestandNaam());
        }

        return urls;
    }
}
