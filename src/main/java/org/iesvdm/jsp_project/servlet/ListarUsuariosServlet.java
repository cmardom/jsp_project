package org.iesvdm.jsp_project.servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.iesvdm.jsp_project.dao.UsuarioDAOImpl;
import org.iesvdm.jsp_project.model.Usuario;
import org.iesvdm.jsp_project.dao.*;

import java.io.IOException;
import java.util.List;


@WebServlet(name = "ListarUsuariosServlet", value = "/ListarUsuariosServlet")
public class ListarUsuariosServlet extends HttpServlet {

    private UsuarioDAO usuarioDAO = new UsuarioDAOImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/listadoUsuariosB.jsp");

        List<Usuario> listado = this.usuarioDAO.getAll();
        request.setAttribute("listado", listado);

        dispatcher.forward(request, response);

    }
}