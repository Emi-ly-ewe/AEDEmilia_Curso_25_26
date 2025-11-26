package org.emiliaargibayafonso.Modelo;

public class Juego {
    /// VARIABLES
    private int id;
    private String titulo;
    private String desarrollador;
    private String editorial;
    private String publicacion_EU;
    private String publicacion_JPN;
    private String publicacion_NA;

    /// CONSTRUCTORES
    public Juego(int id, String titulo, String desarrollador, String editorial, String publicacion_EU, String publicacion_JPN, String publicacion_NA) {
        this.id = id;
        this.titulo = titulo;
        this.desarrollador = desarrollador;
        this.editorial = editorial;
        this.publicacion_EU = publicacion_EU;
        this.publicacion_JPN = publicacion_JPN;
        this.publicacion_NA = publicacion_NA;
    }
    public Juego() {
        this.id = 0;
        this.titulo = "";
        this.desarrollador = "";
        this.editorial = "";
        this.publicacion_EU = null;
        this.publicacion_JPN = null;
        this.publicacion_NA = null;
    }

    /// GETTERS & SETTERS
    public int getId() {return id;}
    public void setId(int id) {this.id = id;}
    public String getTitulo() {return titulo;}
    public void setTitulo(String titulo) {this.titulo = titulo;}
    public String getDesarrollador() {return desarrollador;}
    public void setDesarrollador(String desarrollador) {this.desarrollador = desarrollador;}
    public String getEditorial() {return editorial;}
    public void setEditorial(String editorial) {this.editorial = editorial;}
    public String getPublicacion_EU() {return publicacion_EU;}
    public void setPublicacion_EU(String publicacion_EU) {this.publicacion_EU = publicacion_EU;}
    public String getPublicacion_JPN() {return publicacion_JPN;}
    public void setPublicacion_JPN(String publicacion_JPN) {this.publicacion_JPN = publicacion_JPN;}
    public String getPublicacion_NA() {return publicacion_NA;}
    public void setPublicacion_NA(String publicacion_NA) {this.publicacion_NA = publicacion_NA;}

    @Override
    public String toString() {
        return "Juego{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", desarrollador='" + desarrollador + '\'' +
                ", editorial='" + editorial + '\'' +
                ", publicacion_EU=" + publicacion_EU +
                ", publicacion_JPN=" + publicacion_JPN +
                ", publicacion_NA=" + publicacion_NA +
                '}';
    }
}