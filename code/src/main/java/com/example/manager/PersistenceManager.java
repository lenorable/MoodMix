package com.example.manager;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

import com.example.model.Nummer;

public class PersistenceManager {

    public static ArrayList<Nummer> updateMusicList(ArrayList<Nummer> listnum){
        ArrayList<Nummer> loadedList = loadMusic();
        
        for (Nummer song : listnum) {
            loadedList.add(song);
        }

        return loadedList;
    }

    public static ArrayList<Nummer> updateMusicListSingle(Nummer num){
        ArrayList<Nummer> loadedList = loadMusic();
        loadedList.add(num);
        return loadedList;
    }

    public static ArrayList<Nummer> loadMusic() {
        try {
            Path songStorage = Path.of("/home/song.obj");

            InputStream is = Files.newInputStream(songStorage);
            ObjectInputStream ois = new ObjectInputStream(is);

            ArrayList<Nummer> music = (ArrayList<Nummer>) ois.readObject();

            ois.close();
            return music;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return null;
    }

    public static void saveMusic(ArrayList<Nummer> nummers) {
        try {
            OutputStream os = Files.newOutputStream(Path.of("/home/song.obj"));
            ObjectOutputStream oos = new ObjectOutputStream(os);

            oos.writeObject(nummers);
            oos.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
