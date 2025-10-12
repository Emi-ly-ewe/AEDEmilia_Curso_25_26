package org.emiliaargibayafonso;

import java.util.*;
import static org.emiliaargibayafonso.Funciones.*;

public class Main {
    private static Scanner sc = new Scanner(System.in);
    private static MenuOpciones menu;
    private static int eleccion;
    private static ArrayList<Videojuego> contenidoXML;

    public static void main(String[] args) {
        String[] opciones = {
                "1) Lee el fichero 'metacritic.xml'.",
                "2) Modificar la fecha de salida en el fichero 'metacritic.xml'.)",
                "3) Sacar los juegos que tengan mayor calificación que...",
                "4) Filtrar juegos por épocas. (De 'X' a 'Y').",
                "5) Generar top 'N' de juegos filtrados por 'X' plataforma.",
                "6) Guardar juegos filtrados por 'X' plataforma.",
                "7) Almacenar juegos ordenados por décadas, \n destacando el mejor y peor de cada década por MetaScore."
        };
        menu = new MenuOpciones(opciones);

        do {
            menu.mostrarMenu();
            eleccion = sc.nextInt();
            sc.nextLine(); //Limpiar linea pendiente
            switch (eleccion) {
                case 1:
                    imprimirFicheroMetacritics();
                    break;
                case 2, 7:
                    System.out.println("EN CONSTRUCCIÓN...");
                    break;
                case 3:
                    System.out.println("Introduce la nota que desees (Del 1 al 100)");
                    int notaUsuario = sc.nextInt();
                    sacarMejoresNota(notaUsuario);
                    break;
                case 4:
                    System.out.println("Introduce el año inicial ('X'):");
                    int anyoInicialUsuario = sc.nextInt();
                    System.out.println("Introduce el año final ('Y'):");
                    int anyoFinalUsuario = sc.nextInt();
                    filtrarEntreAnyos(anyoInicialUsuario,anyoFinalUsuario);
                    break;
                case 5:
                    System.out.println("Introduce un número para el top:");
                    int topUsuario = sc.nextInt();
                    sc.nextLine(); // Limpiar linea pendiente
                    System.out.println("Introduce una plataforma para filtrar:");
                    String plataformaElegida = sc.nextLine();
                    generarTopPlataforma(topUsuario,plataformaElegida);
                    break;
                case 6:
                    System.out.println("Introduce una plataforma:");
                    String plataformaUsuario = sc.nextLine();
                    generarFicheroPlataforma(plataformaUsuario);
                    break;
                case 0:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Introduce un número del 0 al 7... ");
                    break;
            }
        } while (eleccion != 0);
    }
}