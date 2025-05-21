package br.com.fiap.factory;

import io.github.cdimascio.dotenv.Dotenv;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionFactory {

    public static Connection getConnection() {
        try {
            Class.forName("oracle.jdbc.OracleDriver");
            Dotenv dotenv = Dotenv.load();
            return DriverManager.getConnection(
                    dotenv.get("DB_URL"),
                    dotenv.get("DB_USER"),
                    dotenv.get("DB_PASSWORD")
            );
        } catch (Exception e) {
            System.err.println("Erro ao conectar: " + e.getMessage());
            throw new RuntimeException(e);
        }
    }

}
