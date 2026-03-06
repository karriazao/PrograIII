package Controlador;

public class Cursos {

    private int cur_codigo;
    private String cur_nombre;
    private String cur_estatus;

    public Cursos() {
    }

    public Cursos(int cur_codigo, String cur_nombre, String cur_estatus) {
        this.cur_codigo = cur_codigo;
        this.cur_nombre = cur_nombre;
        this.cur_estatus = cur_estatus;
    }

    public int getCur_codigo() {
        return cur_codigo;
    }

    public void setCur_codigo(int cur_codigo) {
        this.cur_codigo = cur_codigo;
    }

    public String getCur_nombre() {
        return cur_nombre;
    }

    public void setCur_nombre(String cur_nombre) {
        this.cur_nombre = cur_nombre;
    }

    public String getCur_estatus() {
        return cur_estatus;
    }

    public void setCur_estatus(String cur_estatus) {
        this.cur_estatus = cur_estatus;
    }
}
