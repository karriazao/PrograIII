package Controlador;

public class AsignacionCursosAlumnos {

    private int car_codigo;
    private int cur_codigo;
    private int mae_codigo;
    private int alu_codigo;
    private double aca_nota;

    public AsignacionCursosAlumnos() {
    }

    public AsignacionCursosAlumnos(int car_codigo, int cur_codigo, int mae_codigo, int alu_codigo, double aca_nota) {
        this.car_codigo = car_codigo;
        this.cur_codigo = cur_codigo;
        this.mae_codigo = mae_codigo;
        this.alu_codigo = alu_codigo;
        this.aca_nota = aca_nota;
    }

    public int getCar_codigo() {
        return car_codigo;
    }

    public void setCar_codigo(int car_codigo) {
        this.car_codigo = car_codigo;
    }

    public int getCur_codigo() {
        return cur_codigo;
    }

    public void setCur_codigo(int cur_codigo) {
        this.cur_codigo = cur_codigo;
    }

    public int getMae_codigo() {
        return mae_codigo;
    }

    public void setMae_codigo(int mae_codigo) {
        this.mae_codigo = mae_codigo;
    }

    public int getAlu_codigo() {
        return alu_codigo;
    }

    public void setAlu_codigo(int alu_codigo) {
        this.alu_codigo = alu_codigo;
    }

    public double getAca_nota() {
        return aca_nota;
    }

    public void setAca_nota(double aca_nota) {
        this.aca_nota = aca_nota;
    }
}