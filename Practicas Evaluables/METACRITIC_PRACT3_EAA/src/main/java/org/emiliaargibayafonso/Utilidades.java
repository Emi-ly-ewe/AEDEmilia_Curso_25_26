package org.emiliaargibayafonso;

import org.w3c.dom.*;

import java.util.*;

public class Utilidades {
    public void leerFicheroXML() {

    }

    public static ArrayList<Element> escribirFicheroXML(Document documento, ArrayList<Videojuego> listaJuegos) {
        ArrayList<Element> listaElementos = new ArrayList<>();

        for (Videojuego juego : listaJuegos) {
            Element nodoVideojuego = documento.createElement("VideoJuego");

            Element nombre = documento.createElement("Nombre");
            nombre.setTextContent(juego.getNombre());
            nodoVideojuego.appendChild(nombre);

            Element ranking = documento.createElement("Ranking");
            ranking.setTextContent(String.valueOf(juego.getRanking()));
            nodoVideojuego.appendChild(ranking);

            Element metascore = documento.createElement("MetaScore");
            metascore.setTextContent(String.valueOf(juego.getRanking()));
            nodoVideojuego.appendChild(metascore);

            Element plataforma = documento.createElement("Plataforma");
            plataforma.setTextContent(juego.getPlataforma());
            nodoVideojuego.appendChild(plataforma);

            Element fechaLantamiento = documento.createElement("FechaLanzamiento");
            fechaLantamiento.setTextContent(juego.getFechaLanzamiento());
            nodoVideojuego.appendChild(fechaLantamiento);

            listaElementos.add(nodoVideojuego);
        }
        return listaElementos;
    }
}
