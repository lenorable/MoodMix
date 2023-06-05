package com.example.webservices;

import javax.annotation.security.RolesAllowed;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/music")
public class MusicResource {
    
    @GET
    @RolesAllowed("admin")
    @Produces(MediaType.APPLICATION_JSON) //alleen als je ook iets terug stuurt
    public Response getShoppers() {
        return Response.ok().build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON) //alleen als je paramameters of iets in die richting op vraag lmao?
    @Produces(MediaType.APPLICATION_JSON)
    public Response addShopingList() {
        return Response.ok().build();
    }
}
