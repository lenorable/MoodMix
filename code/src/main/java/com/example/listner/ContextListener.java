package com.example.listner;

import java.util.ArrayList;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import com.example.manager.PersistenceManager;
import com.example.model.Gebruiker;
import com.example.model.Gevoel;
import com.example.model.Nummer;

@WebListener
public class ContextListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        // PersistenceManager; // dit wordt om later de functies voor opslaan en gaan te roepen

        System.out.println("starting application");

        Gevoel happy = new Gevoel("happy");
        Gevoel sad = new Gevoel("sad");
        Gevoel relaxed = new Gevoel("relaxed");
        Gevoel inspired = new Gevoel("inspired");
        Gevoel romantic = new Gevoel("romantic");
        Gevoel focues = new Gevoel("focues");
        Gevoel euphoric = new Gevoel("euphoric");

        Gebruiker test1 = new Gebruiker("lenor", "lenorable", 0, "qwerty", "admin");
        Gebruiker test2 = new Gebruiker("lynn", "nyr", 0, "0000", "hacker");

        ArrayList<Gevoel> gevoelensList = new ArrayList<Gevoel>();
        gevoelensList.add(euphoric);
        gevoelensList.add(happy);
        gevoelensList.add(inspired);

        Nummer testNum1 = new Nummer("Inspiration", "unknownbrain", 3.06, "file:///C://home/MoodMixMusic/inspiration_unknownBrain.mp3", gevoelensList);
        ArrayList<Nummer> n1 = new ArrayList<Nummer>();
        n1.add(testNum1);

        PersistenceManager.saveMusic(n1);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("stopping application");
    }
}
