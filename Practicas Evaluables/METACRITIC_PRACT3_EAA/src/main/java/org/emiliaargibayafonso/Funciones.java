package org.emiliaargibayafonso;

import org.w3c.dom.*;
import org.xml.sax.*;
import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.*;
import javax.xml.transform.stream.*;
import java.io.*;
import java.time.LocalDate;
import java.util.*;
import static org.emiliaargibayafonso.Utilidades.*;

/// Clase que guarda las funciones principales de la actividad.
public class Funciones {
    private static final ArrayList<Videojuego> juegos =  leerFicheroMetacritic();

    public static void imprimirFicheroMetacritics() {
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
                    System.out.print(elemento.getElementsByTagName("ReleaseDate").item(0).getTextContent());
                    System.out.println();
                }
            }
        } catch (ParserConfigurationException | IOException | SAXException pce) {
            pce.printStackTrace();
        }
    }

//    public static void modificarFechaLanzamiento (ArrayList<Videojuego> juegos) {
//
//    }

    public static void sacarMejoresNota (int notaUsuario) {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.newDocument();

            Element videojuegos = doc.createElement("Videojuegos");
            doc.appendChild(videojuegos);

            for (Videojuego v : juegos) {

                if (v.getMetascore() > notaUsuario) {
                    Element juego = doc.createElement("Juego");

                    Element nombre = doc.createElement("Nombre");
                    nombre.setTextContent(v.getNombre());
                    juego.appendChild(nombre);

                    Element metascore = doc.createElement("Metascore");
                    metascore.setTextContent(String.valueOf(v.getMetascore()));
                    juego.appendChild(metascore);

                    Element plataforma = doc.createElement("Plataforma");
                    plataforma.setTextContent(v.getPlataforma());
                    juego.appendChild(plataforma);

                    videojuegos.appendChild(juego);
                }
            }

            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File("src/main/resources/mejores.xml"));
            transformer.transform(source, result);

            System.out.println("Fichero 'mejores.xml' generado correctamente.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void filtrarEntreAnyos (int anyoInicio, int anyoFinal) {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.newDocument();

            Element videojuego = doc.createElement("Videojuegos");
            doc.appendChild(videojuego);

            for (Videojuego v : juegos) {
                LocalDate fecha = v.getFechaLanzamiento();
                if (fecha == null) continue;
                int anyoLanzamiento = fecha.getYear();

                if (anyoLanzamiento >= anyoInicio && anyoLanzamiento <= anyoFinal) {
                    Element juego = doc.createElement("Juego");

                    Element nombre = doc.createElement("Nombre");
                    nombre.setTextContent(v.getNombre());
                    juego.appendChild(nombre);

                    Element metascore = doc.createElement("Metascore");
                    metascore.setTextContent(String.valueOf(v.getMetascore()));
                    juego.appendChild(metascore);

                    Element plataforma = doc.createElement("Plataforma");
                    plataforma.setTextContent(v.getPlataforma());
                    juego.appendChild(plataforma);

                    videojuego.appendChild(juego);
                }
            }

            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File("src/main/resources/juegos"+anyoInicio+"_"+anyoFinal+".xml"));
            transformer.transform(source, result);

            System.out.println("Fichero 'juegos_"+anyoInicio+"_"+anyoFinal+".xml' generado correctamente.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void generarTopPlataforma(int limiteUsuario, String plataformaJuego) {
        try {
            ArrayList<Videojuego> juegosFiltrados = new ArrayList<>();
            for (Videojuego v : juegos) {
                if (v.getPlataforma() != null && v.getPlataforma().trim().equalsIgnoreCase(plataformaJuego.trim())) {
                    juegosFiltrados.add(v);
                }
            }

            //Establecer límite
            int limite = Math.min(limiteUsuario, juegosFiltrados.size());
            ArrayList<Videojuego> topN = new ArrayList<>(juegosFiltrados.subList(0, limite));

            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.newDocument();

            Element videojuego = doc.createElement("Videojuegos");
            doc.appendChild(videojuego);

            for (Videojuego v : topN) {
                Element juego = doc.createElement("Juego");

                Element nombre = doc.createElement("Nombre");
                nombre.setTextContent(v.getNombre());
                juego.appendChild(nombre);

                Element metascore = doc.createElement("Metascore");
                metascore.setTextContent(String.valueOf(v.getMetascore()));
                juego.appendChild(metascore);

                Element plataforma = doc.createElement("Plataforma");
                plataforma.setTextContent(v.getPlataforma());
                juego.appendChild(plataforma);

                Element fechaLanzamiento = doc.createElement("Plataforma");
                fechaLanzamiento.setTextContent(v.getFechaLanzamientoFormateada());
                juego.appendChild(fechaLanzamiento);

                videojuego.appendChild(juego);
            }

            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File("src/main/resources/top"+limiteUsuario+"_"+plataformaJuego+".xml"));
            transformer.transform(source, result);

            System.out.println("Fichero 'top"+limiteUsuario+"_"+plataformaJuego+".xml' generado correctamente con " + limite + " juegos.");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void generarFicheroPlataforma (String plataformaUsuario) {
        try {
            ArrayList<Videojuego> juegosFiltrados = new ArrayList<>();
            for (Videojuego v : juegos) {
                if (v.getPlataforma().equalsIgnoreCase(plataformaUsuario)) {
                    juegosFiltrados.add(v);
                }
            }

            File archivo = new File("src/main/resources/"+plataformaUsuario+".txt");
            FileWriter fw = new FileWriter(archivo);
            for (Videojuego v : juegosFiltrados) {
                fw.write(v.getNombre() + " – " + v.getMetascore() + "\n");
            }
            fw.close();

            System.out.println("Hay un total de " + juegosFiltrados.size() + " juegos de la plataforma " + plataformaUsuario);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
