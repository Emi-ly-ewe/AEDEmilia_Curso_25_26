package org.emiliaargibayafonso;

import org.w3c.dom.*;
import org.xml.sax.*;
import javax.xml.parsers.*;
import java.io.*;
import java.util.*;

/// Clase de utilidades usada para reutilizar funciones con el fin de simplificar el código.
public class Utilidades {
    public static void leerFicheroXML() {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        Document documento = null;

        try {
            DocumentBuilder builder = factory.newDocumentBuilder();

            documento = builder.parse(new File("src/main/resources/metacritic.xml"));

            NodeList videojuegos = documento.getElementsByTagName("Elemento");
            for (int i = 0; i < videojuegos.getLength(); i++) {
                Node juego = videojuegos.item(i);

                if(juego.getNodeType() == Node.ELEMENT_NODE) {
                    Element elemento = (Element) juego;

                    System.out.print(elemento.getElementsByTagName("Game").item(0).getTextContent());
                    System.out.print(" // ");
                    System.out.print(elemento.getElementsByTagName("Ranking").item(0).getTextContent());
                    System.out.print(" // ");
                    System.out.print(elemento.getElementsByTagName("Metascore").item(0).getTextContent());
                    System.out.print(" // ");
                    System.out.print(elemento.getElementsByTagName("Platform").item(0).getTextContent());
                    System.out.print(" // ");
                    System.out.print(elemento.getAttribute("ReleaseDate"));
                    System.out.println();
                }
            }
        } catch (ParserConfigurationException | IOException | SAXException pce) {
            pce.printStackTrace();
        }
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

    public static void verificarCreacionFicheros (boolean resultadoProceso, String nomFichero) {
        if (resultadoProceso) {
            System.out.println("Fichero '"+nomFichero+"' se ha guardado correctamente.");
        } else {
            System.out.println("Fichero '"+nomFichero+"' no se ha guardado correctamente.");
        }
    }
}
