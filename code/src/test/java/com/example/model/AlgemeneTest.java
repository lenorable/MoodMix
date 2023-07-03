package com.example.model;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

import org.junit.Test;

public class AlgemeneTest {

    // @Test 
    // public void alleGebruikers(){
    //     System.out.println("starting");
    //     for (Gebruiker user : Gebruiker.alleGebruikers) {
    //         System.out.println(user.getGebruikerNaam());
    //     }
    // }

    @Test
    public void load(){
        try {
            Path userStorage = Path.of("/home/MoodMixMusic/user.obj");

            InputStream is = Files.newInputStream(userStorage);
            ObjectInputStream ois = new ObjectInputStream(is);

            ArrayList<Gebruiker> test = (ArrayList<Gebruiker>) ois.readObject();

            // System.out.println(ois.readObject());

            for (Gebruiker user : test) {
                System.out.println(user.getGebruikerNaam() + " " + user.getRole());
            }

            ois.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    // @Test
    // public void save(){
    //     try {
    //         Gebruiker tester = new Gebruiker("hackerTest", "default");
    //         Gebruiker tester2 = new Gebruiker("blahaj", "default");

    //         ArrayList<Gebruiker> users = Gebruiker.alleGebruikers;

    //         OutputStream os = Files.newOutputStream(Path.of("/home/MoodMixMusic/user.obj"));
    //         ObjectOutputStream oos = new ObjectOutputStream(os);

    //         oos.writeObject(users);

    //         oos.close();
    //     } catch (IOException e) {
    //         System.out.println(e.getMessage());
    //     }
    // }

    // Gevoel v1 = new Gevoel("Blij");
    // Gevoel v2 = new Gevoel("Boos");

    // Gebruiker g1 = new Gebruiker("lenorable", "user");

    // Playlist p1 = new Playlist(g1, "coolste playlist");

    // ArrayList<Gevoel> gl1 = new ArrayList<Gevoel>();

    // Bericht b1 = new Bericht("luister dit nummer!", 0, g1);

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
