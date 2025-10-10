package org.example.apartados4_5_6;

import java.io.*;

public class GestorAleatorio {
    private static final File ficheroTenerife = new File("src/main/resources/lugaresTenerife.dat");
    private static final int maxNombre = 20; //+2 por UTF
    private static int tamanyoLinea = 48; // sospechoso >:( supuestamente eran 30, pero hay 18 bits extra
    //sus writeutf

    public static boolean guardarLugar (LugarTenerife lT) {
        boolean guardadoLugar = false;

        try (RandomAccessFile ficheroAleatorio = new RandomAccessFile(ficheroTenerife, "rw")) {
            ficheroAleatorio.seek(ficheroAleatorio.length());

            StringBuilder nombreLugarTenerife = new StringBuilder(lT.getLugarTenerife());
            nombreLugarTenerife.setLength(maxNombre);
            ficheroAleatorio.writeUTF(nombreLugarTenerife.toString());
            ficheroAleatorio.writeInt(lT.getNumeroGente());
            ficheroAleatorio.writeFloat(lT.getDineroRecaudado());

            guardadoLugar = true;
        } catch (IOException e) {
            System.out.println("ERROR: No se pudo guardar los lugares de Tenerife. --> "+e.getMessage());
        }
        return guardadoLugar;
    }

    public static void verLugar (int posicion){
        try (RandomAccessFile ficheroAleatorio = new RandomAccessFile(ficheroTenerife, "rw")) {
            ficheroAleatorio.seek(tamanyoLinea *(posicion-1));

            String lugar = ficheroAleatorio.readUTF();
            int gente = ficheroAleatorio.readInt();
            float dinero = ficheroAleatorio.readFloat();

                System.out.println("REGISTRO PEDIDO --> Lugar: "+lugar+" // Número de gente: "+gente+" // Dinero Recaudado: "+dinero);
        } catch (IOException e) {
            System.out.println("ERROR: No se pudo leer los lugares de Tenerife. --> "+e.getMessage());
        }
    }

    public static void verTodosLugares () {
        try (RandomAccessFile ficheroAleatorio = new RandomAccessFile(ficheroTenerife, "rw")) {
            ficheroAleatorio.seek(0);

            for (int i=0; i<(ficheroAleatorio.length()/tamanyoLinea); i++) {

                String lugar = ficheroAleatorio.readUTF();
                int gente = ficheroAleatorio.readInt();
                float dinero = ficheroAleatorio.readFloat();

                System.out.println(i+") LUGAR: "+lugar+" // NÚMERO DE GENTE: "+gente+" // DINERO RECAUDADO: "+dinero);
            }
        } catch (IOException e) {
            System.out.println("ERROR: No se pudo leer los lugares de Tenerife. --> "+e.getMessage());
        }
    }

    public static boolean modificarLugar(int posicion, LugarTenerife lT) {
        return false;
    } //Sin hacer por falta de tiempo
}
