package org.example;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Utilidades {
    /// VARIABLES
    private Scanner sc = new Scanner(System.in);
    private String filtro;
    /// MÉTODOS DE UTILIDAD
    //Función que guarda en un fichero csv los partidos favoritos del usuario que este elige por ID.
    public void miFavoritosCSV() {

    }

    //Función que guarda en fichero csv los partidos jugados en país especificado.
    public void paisCSV() {
        System.out.println("Introduce el pais para el filtrado:");
        filtro = sc.nextLine(); //Se pide al usuario el filtrado

        ArrayList<Partido> listaPartidos = leerFichero();
        FileWriter fw = null;
        BufferedWriter bw = null;

        try {
            fw = new FileWriter("src/main/resources/paisFiltro.csv");
            bw = new BufferedWriter(fw);
            for(Partido p : listaPartidos){
                if (filtro.equals(p.getPais())) {
                    //Se escriben partidos en fichero .csv
                    bw.write(p.toCSV());
                    bw.newLine();
                }
            }
        } catch (IOException e) {
            System.out.println("ERROR AL ESCRIBIR FICHERO DE PAIS => " + e.getMessage());
        } finally {
            try {
                if (bw != null) { bw.close(); }
                if (fw != null) { fw.close(); }
            } catch (IOException e) {
                System.out.println("ERROR AL CERRAR EL WRITER => "+e.getMessage());
            }
        }
    }

    //Función que guarda en fichero csv los partidos ganados por un pais/equipo especificado.
    public void ganadoEquipoCSV() {
        System.out.println("Introduce el equipo para el filtrado:");
        filtro = sc.nextLine(); //Se pide al usuario el filtrado

        ArrayList<Partido> listaPartidos = leerFichero();
        FileWriter fw = null;
        BufferedWriter bw = null;

        try {
            fw = new FileWriter("src/main/resources/equipoFiltro.csv");
            bw = new BufferedWriter(fw);
            for(Partido p : listaPartidos){
                if (filtro.equals(p.getEquipoLocal())) {
                    //Se escriben partidos en fichero .csv
                    bw.write(p.toCSV());
                    bw.newLine();
                }
            }
        } catch (IOException e) {
            System.out.println("ERROR AL ESCRIBIR FICHERO DE EQUIPO => " + e.getMessage());
        } finally {
            try {
                if (bw != null) { bw.close(); }
                if (fw != null) { fw.close(); }
            } catch (IOException e) {
                System.out.println("ERROR AL CERRAR EL WRITER => "+e.getMessage());
            }
        }
    }

    //Función que guarda los partidos ganados en año especificado.
    public void partidosAnyoCSV() {
        System.out.println("Introduce el anyo para el filtrado:");
        filtro = sc.nextLine(); //Se pide al usuario el filtrado

        ArrayList<Partido> listaPartidos = leerFichero();
        FileWriter fw = null;
        BufferedWriter bw = null;

        try {
            fw = new FileWriter("src/main/resources/anyoFiltro.csv");
            bw = new BufferedWriter(fw);
            for(Partido p : listaPartidos){
                if (filtro.equals(p.getEquipoLocal())) { //HAY QUE MIRAR LA NOTA DE LA FECHA
                    //Se escriben partidos en fichero .csv
                    bw.write(p.toCSV());
                    bw.newLine();
                }
            }
        } catch (IOException e) {
            System.out.println("ERROR AL ESCRIBIR FICHERO DE EQUIPO => " + e.getMessage());
        } finally {
            try {
                if (bw != null) { bw.close(); }
                if (fw != null) { fw.close(); }
            } catch (IOException e) {
                System.out.println("ERROR AL CERRAR EL WRITER => "+e.getMessage());
            }
        }

        /// Nota:
        /*
            NOTA SOBRE COMO MANEJAR LAS FECHAS EN JAVA:
            String fechaString = "15/04/1989"

            DateTimeFormatter f = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            LocalDate fecha = LocalDate.parse(fechaString, f);

            sout("Fecha leida = "+fecha.toString());
            sout("Anyo fecha = "+fecha.getYear());
            sout("Mes fecha = "+fecha.getMonthValue());
            sout("Día fecha = "+fecha.getDayOfMonth);
        */
    }

    //Función que muestra por consola los partidos ganados por paliza.
    public void palizonConsola() {
        // ¿Hacer comparación: golesLocal - golesVisitante = diferenciaGoles --> if (diferenciaGoles)?
    }

    public ArrayList<Partido> leerFichero() {
        ArrayList<Partido> listaPartidos = new ArrayList<>();
        int idCounter = 1; //Los partidos se cuentan desde el 1

        try {
            FileReader fr = new FileReader("src/main/resources/fifa.csv");
            BufferedReader br = new BufferedReader(fr);
            br.readLine(); //Se descarta la cabecera
            String linea;
            while ((linea = br.readLine()) != null) {
                if (!linea.trim().isEmpty()) {
                    String[] datosPartido = linea.split(",");
                    String local = datosPartido[1].trim();
                    int golLocal = Integer.parseInt(datosPartido[9].trim());
                    String visitante = datosPartido[2].trim();
                    int golVisitante = Integer.parseInt(datosPartido[10].trim());
                    String fechaPartido = datosPartido[0].trim();
                    String torneo = datosPartido[11].trim();
                    String pais = datosPartido[13].trim();

                    Partido p = new Partido(idCounter, local, golLocal, visitante, golVisitante, fechaPartido, torneo, pais);

                    listaPartidos.add(p);

                    idCounter++; //Se aumenta el id para el siguiente partido que se guarde
                }
            }
        } catch (IOException e) {
            System.out.println("ERROR --> " + e.getMessage());
        }
        return listaPartidos;
    }
}
