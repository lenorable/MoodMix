package com.example.model;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Test;

public class AlgemeneTest {
    Gevoel v1 = new Gevoel("Blij");
    Gevoel v2 = new Gevoel("Boos");

    Gebruiker g1 = new Gebruiker("lenorable", "user");

    Playlist p1 = new Playlist(g1, "coolste playlist");

    ArrayList<Gevoel> gl1 = new ArrayList<Gevoel>();

    Bericht b1 = new Bericht("luister dit nummer!", 0, g1);

    // @Test
    // public void shouldPass() {
    //     gl1.add(v1);
    //     gl1.add(v2);

    //     Nummer n1 = new Nummer("Inspiration", "Unknown Brain", 3.02, "inspiration_unkownBrain", gl1);
    //     Nummer n2 = new Nummer("Teenage Fantasy", "jorja Smith", 3.46, "Teenage_Fanstasy_jorja_smith", gl1);

    //     assertEquals("succes!", b1.addLike(g1));
    //     assertEquals("succes!", g1.addBericht(b1));
    //     assertEquals("succes!", g1.addPlaylists(p1));
    //     assertEquals("succes!", p1.addNummer(n1));
    // }

}
