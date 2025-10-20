package org.emiliaargibayafonso;
import static org.emiliaargibayafonso.Administrador.*;
import static org.emiliaargibayafonso.OperacionesCRUD.*;
import java.util.*;

public class Main {
    private static final String[] opciones = {"1) Insertar persona en DB.",
                                 "2) Insertar sobre en DB.",
                                 "3) Obtener todos los sobres de la DB.",
                                 "4) Obtener los sobres de 'X' ciclo."};
    private static final MenuOpciones menu = new MenuOpciones(opciones);
    public static Scanner sc = new Scanner (System.in);

    public static void main(String[] args) {
        crearTablas();
        int eleccion;
        do {
            menu.mostrarMenu();
            eleccion = sc.nextInt();
            try {
                administrarEleccionUsuario(eleccion);
            } catch (InputMismatchException e) {
                System.out.println("INTRODUCE UN NÚMERO. NO SE ADMITEN OTROS CARACTERES.");
            }
        } while(eleccion != 0);
    }
}