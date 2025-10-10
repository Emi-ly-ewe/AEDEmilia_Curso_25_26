package org.example;

/// EMILIA ARGIBAY AFONSO 2º DAM B
public class Partido {
    /// VARIABLES
    private int id;
    private String equipoLocal;
    private int golesLocal;
    private String equipoVisitante;
    private int golesVisitante;
    private String fechaPartido; //FORMATO: yyyy-MM-DD
    private String torneo;
    private String pais;

    /// CONSTRUCTORES
    public Partido(int ID, String local, int scoreLocal, String away, int scoreAway, String date, String tournament, String country) {
            this.id = ID;
            this.equipoLocal = local;
            this.equipoVisitante = away;
            this.golesLocal = scoreLocal;
            this.golesVisitante = scoreAway;
            this.fechaPartido = date;
            this.torneo = tournament;
            this.pais = country;
        }
    public Partido() {
            this.id = 0;
            this.equipoLocal = null;
            this.equipoVisitante = null;
            this.golesLocal = 0;
            this.golesVisitante = 0;
            this.fechaPartido = null;
            this.torneo = null;
            this.pais = null;
        }

    /// GETTER & SETTER
    //ID
    public int getId() {return id;}
    public void setId(int id) {this.id = id;}

    //EquipoLocal
    public String getEquipoLocal() {return equipoLocal;}
    public void setEquipoLocal(String equipoLocal) {this.equipoLocal = equipoLocal;}
    //GolesLocal
    public int getGolesLocal() {return golesLocal;}
    public void setGolesLocal(int golesLocal) {this.golesLocal = golesLocal;}

    //EquipoVisitante
    public String getEquipoVisitante() {return equipoVisitante;}
    public void setEquipoVisitante(String equipoVisitante) {this.equipoVisitante = equipoVisitante;}
    //GolesVisitante
    public int getGolesVisitante() {return golesVisitante;}
    public void setGolesVisitante(int golesVisitante) {this.golesVisitante = golesVisitante;}

    //FechaPartido
    public String getFechaPartido() {return fechaPartido;}
    public void setFechaPartido(String fechaPartido) {this.fechaPartido = fechaPartido;}
    //Torneo
    public String getTorneo() {return torneo;}
    public void setTorneo(String torneo) {this.torneo = torneo;}
    //Pais
    public String getPais() {return pais;}
    public void setPais(String pais) {this.pais = pais;}

    /// MÉTODOS DE LA CLASE
    public String toCSV(){
        String[] datosPartido = {
            String.valueOf(getId()),
            getEquipoLocal(),
            String.valueOf(getGolesLocal()),
            getEquipoVisitante(),
            String.valueOf(getGolesVisitante()),
            getFechaPartido(),
            getTorneo(),
            getPais()
        };
        return String.join(";",datosPartido);
    } //Se crea un array de String para guardar todos los datos del partido para después con la función "join()" separarlo por ";" según el array.
}