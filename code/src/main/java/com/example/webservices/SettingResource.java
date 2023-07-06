package com.example.webservices;

import java.util.ArrayList;
import java.util.Map;

import javax.annotation.security.RolesAllowed;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;

import com.example.model.Gebruiker;
import com.example.model.Nummer;
import com.example.model.Setting;

class GevoelRequest{
    public ArrayList<String> gevoelens;
}

class PomodoroSettings{
    public int work;
    public int shortP;
    public int longP;
}

@Path("/settings")
public class SettingResource {

    @POST
    @RolesAllowed("user")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response setGevoelens(@Context SecurityContext sc, GevoelRequest req){
        try {
            Gebruiker gebruiker = (Gebruiker) sc.getUserPrincipal();

            gebruiker.getSetting().setGevoelens(req.gevoelens);

            return Response.ok(Map.of("set", gebruiker.getSetting().getGevoelens())).build();
        } catch (Exception e) {
            return Response.status(500, e.getMessage()).build();
        }
    }

    @GET
    @RolesAllowed("user")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response getGevoelens(@Context SecurityContext sc){
        try {
            Gebruiker gebruiker = (Gebruiker) sc.getUserPrincipal();

            return Response.ok(Map.of("gevoelens", gebruiker.getSetting().getGevoelens())).build();
        } catch (Exception e) {
            return Response.status(500, e.getMessage()).build();
        }
    }

    @GET
    @Path("/que")
    @RolesAllowed("user")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response getQue(@Context SecurityContext sc){
        try {
            Gebruiker gebruiker = (Gebruiker) sc.getUserPrincipal();

            return Response.ok(Map.of("msg", gebruiker.getSetting().getQue())).build();
        } catch (Exception e) {
            return Response.status(500, e.getMessage()).build();
        }
    }

    @POST
    @Path("/que")
    @RolesAllowed("user")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response setQueItem(@Context SecurityContext sc, String bestandNaam){
        try {
            Gebruiker gebruiker = (Gebruiker) sc.getUserPrincipal();

            gebruiker.getSetting().setQueItem(bestandNaam);

            return Response.ok(Map.of("msg", "gelukt")).build();
        } catch (Exception e) {
            return Response.status(500, e.getMessage()).build();
        }
    }

    @PUT
    @Path("/que")
    @RolesAllowed("user")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response resetQue(@Context SecurityContext sc){
        try {
            Gebruiker gebruiker = (Gebruiker) sc.getUserPrincipal();

            gebruiker.getSetting().resetQue();

            return Response.ok(Map.of("msg", "gelukt")).build();
        } catch (Exception e) {
            return Response.status(500, e.getMessage()).build();
        }
    }

    //for makeking pomodoro que
    @GET
    @Path("/que/pomo")
    @RolesAllowed("user")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response pomodoroQue(@Context SecurityContext sc){
        try {
            Gebruiker gebruiker = (Gebruiker) sc.getUserPrincipal();

            gebruiker.getSetting().resetQue(); //zodat je schoon begint

            int totalTime = gebruiker.getSetting().getWorkTime() + gebruiker.getSetting().getSortPauseTime() + gebruiker.getSetting().getLongPauseTime();
            int songCount = (int) Math.ceil(totalTime/3); //gemiddelde nodig song voor de sessie (kan verbeterd worden)
            int count = 0;

            for (Nummer song : Nummer.nummers) {
                gebruiker.getSetting().setQueItem(song.getBestandNaam());
                
                count += 1;

                if (count == songCount){
                    break;
                }
            }

            return Response.ok(Map.of("msg", "gelukt")).build();
        } catch (Exception e) {
            return Response.status(500, e.getMessage()).build();
        }
    }

    @POST
    @Path("/pomoset")
    @RolesAllowed("user")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response pomoSettings(@Context SecurityContext sc, PomodoroSettings req){
        try {
            Gebruiker gebruiker = (Gebruiker) sc.getUserPrincipal();
            Setting userSet = gebruiker.getSetting();

            userSet.setWorkTime(req.work);
            userSet.setSortPauseTime(req.shortP);
            userSet.setLongPauseTime(req.longP);

            return Response.ok(Map.of("msg", "gelukt")).build();
        } catch (Exception e) {
            return Response.status(500, e.getMessage()).build();
        }
    }

    @GET
    @Path("/pomoset")
    @RolesAllowed("user")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response pomoSettingsGet(@Context SecurityContext sc){
        try {
            Gebruiker gebruiker = (Gebruiker) sc.getUserPrincipal();
            Setting userSet = gebruiker.getSetting();
            
            return Response.ok(Map.of("msg", Map.of("work", userSet.getWorkTime(), "shortP", userSet.getSortPauseTime(), "longP", userSet.getLongPauseTime()))).build();
        } catch (Exception e) {
            return Response.status(500, e.getMessage()).build();
        }
    }

}
