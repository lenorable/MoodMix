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
public class ContextListner implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        // PersistenceManager; // dit wordt om later de functies voor opslaan en gaan te roepen

        // Gebruiker.alleGebruikers = null;

        System.out.println("starting application");

        PersistenceManager.loadUsers();
        PersistenceManager.loadMusic();

        Gevoel happy = new Gevoel("happy");
        Gevoel sad = new Gevoel("sad");
        Gevoel relaxed = new Gevoel("relaxed");
        Gevoel inspired = new Gevoel("inspired");
        Gevoel romantic = new Gevoel("romantic");
        Gevoel focues = new Gevoel("focues");
        Gevoel euphoric = new Gevoel("euphoric");

        
        // ArrayList<Nummer> n1 = new ArrayList<Nummer>();
        // n1.add(testNum1);

        // PersistenceManager.saveMusic(n1);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("stopping application");

        PersistenceManager.saveUsers();
        PersistenceManager.saveMusic();
    }
}
