package org.iesvdm.jsp_project.servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.iesvdm.jsp_project.dao.UsuarioDAO;
import org.iesvdm.jsp_project.dao.UsuarioDAOImpl;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

//lo primero que aparecerá por pantalla será un formulario pidiendo el nombre de usuario y la contraseña.
//
//Si el usuario y la contraseña son correctos,se podrá acceder;
// en caso contrario, volverá a aparecer el formulario pidiendo los datos de acceso y no se nos dejará ejecutar la aplicación
// hasta que iniciemos sesión con un nombre de usuario y contraseña correctos.
@WebServlet(name = "GrabarUsuarioServlet", value = "/GrabarUsuarioServlet")
public class GrabarUsuarioServlet extends HttpServlet {
    private UsuarioDAO usuarioDAO = new UsuarioDAOImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/formularioUsuarioB.jsp");
        //CAMBIAR PETICION DEL DISPATCHER

        dispatcher.forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        RequestDispatcher dispatcher = null;
        //CREAR UTIL SERVLET
        Optional<Usuario> optionalUsuario = UtilServlet.validarUsuario(request);

        if (optionalUsuario.isPresent()) {

            Usuario usuario = optionalUsuario.get();
            this.usuarioDAO.create(usuario);
            List<Usuario> listado = this.usuarioDAO.getAll();


            request.setAttribute("listado", listado);
            request.setAttribute("newUsuarioID", usuario.getUsuarioID());
            
            dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/listadoUsuariosB.jsp");
            
        } else {
            
            request.setAttribute("error", "Error de validación!");
            
            dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/formularioUsuarioB.jsp");
        }


        dispatcher.forward(request, response);

    }
}