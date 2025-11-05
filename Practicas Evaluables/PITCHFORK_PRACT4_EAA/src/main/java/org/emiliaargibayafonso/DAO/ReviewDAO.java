package org.emiliaargibayafonso.DAO;
import java.sql.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class ReviewDAO implements InterfazDAO {
    /// DATETIMEFORMATTER PARA EL FORMATO DE "pub_date"
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd"); //Formato de la fecha
    public static LocalDate parseFecha(String texto) {return LocalDate.parse(texto, FORMATTER);}
    public static String formatFecha(LocalDate fecha) {return fecha.format(FORMATTER);}

    /// IMPLEMENTACIÓN DE LA INTERFAZ DAO
    @Override
    public void retrieveAll(Connection conexion) {
        String sqlSelect = "SELECT reviewid, title, artist, score, best_new_music, pub_date FROM reviews";
        try (PreparedStatement pdstmt = conexion.prepareStatement(sqlSelect)) {
            ResultSet rs = pdstmt.executeQuery();
            while (rs.next()) {
                System.out.println(rs.getInt("reviewid")+ " - Canción: "
                        +rs.getString("title")+" | Artista: "+rs.getString("artist")
                        +" | Puntuación: "+rs.getDouble("score")+ " | ¿Ranking Mejor Música? -> "
                        +rs.getInt("best_new_music")+" | Fecha Publicación: "+rs.getDate("pub_date"));
            }
        } catch (SQLException e) {
            System.out.println("Error al ejecutar la querySQL --> "+e.getMessage());
        }
    }
    @Override
    public boolean insert() {return false;}
    @Override
    public boolean update() {return false;}
    @Override
    public boolean delete() {return false;}

    /// FUNCIONES PARA LAS ACTIVIDADES
    public static void filtrarGenero(Connection conexion, String genero) {
        String sqlSelect = "SELECT rw.reviewid, rw.title, rw.artist, rw.score, rw.pub_date " +
                "FROM reviews rw JOIN genres gr ON rw.reviewid = gr.reviewid WHERE gr.genre = ?";
        try (PreparedStatement pdstmt = conexion.prepareStatement(sqlSelect)) {
            pdstmt.setString(1, genero);
            ResultSet rs = pdstmt.executeQuery();
            while (rs.next()) {
                LocalDate pubDate = parseFecha(rs.getString("pub_date"));
                System.out.println("["+rs.getInt("reviewid")
                        +"] Canción: " +rs.getString("title")
                        +" | Artista: "+rs.getString("artist")
                        +" | Puntuación: "+rs.getDouble("score")
                        +" | Fecha Publicación: "+formatFecha(pubDate));
            }
        } catch (SQLException e) {
            System.out.println("Error al ejecutar la querySQL --> "+e.getMessage());
        }
    }
    public static void sacarArtistasBestMusic(Connection conexion) {
        String sqlSelect = "SELECT rw.reviewid, rw.title, rw.artist, rw.score, rw.best_new_music, rw.pub_date FROM reviews rw " +
                "JOIN genres gr ON rw.reviewid = gr.reviewid WHERE rw.best_new_music = 1";
        try (PreparedStatement pdstmt = conexion.prepareStatement(sqlSelect)) {
            ResultSet rs = pdstmt.executeQuery();
            while (rs.next()) {
                LocalDate pubDate = parseFecha(rs.getString("pub_date"));
                System.out.println("["+rs.getInt("reviewid")
                        +"] Canción: " +rs.getString("title")
                        +" | Artista: "+rs.getString("artist")
                        +" | Puntuación: "+rs.getDouble("score")
                        +" | ¿MejorRankingMusica?: " +rs.getInt("best_new_music")
                        +" | Fecha Publicación: "+formatFecha(pubDate));
            }
        } catch (SQLException e) {
            System.out.println("Error al ejecutar la querySQL --> "+e.getMessage());
        }
    }
    public static void sacarDiscosMenorNotaMedia(Connection conexion) {
        String sqlSelect = "SELECT rw.reviewid, rw.title, rw.artist, gr.genre, rw.score, rw.best_new_music, rw.pub_date FROM reviews rw " +
                "JOIN genres gr ON rw.reviewid = gr.reviewid WHERE rw.score < (SELECT AVG(score) FROM reviews)";
        try (PreparedStatement pdstmt = conexion.prepareStatement(sqlSelect)) {
            ResultSet rs = pdstmt.executeQuery();
            while (rs.next()) {
                LocalDate pubDate = parseFecha(rs.getString("pub_date"));
                System.out.println("["+rs.getInt("reviewid") +"] Canción: " +rs.getString("title")
                        +" | Artista: "+rs.getString("artist")
                        +" | Género"+rs.getString("genre")
                        +" | Puntuación: "+rs.getDouble("score")
                        +" | ¿MejorRankingMusica?: " +rs.getInt("best_new_music")
                        +" | Fecha Publicación: "+formatFecha(pubDate));
            }
        } catch (SQLException e) {
            System.out.println("Error al ejecutar la querySQL --> "+e.getMessage());
        }
    }
    public static void devolverDiscosArtistaNotas(Connection conexion) {
        String sqlSelect = "SELECT ar.artist, COUNT(rw.reviewid) as total_discos, MAX(rw.score) as nota_maxima, MIN(rw.score) as nota_minima FROM reviews rw "+
                           "JOIN artists ar ON rw.reviewid = ar.reviewid GROUP BY ar.artist ORDER BY ar.artist";
        try (PreparedStatement pdstmt = conexion.prepareStatement(sqlSelect)) {
            ResultSet rs = pdstmt.executeQuery();
            while (rs.next()) {
                System.out.println("Artista: "+rs.getString("artist")+" | Discos Totales por Artista: "+rs.getDouble("total_discos")+
                                   " | Mayor Nota: "+rs.getDouble("nota_maxima")+" | Menor Nota: "+rs.getDouble("nota_minima"));
            }
        } catch (SQLException e) {
            System.out.println("Error al ejecutar la querySQL --> "+e.getMessage());
        }
    }
}
