package com.example;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.Test;

public class sqlConTest {

    @Test
    public void testReach() {
        String URL = "jdbc:postgresql://localhost:5432/MoodMix";
        String username = "postgres";
        String password = "k6LfYEIszD1cOP29qTvx";
        try (Connection connection = DriverManager.getConnection(URL, username, password)) {
            System.out.println("Connected to the PostgreSQL database!");
        } catch (SQLException e) {
            System.out.println("Connection to the PostgreSQL database failed!");
            e.printStackTrace();
        }
    }
}
