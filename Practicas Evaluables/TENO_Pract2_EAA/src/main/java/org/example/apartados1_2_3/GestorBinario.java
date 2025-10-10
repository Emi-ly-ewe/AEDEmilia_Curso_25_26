package org.example.apartados1_2_3;

import java.io.*;
import java.util.ArrayList;

public class GestorBinario {
    /// VARIABLES
    private static FileReader fr;
    private static BufferedReader br;
    /// MÉTODOS DE LA CLASE
    public static ArrayList<InstanciaTeno> leerFichero (File fichero) {
        ArrayList<InstanciaTeno> listaRegistros = new ArrayList<>();

        try {
            fr = new FileReader(fichero); br = new BufferedReader(fr);
            br.readLine(); //Se quita la cabecera
            String linea;
            while  ((linea = br.readLine()) != null) {
                if (!linea.trim().isEmpty()) {
                    String[] datosRegistro = linea.split(",");
                    String fechaRegistro = datosRegistro[0].trim();
                    int cantidadCoches = Integer.parseInt(datosRegistro[1].trim());
                    int cantidadPersonas = Integer.parseInt(datosRegistro[2].trim());

                    InstanciaTeno teno = new InstanciaTeno (fechaRegistro, cantidadCoches, cantidadPersonas);
                    listaRegistros.add(teno);
                }
            }
        } catch (IOException e) {
            System.out.println("ERROR: No se pudo leer el fichero. --> "+e.getMessage());
        } finally {
            try {
                if (br != null) {br.close();} if (fr != null) {fr.close();}
            } catch (IOException e) {
                System.out.println("ERROR: No se pudo cerrar el lector. --> "+e.getMessage());
            }
        }
        return listaRegistros;
    }
    //Lee fichero csv y devuelve arraylist del objeto Instancia Teno.

    public static boolean hacerCopiaSeguridad (ArrayList<InstanciaTeno> listaRegistros) {
        boolean copiaGuardada = false;
        try (ObjectOutputStream oos = new ObjectOutputStream
            (new FileOutputStream("src/main/resources/copiaSeguridadTeno.dat"))){
            oos.writeObject(listaRegistros);
            System.out.println("Copia de Seguridad realizada con éxito en 'copiaSeguridadTeno.dat'");
            copiaGuardada = true;
        } catch (IOException e) {
            System.out.println("ERROR: No se pudo realizar la copia de seguridad. --> "+e.getMessage());
        }
        return copiaGuardada;
    }
    //Guarda fichero csv binario TenoCars.dat (contenido de ArrayList "lista")
    //Devuelve true si ha do bien la copia de seguridad, false al contrario.
    /// Nota: Utilizar clases de escritura binaria mediante objetos. (ObjectInputStream --- Object OutputStream)
}
/// NOTA: FORMATO PARA FECHA --> 'yyyy-MM-dd'T'HH:mm:ss'