package org.emiliaargibayafonso.Utilidades;
import java.sql.*;

public class ConexionBD {
    private static ConexionBD instance;
    private static Connection connection;
    private static final String URL_DB = "jdbc:sqlite:src/main/resources/pitchfork.db";

    private ConexionBD() throws SQLException {
        try{
            connection = DriverManager.getConnection(URL_DB);
            System.out.println("Se ha conectado a la BD.");
        } catch (SQLException e) {
            e.printStackTrace();
            throw new SQLException("Fallo al conectarse a la base de datos.");
        }
    }

    public static Connection getConexion() throws SQLException {
        if (instance == null) {
            instance = new ConexionBD();
        }
        return connection;
    }
}
