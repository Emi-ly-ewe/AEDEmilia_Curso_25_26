package org.example;

import java.util.Scanner;

public class Main {
    private static MenuOpciones menu;
    private static Utilidades utd = new Utilidades();
    private static final String[] opciones = {"1) Seleccionar partidos favoritos.",
            "2) Seleccionar partidos por país en el que se jugó.",
            "3) Seleccionar partidos ganados por equipo específico.",
            "4) Seleccionar partidos jugados en año específico.",
            "5) Seleccionar partidos ganados por palizón"};
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        menu = new MenuOpciones(opciones);
        menu.mostrarMenu();
        int eleccion = sc.nextInt();
        switch(eleccion) {
            case 1:

                break;
            case 2:
                utd.paisCSV();
                System.out.println("Fichero 'paisFiltro.csv' creado exitosamente.");
                break;
            case 3:
                utd.ganadoEquipoCSV();
                System.out.println("Fichero 'equipoFiltro.csv' creado exitosamente.");
                break;
            case 4:
                utd.partidosAnyoCSV();
                System.out.println("Fichero 'anyoFiltro.csv' creado exitosamente.");
                break;
            case 5:

                break;
        }
    }
}