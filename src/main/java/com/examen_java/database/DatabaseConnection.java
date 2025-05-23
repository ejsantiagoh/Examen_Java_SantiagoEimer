package com.examen_java.database;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class DatabaseConnection {
    private static final Logger logger = LogManager.getLogger(DatabaseConnection.class);
    private static DatabaseConnection instance;
    private Connection connection;
    private final String url;
    private final String username;
    private final String password;

    public DatabaseConnection() {
        Properties props = new Properties();
        try (FileInputStream input = new FileInputStream("config/database.properties")) {
            props.load(input);
            this.url = props.getProperty("db.url");
            this.username = props.getProperty("db.username");
            this.password = props.getProperty("db.password");

            if (url == null || username == null || password == null) {
                throw new IllegalArgumentException("Faltan propiedades obligatorias en config/database.properties: db.url, db.username o db.password");
            }

            this.connection = DriverManager.getConnection(url, username, password);
            logger.info("Conexión a la base de datos establecida correctamente con URL: {}", url);
        } catch (IOException e) {
            logger.error("Error al leer el archivo config/database.properties: {}", e.getMessage(), e);
            throw new RuntimeException("No se pudo leer config/database.properties: " + e.getMessage(), e);
        } catch (SQLException e) {
            logger.error("Error al establecer la conexión a la base de datos: {}", e.getMessage(), e);
            throw new RuntimeException("Error al conectar a la base de datos: " + e.getMessage(), e);
        }
    }

    public static synchronized DatabaseConnection getInstance() {
        if (instance == null) {
            instance = new DatabaseConnection();
        }
        return instance;
    }

    public Connection getConnection() {
        try {
            if (connection == null || connection.isClosed()) {
                this.connection = DriverManager.getConnection(url, username, password);
                logger.info("Nueva conexión a la base de datos establecida con URL: {}", url);
            }
        } catch (SQLException e) {
            logger.error("Error al obtener o reestablecer la conexión: {}", e.getMessage(), e);
            throw new RuntimeException("Error al obtener la conexión: " + e.getMessage(), e);
        }
        return connection;
    }

    public void closeConnection() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
                logger.info("Conexión a la base de datos cerrada");
                connection = null; // Permite reiniciar la instancia si es necesario
            }
        } catch (SQLException e) {
            logger.error("Error al cerrar la conexión: {}", e.getMessage(), e);
            throw new RuntimeException("Error al cerrar la conexión: " + e.getMessage(), e);
        }
    }
}