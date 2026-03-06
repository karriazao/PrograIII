/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

public class Jornadas {

    private int jor_codigo;
    private String jor_nombre;

    public Jornadas() {
    }

    public Jornadas(int jor_codigo, String jor_nombre) {
        this.jor_codigo = jor_codigo;
        this.jor_nombre = jor_nombre;
    }

    public int getJor_codigo() {
        return jor_codigo;
    }

    public void setJor_codigo(int jor_codigo) {
        this.jor_codigo = jor_codigo;
    }

    public String getJor_nombre() {
        return jor_nombre;
    }

    public void setJor_nombre(String jor_nombre) {
        this.jor_nombre = jor_nombre;
    }

    @Override
    public String toString() {
        return "Jornada{" +
                "jor_codigo=" + jor_codigo +
                ", jor_nombre=" + jor_nombre +
                '}';
    }
}