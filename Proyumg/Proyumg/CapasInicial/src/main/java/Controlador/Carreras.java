package Controlador;

public class Carreras {

    private int car_codigo;
    private String car_nombre;
    private String car_estatus;

    public Carreras() {
    }

    public Carreras(int car_codigo, String car_nombre, String car_estatus) {
        this.car_codigo = car_codigo;
        this.car_nombre = car_nombre;
        this.car_estatus = car_estatus;
    }

    public int getCar_codigo() {
        return car_codigo;
    }

    public void setCar_codigo(int car_codigo) {
        this.car_codigo = car_codigo;
    }

    public String getCar_nombre() {
        return car_nombre;
    }

    public void setCar_nombre(String car_nombre) {
        this.car_nombre = car_nombre;
    }

    public String getCar_estatus() {
        return car_estatus;
    }

    public void setCar_estatus(String car_estatus) {
        this.car_estatus = car_estatus;
    }
}