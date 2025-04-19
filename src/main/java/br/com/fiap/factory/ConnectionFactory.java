package br.com.fiap.factory;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionFactory {

    private static final Properties prop = new Properties();
    private static final String URL;
    private static final String USERNAME;
    private static final String PASSWORD;

    static {
        try {
            FileInputStream fis = new FileInputStream("config.properties");
            prop.load(fis);
        } catch (IOException e) {
            System.err.println("Erro ao carregar o arquivo config.properties");
            e.printStackTrace();
        }

        URL = prop.getProperty("db.url");
        USERNAME = prop.getProperty("db.user");
        PASSWORD = prop.getProperty("db.password");
    }

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USERNAME, PASSWORD);
    }
}
