package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import Controlador.Maestros;

public class MaestrosDAO {

    private static final String SQL_SELECT =
            "SELECT mae_codigo, mae_nombre, mae_direccion, mae_estatus FROM Maestros";

    private static final String SQL_INSERT =
            "INSERT INTO Maestros(mae_nombre, mae_direccion, mae_estatus) VALUES(?,?,?)";

    private static final String SQL_UPDATE =
            "UPDATE Maestros SET mae_nombre=?, mae_direccion=?, mae_estatus=? WHERE mae_codigo=?";

    private static final String SQL_DELETE =
            "DELETE FROM Maestros WHERE mae_codigo=?";

    private static final String SQL_QUERY =
            "SELECT mae_codigo, mae_nombre, mae_direccion, mae_estatus FROM Maestros WHERE mae_codigo=?";

    public List<Maestros> select() {

        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        Maestros maestro;
        List<Maestros> maestros = new ArrayList<>();

        try {

            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();

            while (rs.next()) {

                int codigo = rs.getInt("mae_codigo");
                String nombre = rs.getString("mae_nombre");
                String direccion = rs.getString("mae_direccion");
                String estatus = rs.getString("mae_estatus");

                maestro = new Maestros();
                maestro.setMae_codigo(codigo);
                maestro.setMae_nombre(nombre);
                maestro.setMae_direccion(direccion);
                maestro.setMae_estatus(estatus);

                maestros.add(maestro);
            }

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {

            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);

        }

        return maestros;
    }

    public int insert(Maestros maestro) {

        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {

            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);

            stmt.setString(1, maestro.getMae_nombre());
            stmt.setString(2, maestro.getMae_direccion());
            stmt.setString(3, maestro.getMae_estatus());

            rows = stmt.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {

            Conexion.close(stmt);
            Conexion.close(conn);

        }

        return rows;
    }

    public int update(Maestros maestro) {

        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {

            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_UPDATE);

            stmt.setString(1, maestro.getMae_nombre());
            stmt.setString(2, maestro.getMae_direccion());
            stmt.setString(3, maestro.getMae_estatus());
            stmt.setInt(4, maestro.getMae_codigo());

            rows = stmt.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {

            Conexion.close(stmt);
            Conexion.close(conn);

        }

        return rows;
    }

    public int delete(Maestros maestro) {

        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {

            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_DELETE);

            stmt.setInt(1, maestro.getMae_codigo());

            rows = stmt.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {

            Conexion.close(stmt);
            Conexion.close(conn);

        }

        return rows;
    }

    public Maestros query(Maestros maestro) {

        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {

            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_QUERY);

            stmt.setInt(1, maestro.getMae_codigo());

            rs = stmt.executeQuery();

            if (rs.next()) {

                maestro.setMae_nombre(rs.getString("mae_nombre"));
                maestro.setMae_direccion(rs.getString("mae_direccion"));
                maestro.setMae_estatus(rs.getString("mae_estatus"));

            }

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {

            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);

        }

        return maestro;
    }
}