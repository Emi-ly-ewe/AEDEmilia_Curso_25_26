package org.emiliaargibayafonso.Objects;
import java.time.LocalDate;

public class ObjetoReview {
    private int IDReview;
    private String tituloCancion;
    private String nombreArtista;
    private double puntuacionCancion;
    private int rankingMejorNuevaMusica;
    private LocalDate fechaPublicacion;

    public ObjetoReview(int id, String titulo, String artista, double puntuacion, int ranking, LocalDate fecha) {
        this.IDReview = id;
        this.tituloCancion = titulo;
        this.nombreArtista = artista;
        this.puntuacionCancion = puntuacion;
        this.rankingMejorNuevaMusica = ranking;
        this.fechaPublicacion = fecha;
    }

    public int getIDReview() {return IDReview;}
    public void setIDReview(int IDReview) {this.IDReview = IDReview;}
    public String getTituloCancion() {return tituloCancion;}
    public void setTituloCancion(String tituloCancion) {this.tituloCancion = tituloCancion;}
    public String getNombreArtista() {return nombreArtista;}
    public void setNombreArtista(String nombreArtista) {this.nombreArtista = nombreArtista;}
    public double getPuntuacionCancion() {return puntuacionCancion;}
    public void setPuntuacionCancion(double puntuacionCancion) {this.puntuacionCancion = puntuacionCancion;}
    public int getRankingMejorNuevaMusica() {return rankingMejorNuevaMusica;}
    public void setRankingMejorNuevaMusica(int rankingMejorNuevaMusica) {this.rankingMejorNuevaMusica = rankingMejorNuevaMusica;}
    public LocalDate getFechaPublicacion() {return fechaPublicacion;}
    public void setFechaPublicacion(LocalDate fechaPublicacion) {this.fechaPublicacion = fechaPublicacion;}

    @Override
    public String toString() {
        return "ReviewObject{" +
                "IDReview=" + IDReview +
                ", tituloCancion='" + tituloCancion + '\'' +
                ", nombreArtista='" + nombreArtista + '\'' +
                ", puntuacionCancion=" + puntuacionCancion +
                ", rankingMejorNuevaMusica=" + rankingMejorNuevaMusica +
                ", fechaPublicacion=" + fechaPublicacion +
                '}';
    }
}