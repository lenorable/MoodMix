package com.example.listner;

import java.security.Principal;

import javax.ws.rs.core.SecurityContext;

import com.example.model.Gebruiker;

public class MySecurityContext implements SecurityContext{

    private Gebruiker user;

    public MySecurityContext (Gebruiker user){
        this.user = user;
    }

    @Override
    public Principal getUserPrincipal() {
        return user;
    }

    @Override
    public boolean isUserInRole(String role) {
        return user.getRole().equals(role);
    }

    @Override
    public boolean isSecure() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'isSecure'");
    }

    @Override
    public String getAuthenticationScheme() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAuthenticationScheme'");
    }
    
}
