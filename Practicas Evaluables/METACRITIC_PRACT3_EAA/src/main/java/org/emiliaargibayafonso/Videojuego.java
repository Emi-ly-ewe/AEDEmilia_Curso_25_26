package org.emiliaargibayafonso;

import java.time.*;
import java.time.format.*;
import java.util.*;

/// Objeto creado a partir de los datos. En este se recoge la información en un objeto por cada registro.
public class Videojuego {
    private String nombre;
    private int ranking;
    private int metascore;
    private String plataforma;
    private LocalDate fechaLanzamiento;

    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("MMMM d, yyyy", Locale.ENGLISH);

    public Videojuego(String nom, int rank, int score, String platform, String releaseDate) {
        this.nombre = nom;
        this.ranking = rank;
        this.metascore = score;
        this.plataforma = platform;
        setFechaLanzamiento(releaseDate);
    }

    public Videojuego() {
        this.nombre = "";
        this.ranking = 0;
        this.metascore = 0;
        this.plataforma = "";
        this.fechaLanzamiento = null;
    }

    public String getNombre() {return nombre;}
    public void setNombre(String nombre) {this.nombre = nombre;}
    public int getRanking() {return ranking;}
    public void setRanking(int ranking) {this.ranking = ranking;}
    public int getMetascore() {return metascore;}
    public void setMetascore(int metascore) {this.metascore = metascore;}
    public String getPlataforma() {return plataforma;}
    public void setPlataforma(String plataforma) {this.plataforma = plataforma;}

    public LocalDate getFechaLanzamiento() { return fechaLanzamiento; }
    public void setFechaLanzamiento(String fechaLanzamiento) {
        if (fechaLanzamiento == null || fechaLanzamiento.isEmpty()) {
            this.fechaLanzamiento = null;
            return;
        }
        try {
            this.fechaLanzamiento = LocalDate.parse(fechaLanzamiento, FORMATTER);
        } catch (DateTimeParseException e) {
            System.out.println("Error al parsear la fecha: " + fechaLanzamiento);
            this.fechaLanzamiento = null;
        }
    }
    public void setFechaLanzamiento(LocalDate fechaLanzamiento) {
        this.fechaLanzamiento = fechaLanzamiento;
    }
    public String getFechaLanzamientoFormateada() {
        return fechaLanzamiento != null ? fechaLanzamiento.format(FORMATTER) : "";
    }

    @Override
    public String toString() {
        return "Videojuego{" +
                ", nombre='" + nombre + '\'' +
                ", ranking=" + ranking +
                ", metascore=" + metascore +
                ", plataforma='" + plataforma + '\'' +
                "fechaLanzamiento='" + getFechaLanzamientoFormateada() + '\'' +
                '}';
    }
}