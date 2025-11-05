package org.emiliaargibayafonso.Utilidades;
import org.emiliaargibayafonso.DAO.ReviewDAO;
import java.sql.*;
import java.util.InputMismatchException;

import static org.emiliaargibayafonso.Main.sc;

public class AdministradorUsuario {
    public static void administrarEleccionUsuario(int eleccion) {
        try {
            Connection conn = ConexionBD.getConexion();

            switch (eleccion) {
                case 1:
                    sc.nextLine(); //Limpiar buffer
                    System.out.println("Elige el filtro de 'género de música' (Introducir nombre):\n1.Rock\n2.Metal");
                    String generoUsuario = sc.nextLine().toLowerCase();
                    if (generoUsuario.equalsIgnoreCase("rock") || generoUsuario.equalsIgnoreCase("metal")) {
                        ReviewDAO.filtrarGenero(conn, generoUsuario);
                        break;
                    } else {
                        System.out.println("Introduce uno de los dos géneros.\n\nVolviendo al menú principal...");
                        break;
                    }
                case 2:
                    ReviewDAO.sacarArtistasBestMusic(conn);
                    break;
                case 3:
                    ReviewDAO.sacarDiscosMenorNotaMedia(conn);
                    break;
                case 4:
                    ReviewDAO.devolverDiscosArtistaNotas(conn);
                    break;
                case 0:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Introduce un número del 0 al 4.");
                    break;
            }
        } catch (SQLException e) {
            System.out.println("Error al conector a la base de datos --> "+e.getMessage());
        } catch (InputMismatchException e) {
            System.out.println("Introducir solamente opciones numéricas enteras en la elección del menú.");
        }
    }
}
