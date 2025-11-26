package org.emiliaargibayafonso.Utilidades;
import org.emiliaargibayafonso.Modelo.Juego;
import java.sql.Connection;
import java.util.InputMismatchException;
import static org.emiliaargibayafonso.Main.sc;
import static org.emiliaargibayafonso.Gestores.GestorBBDD.*;

public class AdministradorUsuario {
    public static void administrarEleccionUsuario(int eleccion, Connection playConn) {
        try {
            switch (eleccion) {
                case 1:
                    sc.nextLine(); //Limpiar Buffer
                    System.out.println("Introduce los datos para insertar un juego de la siguiente manera:"
                            + "\nTitulo Juego;Desarrollador;Editorial;FechaSalidaEuropa;FechaSalidaJapon;FechaSalidaNorteAmerica");
                    String juegoUsuario = sc.nextLine();
                    Juego j = gestionarDatosJuegoUsuario(juegoUsuario);
                    insertarJuego(playConn,j);
                    break;
                case 2:
                    sc.nextLine(); //Limpiar buffer
                    System.out.println("Introduce el ID del juego que quieres modificar: (Del 1 al 50)");
                    int idModificar = sc.nextInt();
                    sc.nextLine(); //Limpiar buffer
                    System.out.println("Introduce los nuevos datos del juego en este formato:");
                    System.out.println("Titulo;Desarrollador;Editorial;FechaEuropa;FechaJapon;FechaNA");
                    String nuevosDatos = sc.nextLine();
                    String datosConID = idModificar + ";" + nuevosDatos; //Se agrega el ID que elige el usuario y se añade a los datos
                    Juego jModif = gestionarDatosJuegoUsuario(datosConID);
                    modificarJuego(playConn, jModif);
                    break;
                case 3:
                    juegosPorCompanya(playConn);
                    break;
                case 0:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Introduce un número del 0 al 4.");
                    break;
            }
        } catch (InputMismatchException e) {
            System.out.println("Introducir solamente opciones numéricas enteras en la elección del menú.");
        }
    }

    public static Juego gestionarDatosJuegoUsuario(String juegoUsuario) {
        String[] datosJuego = juegoUsuario.split(";");
        int idJuego = Integer.parseInt(datosJuego[0]);
        String tituloJuego = datosJuego[1];
        String desarrolladorJuego = datosJuego[2];
        String editorialJuego = datosJuego[3];
        String fechaEuropa = datosJuego[4];
        String fechaJapon = datosJuego[5];
        String fechaNA = datosJuego[6];
        return new Juego(idJuego,tituloJuego,desarrolladorJuego,editorialJuego,fechaEuropa,fechaJapon,fechaNA);
    }
}
