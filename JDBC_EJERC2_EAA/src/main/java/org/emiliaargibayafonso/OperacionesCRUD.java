package org.emiliaargibayafonso;

import java.sql.*;

public class OperacionesCRUD {
    public static void crearTablas() {
        try {
            Connection conn = ConexionDB.getConexion(); //Se crea la conexión fuera del try with resources para evitar que se cierre.
            try (Statement stmt = conn.createStatement()) {
                String tablaAlumno = """
                            CREATE TABLE IF NOT EXISTS Alumnos (
                                id INTEGER PRIMARY KEY AUTOINCREMENT,
                                nombre TEXT NOT NULL,
                                apellidos TEXT NOT NULL
                            );
                        """;
                String tablaSobre = """
                            CREATE TABLE IF NOT EXISTS Sobres (
                                idSobre INTEGER PRIMARY KEY AUTOINCREMENT,
                                estaCompleto INTEGER NOT NULL,
                                ciclo TEXT NOT NULL
                            );
                        """;

                stmt.execute(tablaAlumno);
                stmt.execute(tablaSobre);

                System.out.println("Tablas 'Alumnos' y 'Sobres' creadas correctamente");
            }
        } catch (SQLException e) {
            System.out.println("ERROR AL CREAR AMBAS TABLAS --> " + e.getMessage());
        }
    }

    public static void insertarPersona(String nom, String ape) {
        String sql = "INSERT INTO Alumnos(nombre, apellidos) VALUES (?,?)";
        try {
            Connection conn = ConexionDB.getConexion(); //Se crea la conexión fuera del try with resources para evitar que se cierre.
            try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
                pstmt.setString(1, nom);
                pstmt.setString(2, ape);
                pstmt.executeUpdate();

                System.out.println("Alumno insertado correctamente.");
            }
        } catch (SQLException e) {
            System.out.println("ERROR AL INSERTAR ALUMNO --> " + e.getMessage());
        }
    }

    public static void insertarSobre(boolean completo, String ciclo) {
        String sql = "INSERT INTO Sobres(estaCompleto, ciclo) VALUES (?,?)";
        try {
            Connection conn = ConexionDB.getConexion(); //Se crea la conexión fuera del try with resources para evitar que se cierre.
            try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
                pstmt.setBoolean(1, completo);
                pstmt.setString(2, ciclo);
                pstmt.executeUpdate();

                System.out.println("Sobre insertado correctamente.");
            }
        } catch (SQLException e) {
            System.out.println("ERROR AL INSERTAR SOBRE --> " + e.getMessage());
        }
    }

    public static void obtenerTodosAlumnos() {
        String sql = "SELECT * FROM Alumnos";
        try {
            Connection conn = ConexionDB.getConexion(); //Se crea la conexión fuera del try with resources para evitar que se cierre.
            try (Statement stmt = conn.createStatement();
                 ResultSet rs = stmt.executeQuery(sql)) {

                while (rs.next()) {
                    System.out.println("ID: " + rs.getInt("id") + "\t" +
                            "Nombre: " + rs.getString("nombre") + " " +
                            "Apellidos: " + rs.getString("apellidos"));
                }
            }
        } catch (SQLException e) {
            System.out.println("ERROR AL MOSTRAR TODOS LOS ALUMNOS --> " + e.getMessage());
        }
    }

    public static void obtenerSobreCiclo(String cicloAbrev) {
        String sql = "SELECT * FROM Sobres WHERE ciclo = ?";
        try {
            Connection conn = ConexionDB.getConexion(); //Se crea la conexión fuera del try with resources para evitar que se cierre.
            try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
                pstmt.setString(1, cicloAbrev);
                try (ResultSet rs = pstmt.executeQuery()) {
                    while (rs.next()) {
                        System.out.println("ID: " + rs.getInt("idSobre") +
                                " | Completo: " + rs.getBoolean("estaCompleto") +
                                " | Ciclo: " + rs.getString("ciclo"));
                    }
                }
            }
        } catch (SQLException e) {
            System.out.println("ERROR AL MOSTRAR LOS SOBRES --> " + e.getMessage());
        }
    }

}
