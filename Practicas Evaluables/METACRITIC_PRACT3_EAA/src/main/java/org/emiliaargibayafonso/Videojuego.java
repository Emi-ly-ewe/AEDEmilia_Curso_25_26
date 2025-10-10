package org.emiliaargibayafonso;

public class Videojuego {
    private String nombre;
    private int ranking;
    private int metascore;
    private String plataforma;
    private String fechaLanzamiento;

    public Videojuego(String nom, int rank, int score, String platform, String releaseDate) {
        this.nombre = nom;
        this.ranking = rank;
        this.metascore = score;
        this.plataforma = platform;
        this.fechaLanzamiento = releaseDate;
    }

    public Videojuego() {
        this.nombre = "";
        this.ranking = 0;
        this.metascore = 0;
        this.plataforma = "";
        this.fechaLanzamiento = "";
    }

    public String getNombre() {return nombre;}
    public void setNombre(String nombre) {this.nombre = nombre;}
    public int getRanking() {return ranking;}
    public void setRanking(int ranking) {this.ranking = ranking;}
    public int getMetascore() {return metascore;}
    public void setMetascore(int metascore) {this.metascore = metascore;}
    public String getPlataforma() {return plataforma;}
    public void setPlataforma(String plataforma) {this.plataforma = plataforma;}
    public String getFechaLanzamiento() {return fechaLanzamiento;}
    public void setFechaLanzamiento(String fechaLanzamiento) {this.fechaLanzamiento = fechaLanzamiento;}

    @Override
    public String toString() {
        return "Videojuego{" +
                ", nombre='" + nombre + '\'' +
                ", ranking=" + ranking +
                ", metascore=" + metascore +
                ", plataforma='" + plataforma + '\'' +
                "fechaLanzamiento='" + fechaLanzamiento + '\'' +
                '}';
    }
}