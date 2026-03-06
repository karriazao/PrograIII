package Vista;

import Controlador.Jornadas;
//import Controlador.Maestros;
import Modelo.JornadasDAO;
//import Modelo.MaestrosDAO;

public class Principal {

    //public static void main(String[] args) {

//       Maestros maestro = new Maestros();
//        maestro.setMae_codigo(1);
//        maestro.setMae_nombre("Maria Cuevas");
//        maestro.setMae_direccion("Antigua Guatemala");
//        maestro.setMae_estatus("Inactivo");

//        MaestrosDAO maestrosDAO = new MaestrosDAO();

        // INSERTAR
//        int registros = maestrosDAO.insert(maestro);
//        System.out.println("Registros insertados: " + registros);

        // CONSULTAR
//        Maestros maestroBuscar = new Maestros();
//        maestroBuscar.setMae_codigo(1);

//        maestroBuscar = maestrosDAO.query(maestroBuscar);

//        System.out.println("Maestro encontrado:");
//        System.out.println(maestroBuscar);

        // ACTUALIZAR
 //       Maestros maestroActualizar = new Maestros();
//        maestroActualizar.setMae_codigo(1);
//        maestroActualizar.setMae_nombre("Juan Perez Actualizado");
//        maestroActualizar.setMae_direccion("Zona 1");
//        maestroActualizar.setMae_estatus("Activo");

//        maestrosDAO.update(maestroActualizar);

        // ELIMINAR
//        Maestros maestroEliminar = new Maestros();
//        maestroEliminar.setMae_codigo(1);

//        maestrosDAO.delete(maestroEliminar);
//    }
    
    public static void main(String[] args) {

        Jornadas jornada = new Jornadas();
        jornada.setJor_codigo(1);
        jornada.setJor_nombre("Vespertina");

        JornadasDAO jornadasDAO = new JornadasDAO();

        // INSERTAR
        int registros = jornadasDAO.insert(jornada);
        System.out.println("Registros insertados: " + registros);

        // CONSULTAR
        Jornadas jornadaBuscar = new Jornadas();
        jornadaBuscar.setJor_codigo(1);

        jornadaBuscar = jornadasDAO.query(jornadaBuscar);

        System.out.println("Jornada encontrado:");
        System.out.println(jornadaBuscar);

        // ACTUALIZAR
        Jornadas jornadaActualizar = new Jornadas();
        jornadaActualizar.setJor_codigo(1);
        jornadaActualizar.setJor_nombre("");

        jornadasDAO.update(jornadaActualizar);

        // ELIMINAR
        Jornadas jornadaEliminar = new Jornadas();
        jornadaEliminar.setJor_codigo(1);

        jornadasDAO.delete(jornadaEliminar);
    }
    
}