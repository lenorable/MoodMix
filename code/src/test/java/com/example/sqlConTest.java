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

    @Test
    public void testConect() {
        String URL = "jdbc:postgresql://server839881155.postgres.database.azure.com:5432/postgres";
        String username = "acidicDonkey8@server839881155";
        String password = "98f6ea00-f87a-4e90-99ca-c4c2b63caf9b";
        try (Connection connection = DriverManager.getConnection(URL, username, password)) {

            Statement statement = connection.createStatement();

            String query = "SELECT * from moodmixusers;";
            ResultSet resultSet = statement.executeQuery(query);

            System.out.println("Connected to the PostgreSQL database!");
        } catch (SQLException e) {
            System.out.println("Connection to the PostgreSQL database failed!");
            e.printStackTrace();
        }
    }
}
