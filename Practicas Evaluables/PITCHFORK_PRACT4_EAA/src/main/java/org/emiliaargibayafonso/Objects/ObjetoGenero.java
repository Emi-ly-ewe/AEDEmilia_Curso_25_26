package org.emiliaargibayafonso.Objects;

public class ObjetoGenero {
    private int IDReview;
    private String nombreGenero;

    public ObjetoGenero(int id, String genero) {
        this.IDReview = id;
        this.nombreGenero = genero;
    }

    public int getIDReview() {return IDReview;}
    public void setIDReview(int IDReview) {this.IDReview = IDReview;}
    public String getNombreGenero() {return nombreGenero;}
    public void setNombreGenero(String nombreGenero) {this.nombreGenero = nombreGenero;}

    @Override
    public String toString() {
        return "ArtistObject{" +
                "IDReview=" + IDReview +
                ", Artista='" + nombreGenero + '\'' +
                '}';
    }
}