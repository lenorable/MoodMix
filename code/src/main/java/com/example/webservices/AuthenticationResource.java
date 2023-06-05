package com.example.webservices;

import java.security.Key;
import java.util.Calendar;
import java.util.Map;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.example.model.Gebruiker;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.impl.crypto.MacProvider;

class loginRequest {
    public String username;
    public String password;
}

@Path("/login")
public class AuthenticationResource {
    public static Key key = MacProvider.generateKey();

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response login(loginRequest req) {

        try {
            for (Gebruiker gebruiker : Gebruiker.getAllGebruikers()) {
                if (gebruiker.getGebruikerNaam().equals(req.username) && gebruiker.checkPassword(req.password)) {

                    Calendar expires = Calendar.getInstance();
                    expires.add(Calendar.HOUR, 2);

                    String token = Jwts.builder().setSubject(req.username).setExpiration(expires.getTime())
                            .signWith(SignatureAlgorithm.HS512, key).compact();
                    return Response.ok(Map.of("token", token)).build();
                }
            }
            return Response.status(406).build();
        } catch (Exception e) {
            return Response.status(500, e.getMessage()).build();
        }
    }
}
