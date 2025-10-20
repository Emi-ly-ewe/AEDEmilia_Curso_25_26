package org.emiliaargibayafonso;

import java.sql.*;

public class ConexionDB {
    private static ConexionDB instancia;
    private static Connection conexion;

    private static final String URLDB = "jdbc:sqlite:secretaria.db";

    private ConexionDB() throws SQLException {
        try{
            conexion = DriverManager.getConnection(URLDB);
            System.out.println("Se ha conectado a la BD.");
        } catch (SQLException e) {
            e.printStackTrace();
            throw new SQLException("Fallo al conectarse a la base de datos.");
        }
    }

    public static Connection getConexion() throws SQLException {
        if (instancia == null) {
            instancia = new ConexionDB();
        }
        return conexion;
    }
}
