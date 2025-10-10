package org.example.apartados4_5_6;

public class LugarTenerife {
    /// VARIABLES
    private String lugarTenerife;
    private int numeroGente;
    private float dineroRecaudado;
    /// CONSTRUCTORES
    public LugarTenerife(String lugarIsla, int gente, float dinero) {
        this.lugarTenerife = lugarIsla;
        this.numeroGente = gente;
        this.dineroRecaudado = dinero;
    }
    public LugarTenerife() {
        this.lugarTenerife = "";
        this.numeroGente = 0;
        this.dineroRecaudado = 0;
    }
    ///GETTER & SETTER
    public String getLugarTenerife() {return lugarTenerife;}
    public void setLugarTenerife(String lugarTenerife) {this.lugarTenerife = lugarTenerife;}

    public int getNumeroGente() {return numeroGente;}
    public void setNumeroGente(int numeroGente) {this.numeroGente = numeroGente;}

    public float getDineroRecaudado() {return dineroRecaudado;}
    public void setDineroRecaudado(float dineroRecaudado) {this.dineroRecaudado = dineroRecaudado;}
    ///MÉTODOS DEL OBJETO
    @Override
    public String toString() {
        return "LugarTenerife{" +
                "dineroRecaudado=" + dineroRecaudado +
                ", lugarTenerife='" + lugarTenerife + '\'' +
                ", numeroGente=" + numeroGente +
                '}';
    }
}
