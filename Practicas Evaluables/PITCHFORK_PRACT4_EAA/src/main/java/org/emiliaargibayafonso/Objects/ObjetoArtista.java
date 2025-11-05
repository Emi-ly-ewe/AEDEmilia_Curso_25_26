package org.emiliaargibayafonso.Objects;

public class ObjetoArtista {
    private int IDReview;
    private String nombreArtista;

    public ObjetoArtista(int id, String artista) {
        this.IDReview = id;
        this.nombreArtista = artista;
    }

    public int getIDReview() {return IDReview;}
    public void setIDReview(int IDReview) {this.IDReview = IDReview;}
    public String getNombreArtista() {return nombreArtista;}
    public void setNombreArtista(String nombreArtista) {this.nombreArtista = nombreArtista;}

    @Override
    public String toString() {
        return "ArtistObject{" +
                "IDReview=" + IDReview +
                ", Artista='" + nombreArtista + '\'' +
                '}';
    }
}