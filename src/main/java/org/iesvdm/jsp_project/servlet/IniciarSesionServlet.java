package org.iesvdm.jsp_project.servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.iesvdm.jsp_project.dao.UsuarioDAO;
import org.iesvdm.jsp_project.dao.UsuarioDAOImpl;
import org.iesvdm.jsp_project.model.Usuario;

import java.io.IOException;
import java.util.Optional;

@WebServlet (name = "IniciarSesionServlet", value = "/IniciarSesionServlet")
public class IniciarSesionServlet extends HttpServlet {
    private UsuarioDAO usuarioDAO = new UsuarioDAOImpl();

    protected void doPost (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = null;
        Optional<Usuario> optionalUsuario = UtilServlet.validarUsuario(request);

        if (optionalUsuario.isPresent()){
            Usuario usuario = optionalUsuario.get();
            this.usuarioDAO.find(usuario.getNombre());

            dispatcher = request.getRequestDispatcher("controlAcceso.jsp");
        } else {
            System.out.println("sale");

            dispatcher = request.getRequestDispatcher("/WEB-INF/introducirDatosUsuario.jsp");
        }
        dispatcher.forward(request, response);
    }
}
