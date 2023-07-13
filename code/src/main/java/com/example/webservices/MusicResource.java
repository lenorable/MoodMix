package com.example.webservices;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Map;

import javax.annotation.security.RolesAllowed;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;

import com.example.manager.PersistenceManager;
import com.example.model.Gebruiker;
// import com.example.model.Gevoel;
import com.example.model.Nummer;
import com.example.model.Playlist;

class ReqGevoel {
    public ArrayList<String> reqGevoel;
}

@Path("/music")
public class MusicResource {

    @GET
    @Path("/create")
    @RolesAllowed("user")
    @Consumes(MediaType.APPLICATION_JSON) // alleen als je paramameters of iets in die richting op vraag lmao?
    @Produces(MediaType.APPLICATION_JSON)
    public Response createSongs(@Context SecurityContext sc) {
        Gebruiker gebruiker = (Gebruiker) sc.getUserPrincipal();

        ArrayList<String> gevoelensList = new ArrayList<String>();
        gevoelensList.add("euphoric");
        gevoelensList.add("happy");
        gevoelensList.add("inspired");

        Nummer testNum1 = new Nummer("Inspiration", "unknownbrain", 3.06, "/music/inspiration_unknownBrain.mp3", gevoelensList);

        gevoelensList = new ArrayList<String>();
        gevoelensList.add("sad");
        gevoelensList.add("relaxed");

        Nummer testNum2 = new Nummer("Let it die", "unown", 3.06, "/music/LetItDie.mp3", gevoelensList);

        gevoelensList = new ArrayList<String>();
        gevoelensList.add("romantic");
        gevoelensList.add("happy");
        gevoelensList.add("inspired");

        Nummer testNum3 = new Nummer("Monody", "unknwon", 3.06, "/music/Monody.mp3", gevoelensList);

        gevoelensList = new ArrayList<String>();
        gevoelensList.add("focus");
        gevoelensList.add("relaxed");
        gevoelensList.add("inspired");
    
        Nummer testNum4 = new Nummer("Mice on venus", "Minecraft", 3.06, "/music/MiceOnVenus.mp3", gevoelensList);


        System.out.println(Nummer.nummers);
        // PersistenceManager.saveMusic();

        return Response.ok(Map.of("msg", "ok")).build();
    }

    @GET
    @Path("/recommend")
    @RolesAllowed("user")
    @Consumes(MediaType.APPLICATION_JSON) // alleen als je paramameters of iets in die richting op vraag lmao?
    @Produces(MediaType.APPLICATION_JSON)
    public Response getSongs(@Context SecurityContext sc) {
        Gebruiker gebruiker = (Gebruiker) sc.getUserPrincipal();
        
        ArrayList<Map> songs = new ArrayList<Map>();

        for (Nummer nummer : Nummer.nummers) {
            for (String gevoel : nummer.getGevoelens()) {
                if (gebruiker.getSetting().getGevoelens().contains(gevoel)){
                    songs.add(Map.of("naam", nummer.getNaam(), "url", nummer.getBestandNaam()));
                    break;
                }
            }
            
        }

        return Response.ok(Map.of("urls", songs)).build();
    }

    @GET
    @Path("/saved")
    @RolesAllowed("user")
    @Consumes(MediaType.APPLICATION_JSON) // alleen als je paramameters of iets in die richting op vraag lmao?
    @Produces(MediaType.APPLICATION_JSON)
    public Response getSavedSongs(@Context SecurityContext sc) {
        Gebruiker gebruiker = (Gebruiker) sc.getUserPrincipal();
        
        ArrayList<Map> songs = new ArrayList<Map>();

        for (Playlist playlist : gebruiker.getPlaylists()) {
            for (String nummerName : playlist.getNummers()) {
                for (Nummer nummer : Nummer.nummers) {
                    if (nummer.getBestandNaam().equals(nummerName)){
                        for (String gevoel : nummer.getGevoelens()) {
                            if (gebruiker.getSetting().getGevoelens().contains(gevoel)){
                                songs.add(Map.of("naam", nummer.getNaam(), "url", nummer.getBestandNaam()));
                                break;
                            }
                        }
                    }
                }
            }
        }

        // for (Nummer nummer : Nummer.nummers) {
        //     for (String gevoel : nummer.getGevoelens()) {
        //         if (gebruiker.getSetting().getGevoelens().contains(gevoel)){
        //             songs.add(Map.of("naam", nummer.getNaam(), "url", nummer.getBestandNaam()));
        //             break;
        //         }
        //     }
            
        // }

        return Response.ok(Map.of("urls", songs)).build();
    }
}
