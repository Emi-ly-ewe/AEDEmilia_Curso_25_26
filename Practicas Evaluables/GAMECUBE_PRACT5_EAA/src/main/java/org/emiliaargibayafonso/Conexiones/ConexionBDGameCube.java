package org.emiliaargibayafonso.Conexiones;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBDGameCube {
    private static ConexionBDGameCube instance;
    private static Connection connectionGameCube;
    private static final String URL_DB = "jdbc:sqlite:src/main/resources/gamecube.db";

    private ConexionBDGameCube() throws SQLException {
        try{
            connectionGameCube = DriverManager.getConnection(URL_DB);
            System.out.println("Se ha conectado a la BD 'GameCube'.");
        } catch (SQLException e) {
            e.printStackTrace();
            throw new SQLException("Fallo al conectarse a la base de datos.");
        }
    }
    public static Connection getConexion() throws SQLException {
        if (instance == null) {
            instance = new ConexionBDGameCube();
        }
        return connectionGameCube;
    }
}
