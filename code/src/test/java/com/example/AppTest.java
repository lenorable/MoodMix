package com.example;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.Test;

import com.example.manager.PersistenceManager;
// import com.example.model.Gevoel;
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
    //     ArrayList<String> gevoelensList = new ArrayList<String>();
    //     gevoelensList.add("euphoric");
    //     gevoelensList.add("happy");
    //     gevoelensList.add("inspired");

    //     Nummer testNum1 = new Nummer("Inspiration", "unknownbrain", 3.06, "/music/inspiration_unknownBrain.mp3", gevoelensList);

    //     gevoelensList = new ArrayList<String>();
    //     gevoelensList.add("sad");
    //     gevoelensList.add("relaxed");

    //     Nummer testNum2 = new Nummer("Let it die", "unown", 3.06, "/music/LetItDie.mp3", gevoelensList);

    //     gevoelensList = new ArrayList<String>();
    //     gevoelensList.add("romantic");
    //     gevoelensList.add("happy");
    //     gevoelensList.add("inspired");

    //     Nummer testNum3 = new Nummer("Monody", "unknwon", 3.06, "/music/Monody.mp3", gevoelensList);

    //     gevoelensList = new ArrayList<String>();
    //     gevoelensList.add("focus");
    //     gevoelensList.add("relaxed");
    //     gevoelensList.add("inspired");
    
    //     Nummer testNum4 = new Nummer("Mice on venus", "Minecraft", 3.06, "/music/MiceOnVenus.mp3", gevoelensList);


    //     System.out.println(Nummer.nummers);
    //     PersistenceManager.saveMusic();
    // }

    // @Test
    // public void loadsong()
    // {
    //     PersistenceManager.loadMusic();

    //     System.out.println(Nummer.nummers);

    //     for (Nummer nummer : Nummer.nummers) {
    //         System.out.println(nummer.getBestandNaam());
    //     }
    // }
}
