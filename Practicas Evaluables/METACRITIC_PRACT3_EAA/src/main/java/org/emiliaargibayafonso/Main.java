package org.emiliaargibayafonso;

import java.util.*;
import static org.emiliaargibayafonso.Funciones.*;

public class Main {
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        String[] opciones = {
                "1) Lee el fichero 'metacritic.xml'.",
                "2) Modificar la fecha de salida en el fichero 'metacritic.xml'.",
                "3) Sacar los juegos que tengan mayor calificación que...",
                "4) Filtrar juegos por épocas. (De 'X' a 'Y').",
                "5) Generar top 'N' de juegos filtrados por 'X' plataforma.",
                "6) Guardar juegos filtrados por 'X' plataforma.",
                "7) Almacenar juegos ordenados por décadas, \n destacando el mejor y peor de cada década por MetaScore."
        };

        MenuOpciones menu = new MenuOpciones();
        int eleccion = sc.nextInt();
        do {
            switch (eleccion) {
                case 1:
                    leerFicheroMetacritic();
                    break;
                case 2:
                    /// Dejar para el final si no sale el 7
                    break;
                case 3:
                    System.out.println("Introduce la nota que desees (Del 1 al 100)");
                    int notaUsuario = sc.nextInt();
                    boolean resultado3 = sacarMejoresNota(notaUsuario);
                    if (resultado3) {
                        System.out.println("Fichero (nomfichero) escrito y guardado con éxito.");
                    }
                    break;
                case 4:
                    System.out.println("Introduce el año inicial:");
                    int anyoInicialUsuario = sc.nextInt();
                    System.out.println("Introduce el año final:");
                    int anyoFinalUsuario = sc.nextInt();
                    boolean resultado4 = filtrarEntreAnyos(anyoInicialUsuario,anyoFinalUsuario);
                    if (resultado4) {
                        System.out.println("Fichero (nomfichero) escrito y guardado con éxito.");
                    }
                    break;
                case 5:

                    break;
                case 6:

                    break;
                case 7:

                    break;
                case 0:
                    System.out.println("Saliendo del programa...");
                    break;
            }
        } while (eleccion != 0);
    }
}