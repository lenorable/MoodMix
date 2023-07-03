package com.example.webservices;

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

import com.example.model.Gebruiker;
import com.example.model.Nummer;
import com.example.model.Playlist;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
class PlaylistReq {
    public String playlistName;
    public String summary;
    public String bestandNaam;
}

@Path("/playlist")
public class playlistRecource {
    @GET
    @RolesAllowed("user")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response getPlaylists(@Context SecurityContext sc) {
        Gebruiker gebruiker = (Gebruiker) sc.getUserPrincipal();

        ArrayList<String> playlists = new ArrayList<String>();

        for (Playlist playList : gebruiker.getPlaylists()) {
            playlists.add(playList.getNaam());
        }

        return Response.ok(Map.of("msg", playlists)).build();
    }

    @POST
    @Path("/make")
    @RolesAllowed("user")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response makePlaylist(@Context SecurityContext sc, PlaylistReq req) {
        Gebruiker gebruiker = (Gebruiker) sc.getUserPrincipal();

        for (Playlist playList : gebruiker.getPlaylists()) {
            if (playList.getNaam().equals(req.playlistName)) {
                return Response.status(449, "playlist already exists").build();
            }
        }

        gebruiker.addPlaylists(new Playlist(gebruiker, req.playlistName, req.summary));

        return Response.ok(Map.of("msg", "playlist created")).build();
    }

    @POST
    @Path("/add")
    @RolesAllowed("user")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addSongs(@Context SecurityContext sc, PlaylistReq req) {
        Gebruiker gebruiker = (Gebruiker) sc.getUserPrincipal();

        for (Playlist playlist : gebruiker.getPlaylists()) {
            if (playlist.getNaam().equals(req.playlistName)) {

                for (Nummer nummer : Nummer.nummers) {
                    if (nummer.getBestandNaam().equals(req.bestandNaam)) {

                        if (playlist.getNummers().contains(nummer.getBestandNaam())){
                            return Response.status(449, "song already in playlist").build(); 
                        } else {
                            playlist.addNummer(nummer.getBestandNaam());
                            return Response.ok(Map.of("msg", "song added")).build();
                        }
                    }
                }

                return Response.status(400, "song doesn't exists").build();

            }
        }

        return Response.status(449, "playlist doesn't exists").build();
    }
}
