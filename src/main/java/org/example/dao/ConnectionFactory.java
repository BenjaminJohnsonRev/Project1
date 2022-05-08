package org.example.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class ConnectionFactory {
    private static Connection connection = null;

    // make a private constructor, we can't manually instantiate this factory
    private ConnectionFactory() {

    }

    // this method will return a connection the SQL
    public static Connection getConnection() {

        //boolean switch for h2 database that we use for testing
        boolean test = false;
        if(test) {
            // if we don't have a connection yet, we can create one:
            if(connection == null) {
                try {
                    Class.forName("org.postgresql.Driver");
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
                // access these values from outside of this file (dbConfig.properties)
                ResourceBundle bundle = ResourceBundle.getBundle("dbConfigTest");
                //jdbc:sqlserver://<server_name>:<port>
                String url = bundle.getString("url");
                String username = bundle.getString("username");
                String password = bundle.getString("password");

                try {
                    connection = DriverManager.getConnection(url, username, password);
                } catch (SQLException e) {
                    System.out.println("Something went wrong when creating the connection!");
                    e.printStackTrace();
                }
            }

        } else {
            if(connection == null) {
                // if we don't have a connection yet, we can create one:
                try {
                    Class.forName("org.postgresql.Driver");
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
                // access these values from outside of this file (dbConfig.properties)
                ResourceBundle bundle = ResourceBundle.getBundle("dbConfig");
                //jdbc:sqlserver://<server_name>:<port>
                String url = bundle.getString("url");
                String username = bundle.getString("username");
                String password = bundle.getString("password");

                try {
                    connection = DriverManager.getConnection(url, username, password);
                } catch (SQLException e) {
                    System.out.println("Something went wrong when creating the connection!");
                    e.printStackTrace();
                }
            }
        }
        return connection;
    }
}
