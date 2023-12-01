package org.iesvdm.jsp_project.dao;

import org.iesvdm.jsp_project.model.Usuario;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.iesvdm.jsp_project.dao.AbstractDAOImpl.closeDb;
import static org.iesvdm.jsp_project.dao.AbstractDAOImpl.connectDB;

public class UsuarioDAOImpl extends AbstractDAOImpl implements UsuarioDAO{
    @Override
    public void create(Usuario usuario) {

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        ResultSet rsGenKeys = null;

        try {
            conn = connectDB();


            //1 alternativas comentadas:
            //Ver también, AbstractDAOImpl.executeInsert ...
            //Columna fabricante.codigo es clave primaria auto_increment, por ese motivo se omite de la sentencia SQL INSERT siguiente.
            ps = conn.prepareStatement("INSERT INTO usuario (nombre, contrasena) VALUES (?, ?)", Statement.RETURN_GENERATED_KEYS);

            int idx = 1;
            ps.setString(idx++, usuario.getNombre());
            ps.setString(idx++, usuario.getContrasena());

            int rows = ps.executeUpdate();
            if (rows == 0)
                System.out.println("INSERT de usuario con 0 filas insertadas.");

//            rsGenKeys = ps.getGeneratedKeys();
//            if (rsGenKeys.next())
//                usuario.setUsuarioID(rsGenKeys.getInt(1));

        } catch (SQLException | ClassNotFoundException  e) {
            e.printStackTrace();
        } finally {
            closeDb(conn, ps, rs);
        }

    }

    @Override
    public List<Usuario> getAll() {

        Connection conn = null;
        Statement s = null;
        ResultSet rs = null;

        List<Usuario> listUsuario = new ArrayList<>();

        try {
            conn = connectDB();

            // Se utiliza un objeto Statement dado que no hay parámetros en la consulta.
            s = conn.createStatement();

            rs = s.executeQuery("SELECT * FROM usuario");
            while (rs.next()) {
                Usuario usuario = new Usuario();

                usuario.setNombre(rs.getString("nombre"));
                usuario.setContrasena(rs.getString("contrasena"));
                listUsuario.add(usuario);
            }

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            closeDb(conn, s, rs);
        }
        return listUsuario;

    }

    @Override
    public Optional<Usuario> find(int id) {

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = connectDB();

            ps = conn.prepareStatement("SELECT * FROM usuario WHERE nombre = ?");

            ps.setInt(1, id);

            rs = ps.executeQuery();

            if (rs.next()) {
                Usuario usuario = new Usuario();

                usuario.setNombre(rs.getString("nombre"));
                usuario.setContrasena(rs.getString("contrasena"));

                return Optional.of(usuario);
            }

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            closeDb(conn, ps, rs);
        }

        return Optional.empty();

    }

    @Override
    public void update(Usuario usuario) {

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = connectDB();

            ps = conn.prepareStatement("UPDATE usuario SET nombre = ?, contrasena = ?");
            int idx = 1;
            ps.setString(idx++, usuario.getNombre());
            ps.setString(idx++, usuario.getContrasena());


            int rows = ps.executeUpdate();

            if (rows == 0)
                System.out.println("Update de usuario con 0 registros actualizados.");

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            closeDb(conn, ps, rs);
        }

    }

    @Override
    public void delete(int id) {

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = connectDB();

            ps = conn.prepareStatement("DELETE FROM usuario WHERE nombre = ?");
            int idx = 1;
            ps.setInt(idx, id);

            int rows = ps.executeUpdate();

            if (rows == 0)
                System.out.println("Delete de usuario con 0 registros eliminados.");

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            closeDb(conn, ps, rs);
        }

    }
}
