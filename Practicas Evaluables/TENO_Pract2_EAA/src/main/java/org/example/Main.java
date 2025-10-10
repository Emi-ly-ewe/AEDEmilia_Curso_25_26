package org.example;
import org.example.apartados1_2_3.*;
import org.example.apartados4_5_6.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

/// EMILIA ARGIBAY AFONSO 2º DAM B
public class Main {
    private static MenuOpciones menu;
    private static final String[] opciones = {
            "1) Leer fichero 'Teno'.",
            "2) Hacer copia de seguridad (Teno Cars.dat). (REQUIERE LEER FICHERO 'Teno' PRIMERO)",
            "3) Guardar lugar de Tenerife.",
            "4) Ver Lugares de Tenerife por ID. (REQUIERE CREAR LUGARES PRIMERO)",
            "5) Ver todos los lugares de Tenerife. (REQUIERE CREAR LUGARES PRIMERO)",
            "6) Modificar lugar por ID (REQUIERE CREAR LUGARES PRIMERO) --- Sin utilidad"};
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        File fichero = new File("src/main/resources/afluencia-de-acceso-en-vehiculos-a-punta-de-teno-por-horas-del-ano-2025..csv");
        int eleccion;

        do {
            menu = new MenuOpciones(opciones);
            menu.mostrarMenu();
            eleccion = sc.nextInt();

            ArrayList<InstanciaTeno> listaTeno = new ArrayList<>();
            switch (eleccion) {
                case 1: //Apartado 2.1
                    listaTeno = GestorBinario.leerFichero(fichero);
                    System.out.println("\nFichero guardado en ArrayList.\n");
                    break;

                case 2: //Apartado 2.2
                    boolean copiaHecha = GestorBinario.hacerCopiaSeguridad(listaTeno);
                    System.out.println("\n¿La copia de seguridad ha sido guardada con éxito?\n"+copiaHecha+"\n");
                    break;

                case 3: //Apartado 6.1
                    System.out.println("Introduce lugar de Tenerife:");
                    sc.nextLine(); // Consumir salto de línea pendiente
                    String lugar = sc.nextLine();
                    System.out.println("Introduce el número de gente:");
                    int gente = sc.nextInt();
                    System.out.println("Introduce el dinero recaudado: (Escribir con coma, no punto)");
                    float dinero = sc.nextFloat();

                    LugarTenerife lT = new LugarTenerife(lugar, gente, dinero);
                    boolean lugarGuardado = GestorAleatorio.guardarLugar(lT);
                    System.out.println("\n¿El registro se ha sido guardado con éxito?\n"+lugarGuardado+"\n");
                    break;

                case 4: //Apartado 6.2
                    System.out.println("Introduce la posición:");
                    int pos = sc.nextInt();
                    GestorAleatorio.verLugar(pos);
                    break;

                case 5: //Apartado 6.3
                    GestorAleatorio.verTodosLugares();
                    break;
                case 0:
                    System.out.println("Saliendo del programa.");
                    break;
            }
        } while (eleccion != 0);
    }
}