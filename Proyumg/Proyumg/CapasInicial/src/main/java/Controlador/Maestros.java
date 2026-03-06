package Controlador;

public class Maestros {

    private int mae_codigo;
    private String mae_nombre;
    private String mae_direccion;
    private String mae_estatus;

    public Maestros() {
    }

    public Maestros(int mae_codigo, String mae_nombre, String mae_direccion, String mae_estatus) {
        this.mae_codigo = mae_codigo;
        this.mae_nombre = mae_nombre;
        this.mae_direccion = mae_direccion;
        this.mae_estatus = mae_estatus;
    }

    public int getMae_codigo() {
        return mae_codigo;
    }

    public void setMae_codigo(int mae_codigo) {
        this.mae_codigo = mae_codigo;
    }

    public String getMae_nombre() {
        return mae_nombre;
    }

    public void setMae_nombre(String mae_nombre) {
        this.mae_nombre = mae_nombre;
    }

    public String getMae_direccion() {
        return mae_direccion;
    }

    public void setMae_direccion(String mae_direccion) {
        this.mae_direccion = mae_direccion;
    }

    public String getMae_estatus() {
        return mae_estatus;
    }

    public void setMae_estatus(String mae_estatus) {
        this.mae_estatus = mae_estatus;
    }

    @Override
    public String toString() {
        return "Maestro{" +
                "mae_codigo=" + mae_codigo +
                ", mae_nombre=" + mae_nombre +
                ", mae_direccion=" + mae_direccion +
                ", mae_estatus=" + mae_estatus +
                '}';
    }
}