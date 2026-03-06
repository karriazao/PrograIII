package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import Controlador.Jornadas;

public class JornadasDAO {

    private static final String SQL_SELECT =
            "SELECT jor_codigo, jor_nombre";

    private static final String SQL_INSERT =
            "INSERT INTO Maestros(jor_codigo, jor_nombre) VALUES(?,?)";

    private static final String SQL_UPDATE =
            "UPDATE Maestros SET jor_nombre=? WHERE jor_codigo=?";

    private static final String SQL_DELETE =
            "DELETE FROM Maestros WHERE jor_codigo=?";

    private static final String SQL_QUERY =
            "SELECT jor_codigo, jor_nombre FROM Jornadas WHERE jor_codigo=?";

    public List<Jornadas> select() {

        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        Jornadas jornada;
        List<Jornadas> jornadas = new ArrayList<>();

        try {

            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();

            while (rs.next()) {

                int codigo = rs.getInt("jor_codigo");
                String nombre = rs.getString("jor_nombre");

                jornada = new Jornadas();
                jornada.setJor_codigo(codigo);
                jornada.setJor_nombre(nombre);

                jornadas.add(jornada);
            }

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {

            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);

        }

        return jornadas;
    }

    public int insert(Jornadas jornada) {

        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {

            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);

            stmt.setString(1, jornada.getJor_nombre());

            rows = stmt.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {

            Conexion.close(stmt);
            Conexion.close(conn);

        }

        return rows;
    }

    public int update(Jornadas jornada) {

        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {

            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_UPDATE);

            stmt.setString(1, jornada.getJor_nombre());
            stmt.setInt(4, jornada.getJor_codigo());

            rows = stmt.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {

            Conexion.close(stmt);
            Conexion.close(conn);

        }

        return rows;
    }

    public int delete(Jornadas jornada) {

        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {

            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_DELETE);

            stmt.setInt(1, jornada.getJor_codigo());

            rows = stmt.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {

            Conexion.close(stmt);
            Conexion.close(conn);

        }

        return rows;
    }

    public Jornadas query(Jornadas jornada) {

        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {

            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_QUERY);

            stmt.setInt(1, jornada.getJor_codigo());

            rs = stmt.executeQuery();

            if (rs.next()) {

                jornada.setJor_nombre(rs.getString("jor_nombre"));

            }

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {

            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);

        }

        return jornada;
    }
}