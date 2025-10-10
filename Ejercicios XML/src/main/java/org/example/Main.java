package org.example;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Musico> listaMusicos = null;

        Musico Musico1 = new Musico("The Wonder Years", 2005,"Punk-Pop", "Dan Campbell", "Hopeless Records", "USA");
        Musico Musico2 = new Musico("La Polla Records", 1980, "Punk", "Evaristo Páramos", "Maldito Records", "ESP");
        Musico Musico3 = new Musico("Phoebe Bridgers", 2012, "Indie-folk", "Phoebe Bridgers", "Tiny Matador", "USA");

        listaMusicos = new ArrayList<Musico>();
        listaMusicos.add(Musico1);
        listaMusicos.add(Musico2);
        listaMusicos.add(Musico3);

        Utilidades metodo = new Utilidades();
        metodo.escribirXML(listaMusicos);
        metodo.leerFicheroXML();
    }
}