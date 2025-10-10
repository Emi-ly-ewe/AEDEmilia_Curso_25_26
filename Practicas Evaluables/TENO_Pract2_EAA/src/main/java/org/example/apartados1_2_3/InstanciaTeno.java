package org.example.apartados1_2_3;
import java.io.Serializable;

public class InstanciaTeno  implements Serializable {
    /// VARIABLES
    private String fechaRegisto;
    private int cantidadCoches;
    private int cantidadPersonas;
    /// CONSTRUCTORES
    public InstanciaTeno(String fecha, int coches, int personas) {
        this.fechaRegisto = fecha;
        this.cantidadCoches = coches;
        this.cantidadPersonas = personas;
    }
    public InstanciaTeno() {
        this.fechaRegisto = "";
        this.cantidadCoches = 0;
        this.cantidadPersonas = 0;
    }
    /// GETTER & SETTER
    public String getFechaRegisto() {return fechaRegisto;}
    public void setFechaRegisto(String fechaRegisto) {this.fechaRegisto = fechaRegisto;}

    public int getCantidadCoches() {return cantidadCoches;}
    public void setCantidadCoches(int cantidadCoches) {this.cantidadCoches = cantidadCoches;}

    public int getCantidadPersonas() {return cantidadPersonas;}
    public void setCantidadPersonas(int cantidadPersonas) {this.cantidadPersonas = cantidadPersonas;}
    /// MÉTODOS DEL OBJETO
    @Override
    public String toString() {
        return "InstanciaTeno{" +
                "fechaRegisto='" + fechaRegisto + '\'' +
                ", cantidadCoches=" + cantidadCoches +
                ", cantidadPersonas=" + cantidadPersonas +
                '}';
    }
}

