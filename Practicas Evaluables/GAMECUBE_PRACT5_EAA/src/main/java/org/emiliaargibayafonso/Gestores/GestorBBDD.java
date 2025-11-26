package org.emiliaargibayafonso.Gestores;
import org.emiliaargibayafonso.Modelo.Juego;
import java.sql.*;

public class GestorBBDD {
    public static void insertarJuego(Connection playConn, Juego j) {
        try {
            playConn.setAutoCommit(false);

            if (j.getTitulo().equalsIgnoreCase("God of War")) {
                System.out.println("Rollback de la transacción: No se puede insertar ningún juego titulado como 'God of War'");
                playConn.rollback();
                return;
            }

            String queryInsertarJuego = "INSERT INTO Juego_PlayStation2 (ID_Game,Title,Developer,Publisher,Europe__PAL,Japan,North_America) VALUES (?,?,?,?,?,?,?);";
            try (PreparedStatement pdstmt = playConn.prepareStatement(queryInsertarJuego)) {
                pdstmt.setInt(1, j.getId());
                pdstmt.setString(2, j.getTitulo());
                pdstmt.setString(3, j.getDesarrollador());
                pdstmt.setString(4, j.getEditorial());
                pdstmt.setString(5, j.getPublicacion_EU());
                pdstmt.setString(6, j.getPublicacion_JPN());
                pdstmt.setString(7, j.getPublicacion_NA());
                pdstmt.executeUpdate();
            }

            System.out.println("Commit: Se ha realizado la transacción con éxito.");
            playConn.commit();

        } catch (SQLException e) {
            try {
                System.out.println("ERROR => "+e.getMessage());
                System.out.println("Rollback realizado.");
                playConn.rollback();
            } catch (SQLException ex) {
                System.out.println("ERROR (ejecutando rollback) => "+ex.getMessage());
            }
        } finally {
            try {
                playConn.setAutoCommit(true);
            } catch (SQLException ex2) {
                System.out.println("ERROR (volver a poner a 'true' el autocommit)=> "+ex2.getMessage());
            }
        }
    }
    public static void modificarJuego(Connection playConn, Juego j) {
        try {
            playConn.setAutoCommit(false);

            if (j.getDesarrollador().equalsIgnoreCase("Sony")) {
                System.out.println("Rollback: No se puede modificar la compañía como 'Sony'");
                playConn.rollback();
                return;
            }

            String queryUpdateJuego = "UPDATE Juego_PlayStation2 SET Title=?, Developer=?, Publisher=?, Europe__PAL=?, Japan=?, North_America=? WHERE ID_Game=?";
            try (PreparedStatement pdstmt = playConn.prepareStatement(queryUpdateJuego)) {
                pdstmt.setString(1, j.getTitulo());
                pdstmt.setString(2, j.getDesarrollador());
                pdstmt.setString(3, j.getEditorial());
                pdstmt.setString(4, j.getPublicacion_EU());
                pdstmt.setString(5, j.getPublicacion_JPN());
                pdstmt.setString(6, j.getPublicacion_NA());
                pdstmt.setInt(7, j.getId());
                pdstmt.executeUpdate();
            }

            System.out.println("Commit: Se ha realizado la transacción con éxito.");
            playConn.commit();

        } catch (SQLException e) {
            try {
                System.out.println("ERROR => "+e.getMessage());
                System.out.println("Rollback realizado.");
                playConn.rollback();
            } catch (SQLException ex) {
                System.out.println("ERROR (ejecutando rollback) => "+ex.getMessage());
            }
        } finally {
            try {
                playConn.setAutoCommit(true);
            } catch (SQLException ex2) {
                System.out.println("ERROR (volver a poner a 'true' el autocommit)=> "+ex2.getMessage());
            }
        }
    }
    public static void juegosPorCompanya(Connection playConn) {
        String query = "SELECT Developer AS Companya, COUNT(*) AS TotalJuegos FROM Juego_GameCube GROUP BY Developer";
        try (Statement stmt = playConn.createStatement(); ResultSet rs = stmt.executeQuery(query)) {
            System.out.println("Juegos por compañía:\n");
            while (rs.next()) {
                String companya = rs.getString("Companya");
                int totalJuegos = rs.getInt("TotalJuegos");
                System.out.println("Hay un total de "+totalJuegos+" de la desarrolladora '"+companya+"'.");
            }
        } catch (SQLException e) {
            System.out.println("ERROR => " + e.getMessage());
        }
    }
}
