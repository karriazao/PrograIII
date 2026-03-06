/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

import domain.Vendedor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author visitante
 */
public class VendedorDAO {

    private static final String SQL_SELECT = "SELECT id_vendedor, nombrevendedor, direvendedor FROM vendedor";// el select es mas general o global. Y el query se le agrega WHERE para traer un registro exacto
    private static final String SQL_INSERT = "INSERT INTO vendedor(nombrevendedor, direvendedor) VALUES(?, ?)";
    private static final String SQL_UPDATE = "UPDATE vendedor SET nombrevendedor=?, direvendedor=? WHERE id_vendedor = ?";
    private static final String SQL_DELETE = "DELETE FROM vendedor WHERE id_vendedor=?";
    private static final String SQL_QUERY = "SELECT id_vendedor, nombrevendedor, direvendedor FROM vendedor WHERE id_vendedor = ?";

    public List<Vendedor> select() {//el tipo de dato o metodo es de lista, una lista de registros. Apertura de base de datos
        Connection conn = null;//se apartó memoria ram
        PreparedStatement stmt = null;//se apartó memoria ram
        ResultSet rs = null;//se apartó memoria ram
        Vendedor vendedor = null;
        List<Vendedor> vendedores = new ArrayList<Vendedor>();//array list, es un tipo de matriz

        try {
            conn = Conexion.getConnection();// el select lo trae de base de datos a Java. conn Abre la base de datos
            stmt = conn.prepareStatement(SQL_SELECT);//stmt es un comando, que prepara la instruccion para la base de datos para emparejar el java con sql
            rs = stmt.executeQuery();//recordset Un set de datos. Se ejecuta el query
            while (rs.next()) {//si no se cumple la condición, no se ejecutara lo que esta dentro de las llaves. Si es positivo es porque habrán datos
                int id_vendedor = rs.getInt("id_vendedor");//campo de la base de datos, lo verde y entre comillas
                String nombre = rs.getString("nombrevendedor");//Las clases siempre estaran en controlador, se saca de la clase y se pasa a la lista.
                String direccion = rs.getString("direvendedor");
                
                vendedor = new Vendedor();
                vendedor.setId_vendedor(id_vendedor);
                vendedor.setNombreVendedor(nombre);
                vendedor.setDireVendedor(direccion);
                
                vendedores.add(vendedor);
            }

        } catch (SQLException ex) {//pueden ser entradas y salidas 
            ex.printStackTrace(System.out);//se tiene que controlar la conexión. Se puede corregir el error para poder solucionarlo (excepciones).
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }//al momento de cerrar al orden inverso del que se abrieron

        return vendedores;//se cierran las conexiones, y se cierra la lista. La cual esta en plural o no singular como el objeto
    }

    public int insert(Vendedor vendedor) {//parametro y que recibe un objeto
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, vendedor.getNombreVendedor());//un objeto de memoria, no de la base de datos. Para comunicarse y completar los comodines, llamando desde el comando set
            stmt.setString(2, vendedor.getDireVendedor());
                //no hay rs, porque se esta insertando, no llamando datos

            System.out.println("ejecutando query:" + SQL_INSERT);
            rows = stmt.executeUpdate();//ejecutar el insert, y se colocan los datos en filas
            System.out.println("Registros afectados:" + rows);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return rows;//envia a la BD
    }

    public int update(Vendedor vendedor) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            System.out.println("ejecutando query: " + SQL_UPDATE);
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, vendedor.getNombreVendedor());
            stmt.setString(2, vendedor.getDireVendedor());
            stmt.setInt(3, vendedor.getId_vendedor());

            rows = stmt.executeUpdate();
            System.out.println("Registros actualizado:" + rows);

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return rows;
    }

    public int delete(Vendedor vendedor) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_DELETE);
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, vendedor.getId_vendedor());
            rows = stmt.executeUpdate();//la actualización hizo que se eliminaran parametros
            System.out.println("Registros eliminados:" + rows);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return rows;
    }

//    public List<Persona> query(Persona vendedor) { // Si se utiliza un ArrayList
    public Vendedor query(Vendedor vendedor) {    //se utiliza para la busqueda de datos directamente, utilizando el WHERE en la BD
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Vendedor> vendedores = new ArrayList<Vendedor>();
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_QUERY);
            stmt = conn.prepareStatement(SQL_QUERY);
            stmt.setInt(1, vendedor.getId_vendedor());
            rs = stmt.executeQuery();
            while (rs.next()) {
                int id_vendedor = rs.getInt("id_vendedor");
                String nombre = rs.getString("nombrevendedor");
                String direccion = rs.getString("direvendedor");
                
                vendedor = new Vendedor();
                vendedor.setId_vendedor(id_vendedor);
                vendedor.setNombreVendedor(nombre);
                vendedor.setDireVendedor(direccion);
                
                //vendedores.add(vendedor); // Si se utiliza un ArrayList
            }
            //System.out.println("Registros buscado:" + vendedor);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        //return vendedores;  // Si se utiliza un ArrayList
        return vendedor;
    }
        
}
//esto ayuda para los mantenimientos