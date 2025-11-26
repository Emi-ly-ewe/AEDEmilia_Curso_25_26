package org.emiliaargibayafonso;
import org.emiliaargibayafonso.Conexiones.ConexionBDGameCube;
import org.emiliaargibayafonso.Conexiones.ConexionBDPlayStation_2;
import org.emiliaargibayafonso.Utilidades.MenuOpciones;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;
import static org.emiliaargibayafonso.Utilidades.AdministradorUsuario.administrarEleccionUsuario;
import static org.emiliaargibayafonso.Gestores.GestorMigracion.*;

public class Main {
    public static final Scanner sc = new Scanner(System.in);
    private static final String[] opciones = {"1) Insertar un juego nuevo. (Rollback -> God of War)",
            "2) Modificar un juego existente. (Rollback -> Sony)",
            "3) Sacar los juegos filtrados por companya."};
    private static final MenuOpciones menu = new MenuOpciones(opciones);

    static void main() {
        try {
            Connection gameCubeConn = ConexionBDGameCube.getConexion();
            Connection playConn = ConexionBDPlayStation_2.getConexion();

            crearTablas(gameCubeConn, playConn);
            pasarDatos(gameCubeConn, playConn);
            int eleccion;
            do {
                menu.mostrarMenu();
                eleccion = sc.nextInt();
                administrarEleccionUsuario(eleccion, playConn);
            } while (eleccion!=0);
        } catch (SQLException e) {
            System.out.println("ERROR ==> "+e.getMessage());
        }
    }
}
///NOTA: HAY QUE BORRAR EL DB DE PLAY PARA QUE SE EJECUTE ADECUADAMENTE CADA QUE SE INICIA.