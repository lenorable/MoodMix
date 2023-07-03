package com.example.manager;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import com.example.model.Gebruiker;
import com.example.model.Nummer;

public class PersistenceManager {
    // saving user's (1)
    public static void loadUsers() {
        try {
            Path userStorage = Path.of("/home/MoodMixMusic/user.obj");

            InputStream is = Files.newInputStream(userStorage);
            ObjectInputStream ois = new ObjectInputStream(is);

            Gebruiker.alleGebruikers = (ArrayList<Gebruiker>) ois.readObject();

            ois.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void saveUsers() {
        try {
            ArrayList<Gebruiker> users = Gebruiker.alleGebruikers;

            OutputStream os = Files.newOutputStream(Path.of("/home/MoodMixMusic/user.obj"));
            ObjectOutputStream oos = new ObjectOutputStream(os);

            System.out.println("really saving: " + users);

            for (Gebruiker gebruiker : users) {
                System.out.println(gebruiker.getPlaylists());
            }

            oos.writeObject(users);

            oos.close();

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    // saving music (2)
    public static void loadMusic() {
        try {
            Path songStorage = Path.of("/home/song.obj");

            InputStream is = Files.newInputStream(songStorage);
            ObjectInputStream ois = new ObjectInputStream(is);

            Nummer.nummers = (ArrayList<Nummer>) ois.readObject();

            ois.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void saveMusic() {
        try {
            ArrayList<Nummer> nummers = Nummer.nummers;

            OutputStream os = Files.newOutputStream(Path.of("/home/song.obj"));
            ObjectOutputStream oos = new ObjectOutputStream(os);

            oos.writeObject(Nummer.nummers);
            oos.close();

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
