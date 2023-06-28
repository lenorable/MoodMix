package com.example.webservices;

import java.security.Key;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Calendar;
import java.util.Map;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;

import org.postgresql.Driver;

import com.example.listner.MySecurityContext;
import com.example.manager.AuthorizationFilter;
import com.example.model.Gebruiker;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.impl.crypto.MacProvider;

@JsonIgnoreProperties
class loginRequest {
    public String username;
    public String password;
    public String email;
}

@Path("/login")
public class AuthenticationResource {
    public static Key key = MacProvider.generateKey();
    private String URL = "jdbc:postgresql://localhost:5432/MoodMix";
    private String username = "postgres";
    private String password = "k6LfYEIszD1cOP29qTvx";

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response login(loginRequest req) {

        try {
            DriverManager.registerDriver(new Driver());

            Connection connection = DriverManager.getConnection(URL, username, password);

            Statement statement = connection.createStatement();

            String query = "SELECT password FROM MoodMixUsers WHERE username LIKE '" + req.username + "';";
            ResultSet resultSet = statement.executeQuery(query);

            String passDB;

            while (resultSet.next()) {
                passDB = resultSet.getString("password");

                if (passDB.equals(req.password)) {
                    for (Gebruiker gebruiker : Gebruiker.alleGebruikers) {
                        if (gebruiker.getGebruikerNaam().equals(req.username)) {
                            Calendar expires = Calendar.getInstance();
                            expires.add(Calendar.HOUR, 2);

                            String token = Jwts.builder().setSubject(req.username).setExpiration(expires.getTime())
                                    .signWith(SignatureAlgorithm.HS512, key).compact();
                            return Response.ok(Map.of("token", token)).build();
                        }
                    }
                }
            }

            return Response.status(406).build();
        } catch (SQLException e) {
            return Response.status(503, e.getMessage()).build();
        } catch (Exception e) {
            return Response.status(500, e.getMessage()).build();
        }
    }

    @POST
    @Path("/new")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response makeUser(loginRequest req) {
        try {

            DriverManager.registerDriver(new Driver());

            Connection connection = DriverManager.getConnection(URL, username, password);

            Statement statement = connection.createStatement();

            String query = "SELECT username FROM MoodMixUsers WHERE username = '" + req.username + "';";

            ResultSet resultSet = statement.executeQuery(query);

            if (resultSet.next()) {
                return Response.status(409).build();
            } else {
                Gebruiker user = new Gebruiker(req.username, "user");
                query = " INSERT INTO moodmixusers (username, password, email) VALUES ('" + req.username + "', '"
                        + req.password + "', '" + req.email + "');";
                statement.execute(query);
                return login(req);
            }

        } catch (SQLException e) {
            return Response.status(503, e.getMessage()).build();
        } catch (Exception e) {
            return Response.status(500, e.getMessage()).build();
        }
    }

    @GET
    @Path("/check")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response checkUser(@Context SecurityContext sc) {
        try {
            Gebruiker gebruiker = (Gebruiker) sc.getUserPrincipal();

            System.out.println(gebruiker.getRole());

            if(sc.isUserInRole("user")){
                return Response.ok(Map.of("msg", "true")).build();
            } else {
                return Response.ok(Map.of("msg", "false")).build();
            }
        } catch (NullPointerException e){
            return Response.ok(Map.of("msg", "false")).build();
        } catch (Exception e) {
            return Response.status(500, e.getMessage()).build();
        }
    }
}