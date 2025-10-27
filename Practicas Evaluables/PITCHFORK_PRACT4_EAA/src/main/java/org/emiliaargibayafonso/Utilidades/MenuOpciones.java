package org.emiliaargibayafonso.Utilidades;

public class MenuOpciones {
    /// VARIABLES
    private final String[] options;

    /// CONSTRUCTORES
    public MenuOpciones(String[] text) {
        this.options = text;
    }
    public MenuOpciones() {
        this.options = new String[0];
    }

    /// MÉTODOS
    public void mostrarMenu() {
        System.out.println("----------------------");
        System.out.println("¿Que deseas hacer?");
        System.out.println("----------------------");
        for (String option : options) {
            System.out.println(option);
        }
        System.out.println("----------------------");
        System.out.println("Seleccione una opción:");
    }
}
