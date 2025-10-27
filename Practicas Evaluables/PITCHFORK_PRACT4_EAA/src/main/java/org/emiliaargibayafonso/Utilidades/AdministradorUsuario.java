package org.emiliaargibayafonso.Utilidades;

import static org.emiliaargibayafonso.Main.sc;

public class AdministradorUsuario {
    public static void administrarEleccionUsuario(int eleccion) {
        switch (eleccion) {
            case 1:
                sc.nextLine(); //Limpiar buffer
                System.out.println("Elige el filtro de 'género de música' (Introducir nombre):\n1.Rock\n2.Metal");
                String generoUsuario=sc.nextLine().toLowerCase();

                break;
            case 2:
                sc.nextLine(); //Limpiar buffer
                System.out.println("Escribe el filtro de 'género de música':");
                String a = sc.nextLine();
                break;
            case 3:
                sc.nextLine(); //Limpiar buffer
                System.out.println("Escribe el filtro de 'género de música':");
                String b = sc.nextLine();
                break;
            case 4:
                sc.nextLine(); //Limpiar buffer
                System.out.println("Escribe el filtro de 'género de música':");
                String c = sc.nextLine();
                break;
            case 5:
                sc.nextLine(); //Limpiar buffer
                System.out.println("Escribe el filtro de 'género de música':");
                String d = sc.nextLine();
                break;
            case 0:
                System.out.println("Saliendo del programa...");
                break;
            default:
                System.out.println("Introduce un número del 0 al 5.");
                break;
        }
    }
}
