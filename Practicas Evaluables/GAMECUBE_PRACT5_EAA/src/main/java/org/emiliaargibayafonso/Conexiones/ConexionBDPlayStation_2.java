package org.emiliaargibayafonso.Conexiones;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBDPlayStation_2 {
    private static ConexionBDPlayStation_2 instance;
    private static Connection connectionPlay;
    private static final String URL_DB = "jdbc:sqlite:src/main/resources/playstation_2.db";

    private ConexionBDPlayStation_2() throws SQLException {
        try{
            connectionPlay = DriverManager.getConnection(URL_DB);
            System.out.println("Se ha conectado a la BD 'PlayStation_2'.");
        } catch (SQLException e) {
            e.printStackTrace();
            throw new SQLException("Fallo al conectarse a la base de datos.");
        }
    }
    public static Connection getConexion() throws SQLException {
        if (instance == null) {
            instance = new ConexionBDPlayStation_2();
        }
        return connectionPlay;
    }
}
