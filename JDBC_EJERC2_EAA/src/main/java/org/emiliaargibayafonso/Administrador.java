package org.emiliaargibayafonso;
import static org.emiliaargibayafonso.OperacionesCRUD.*;
import static org.emiliaargibayafonso.Main.*;

public class Administrador {
    public static void administrarEleccionUsuario(int eleccion) {
        switch (eleccion) {
            case 1:
                sc.nextLine(); //Limpiar buffer
                System.out.println("Introduce el nombre:");
                String nombre = sc.nextLine();
                System.out.println("Introduce los apellidos:");
                String apellidos = sc.nextLine();

                insertarPersona(nombre, apellidos);
                break;
            case 2:
                sc.nextLine(); //Limpiar buffer
                System.out.println("¿Esta completo el sobre? (s/n)");
                String completoUsuario = sc.nextLine();
                boolean completoSobre = completoUsuario.equalsIgnoreCase("s");
                // Si el usuario inserta 's', el sobre está completo, sino, no está completo. (equalsIgnoreCase devuelve boolean)

                System.out.println("Inserte el ciclo (DAM,DAW,ASIR...)");
                String ciclo = sc.nextLine();

                insertarSobre(completoSobre, ciclo);
                break;
            case 3:
                obtenerTodosAlumnos();
                break;
            case 4:
                System.out.println("Introduce el ciclo por el que filtrar:");
                String cicloAbreviado = sc.nextLine();

                obtenerSobreCiclo(cicloAbreviado);
                break;
            case 0:
                System.out.println("Saliendo del programa...");
                break;
            default:
                System.out.println("Introduce un número del 0 al 4.");
                break;
        }
    }
}
