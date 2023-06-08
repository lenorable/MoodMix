package com.example;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.Test;

import com.example.manager.PersistenceManager;
import com.example.model.Gevoel;
import com.example.model.Nummer;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue()
    {
        assertTrue( true );
    }

    // @Test
    // public void makeSongObj()
    // {
    //     Gevoel happy = new Gevoel("happy");
    //     Gevoel sad = new Gevoel("sad");
    //     Gevoel relaxed = new Gevoel("relaxed");
    //     Gevoel inspired = new Gevoel("inspired");
    //     Gevoel romantic = new Gevoel("romantic");
    //     Gevoel focues = new Gevoel("focues");
    //     Gevoel euphoric = new Gevoel("euphoric");

    //     ArrayList<Gevoel> gevoelensList = new ArrayList<Gevoel>();
    //     gevoelensList.add(euphoric);
    //     gevoelensList.add(happy);
    //     gevoelensList.add(inspired);

    //     Nummer testNum1 = new Nummer("Inspiration", "unknownbrain", 3.06, "Unknown Brain - Inspiration (feat. Aviella) [NCS Release].mp3", gevoelensList);
    //     ArrayList<Nummer> n1 = new ArrayList<Nummer>();
    //     n1.add(testNum1);
    //     PersistenceManager.saveMusic(n1);
    // }

    @Test
    public void loadsong()
    {
        ArrayList<Nummer> songs = PersistenceManager.loadMusic();

        System.out.println(Gevoel.alleGevoelens);

        // System.out.println(songs);
        // for (Nummer nummer : songs) {
        //     System.out.println(nummer.getGevoelens());
        // }
    }
}
