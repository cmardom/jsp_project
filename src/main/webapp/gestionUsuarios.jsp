<%@ page import="org.iesvdm.jsp_project.model.Usuario" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: muffinsita
  Date: 3/12/23
  Time: 11:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Gestion de usuarios</title>
</head>
<body>
    <h1>Gestion de usuarios</h1>
    <div class="listaUsuarios">
        <%
            List<Usuario> listadoUsuarios = (List<Usuario>) request.getAttribute("listado");
            for (Usuario usuario : listadoUsuarios){

        %>
            <div class="row mt-2 body">
                <div class="col-md-1 align-self-center"><%=usuario.getNombre()%> </div>
                <div class="col-md-4 align-self-center"><%=usuario.getContrasena()%> </div>
            </div>
        <%
                //v--- FIN DEL BUCLE FOR CON HTML INCRUSTADO
            } // for
        %>
    </div>

</body>
</html>
