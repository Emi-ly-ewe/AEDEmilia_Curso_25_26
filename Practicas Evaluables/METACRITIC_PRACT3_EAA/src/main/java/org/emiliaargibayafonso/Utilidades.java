package org.emiliaargibayafonso;

import org.w3c.dom.*;
import org.xml.sax.*;
import javax.xml.parsers.*;
import java.io.*;
import java.util.*;

/// Clase de utilidades usada para reutilizar funciones con el fin de simplificar el código.
public class Utilidades {
    public static ArrayList<Videojuego> leerFicheroMetacritic() {
        ArrayList<Videojuego> contenidoFichero = new ArrayList<>();
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

        try {
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(new File("src/main/resources/metacritic.xml"));

            NodeList videojuegos = doc.getElementsByTagName("Elemento");
            for (int i = 0; i < videojuegos.getLength(); i++) {
                Node node = videojuegos.item(i);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element e = (Element) node;

                    String nombre = e.getElementsByTagName("Game").item(0).getTextContent();
                    int ranking = Integer.parseInt(e.getElementsByTagName("Ranking").item(0).getTextContent());
                    int metascore = Integer.parseInt(e.getElementsByTagName("Metascore").item(0).getTextContent());
                    String plataforma = e.getElementsByTagName("Platform").item(0).getTextContent();
                    String fecha = e.getElementsByTagName("ReleaseDate").item(0).getTextContent();

                    contenidoFichero.add(new Videojuego(nombre, ranking, metascore, plataforma, fecha));
                }
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        System.out.println("Fichero leido con éxito. Total de juegos: " + contenidoFichero.size());
        return contenidoFichero;
    }

}
