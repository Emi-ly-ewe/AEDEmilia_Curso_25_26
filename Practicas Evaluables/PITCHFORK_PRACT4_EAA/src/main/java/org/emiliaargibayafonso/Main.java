package org.emiliaargibayafonso;

import static org.emiliaargibayafonso.Utilidades.AdministradorUsuario.*;
import org.emiliaargibayafonso.Utilidades.MenuOpciones;
import java.util.Scanner;

public class Main {
    private static final String[] opciones = {"1) Devolver nombre de disco, artista, nota y fecha de review por género.",
            "2) Devolver toda la información de los artistas que hayan sido 'Best New Music'.",
            "3) Devolver toda la información de los discos con puntuación menor a la media.",
            "4) Devolver cuantos discos hay por cada artista junto a su mayor y menor nota.",
            "5) Devolver los discos sacados en '1999' y, 'enero' y 'febrero'."};
    private static final MenuOpciones menu = new MenuOpciones(opciones);
    public static final Scanner sc = new Scanner(System.in);

    static void main() {
        menu.mostrarMenu();
        int eleccion = sc.nextInt();
        administrarEleccionUsuario(eleccion);
    }
}
