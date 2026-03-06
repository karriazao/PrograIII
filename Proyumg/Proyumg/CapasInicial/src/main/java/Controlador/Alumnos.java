package Controlador;

public class Alumnos {

    private int alu_codigo;
    private String alu_nombre;
    private String alu_direccion;
    private String alu_estatus;

    public Alumnos() {
    }

    public Alumnos(int alu_codigo, String alu_nombre, String alu_direccion, String alu_estatus) {
        this.alu_codigo = alu_codigo;
        this.alu_nombre = alu_nombre;
        this.alu_direccion = alu_direccion;
        this.alu_estatus = alu_estatus;
    }

    public int getAlu_codigo() {
        return alu_codigo;
    }

    public void setAlu_codigo(int alu_codigo) {
        this.alu_codigo = alu_codigo;
    }

    public String getAlu_nombre() {
        return alu_nombre;
    }

    public void setAlu_nombre(String alu_nombre) {
        this.alu_nombre = alu_nombre;
    }

    public String getAlu_direccion() {
        return alu_direccion;
    }

    public void setAlu_direccion(String alu_direccion) {
        this.alu_direccion = alu_direccion;
    }

    public String getAlu_estatus() {
        return alu_estatus;
    }

    public void setAlu_estatus(String alu_estatus) {
        this.alu_estatus = alu_estatus;
    }
}