package org.users.list.services;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ServiceProvider {

    public static Connection getConnection() throws SQLException, IOException {
        Properties props = new Properties();

        try (InputStream in = ServiceProvider
                                .class
                                .getClassLoader()
                                .getResourceAsStream(
                                        "db/db.properties")) {
            props.load(in);
        }

        String drivers = props.getProperty("driver");
        if(drivers != null) {
            System.setProperty("driver", drivers);
            try {
                Class.forName(drivers);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }

        String url = props.getProperty("url");
        String username = props.getProperty("username");
        String password = props.getProperty("password");

        return DriverManager.getConnection(url, username, password);
    }
}
