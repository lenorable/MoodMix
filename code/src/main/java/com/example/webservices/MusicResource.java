package com.example.webservices;

import java.util.ArrayList;
import java.util.Map;

import javax.annotation.security.RolesAllowed;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.example.manager.PersistenceManager;
import com.example.model.Gevoel;
import com.example.model.Nummer;

class ReqGevoel {
    public String reqGevoel;
}

@Path("/music")
public class MusicResource {
    @POST
    @Consumes(MediaType.APPLICATION_JSON) // alleen als je paramameters of iets in die richting op vraag lmao?
    @Produces(MediaType.APPLICATION_JSON)
    public Response giveSongs(ReqGevoel req) {
        ArrayList<Nummer> songs = PersistenceManager.loadMusic();

        for (Nummer nummer : songs) {
            for (Gevoel gevoel : nummer.getGevoelens()) {
                if (gevoel.getGevoel().equals(req.reqGevoel)){
                    return Response.ok(Map.of("url", nummer.getBestandNaam())).build();
                }
            }
        }

        return Response.status(406, "gevoel niet bekend").build();
    }
}
