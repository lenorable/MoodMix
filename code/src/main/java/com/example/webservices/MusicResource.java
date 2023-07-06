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
    // @GET
    // @RolesAllowed("user")
    // @Consumes(MediaType.APPLICATION_JSON) // alleen als je paramameters of iets in die richting op vraag lmao?
    // @Produces(MediaType.APPLICATION_JSON)
    // public Response giveSongs(@Context SecurityContext sc) {
    //     Gebruiker gebruiker = (Gebruiker) sc.getUserPrincipal();

    //     gebruiker.getSetting().resetQue();

    //     System.out.println(gebruiker.getSetting().getGevoelens());

    //     for (Nummer nummer : Nummer.nummers) {
    //         for (String gevoel : nummer.getGevoelens()) {
    //             if (gebruiker.getSetting().getGevoelens().contains(gevoel)){
    //                 gebruiker.getSetting().setQueItem(nummer);
    //                 break;
    //             }
    //         }
            
    //     }

    //     return Response.ok(Map.of("urls", gebruiker.getSetting().getQueUrls())).build();
    // }

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
