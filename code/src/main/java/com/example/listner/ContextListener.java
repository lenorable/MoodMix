package com.example.listner;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import com.example.model.Gebruiker;
import com.example.model.Gevoel;

@WebListener
public class ContextListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("starting application");

        Gevoel blij = new Gevoel("blij");

        Gebruiker test1 = new Gebruiker("lenor", "lenorable", 0, "qwerty", "admin");
        Gebruiker test2 = new Gebruiker("lynn", "nyr", 0, "0000", "hacker");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("stopping application");
    }
}
