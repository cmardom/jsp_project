package org.iesvdm.jsp_project.servlet;

import jakarta.servlet.http.HttpServletRequest;

import java.util.Objects;
import java.util.Optional;
import org.iesvdm.jsp_project.model.Usuario;
import org.iesvdm.jsp_project.dao.UsuarioDAO;
import org.iesvdm.jsp_project.dao.UsuarioDAOImpl;

import static java.lang.Integer.parseInt;

public class UtilServlet {

    public static Optional<Usuario> validarUsuario(HttpServletRequest request) {

        String nombre = null;

        String contrasena = null;
        try {
            Objects.requireNonNull(request.getParameter("nombre"));
            if (request.getParameter("nombre").isBlank()) throw new RuntimeException("Parámetro vacío o todo espacios blancos.");
            nombre = request.getParameter("nombre");


            Objects.requireNonNull(request.getParameter("contrasena"));
            if (request.getParameter("contrasena").isBlank()) throw new RuntimeException("Parámetro vacío o todo espacios blancos.");
            contrasena = request.getParameter("contrasena");


            return Optional.of(new Usuario(nombre, contrasena));

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        //FIN CÓDIGO DE VALIDACIÓN
        return Optional.empty();

    }

}
