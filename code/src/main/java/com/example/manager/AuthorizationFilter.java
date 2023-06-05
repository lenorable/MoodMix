package com.example.manager;

import java.io.IOException;

import javax.annotation.Priority;
import javax.ws.rs.Priorities;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.ext.Provider;

import com.example.listner.MySecurityContext;
import com.example.model.Gebruiker;
import com.example.webservices.AuthenticationResource;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtParser;
import io.jsonwebtoken.Jwts;

@Provider
@Priority(Priorities.AUTHENTICATION)
public class AuthorizationFilter implements ContainerRequestFilter{

    @Override
    public void filter(ContainerRequestContext requestContext) throws IOException {
        String authHeader = requestContext.getHeaderString("Authorization");

        try{
            if (authHeader != null){
                String jwtString = authHeader;

                JwtParser parser = Jwts.parser();
                Claims claims = parser.setSigningKey(AuthenticationResource.key).parseClaimsJws(jwtString).getBody();
                
                String userName = claims.getSubject();
                
                for (Gebruiker user : Gebruiker.getAllGebruikers()) {
                    if (user.getName().equals(userName)){
                        MySecurityContext msc = new MySecurityContext(user);
                        requestContext.setSecurityContext(msc);
                    }
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
}
