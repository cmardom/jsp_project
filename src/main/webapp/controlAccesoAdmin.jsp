<%@ page import="org.iesvdm.jsp_project.model.Usuario" %>
<%@ page import="java.util.List" %><%--

  Created by IntelliJ IDEA.
  User: muffinsita
  Date: 3/12/23
  Time: 11:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Control Acceso Admin</title>
</head>
<body>
    <h1>Control de acceso</h1>
    <img style="width: 10%" alt="candado" src="https://cdn-icons-png.flaticon.com/512/69/69891.png">
    <p>Tiene acceso al area de gestion de usuarios</p>
    <%
        List<Usuario> listadoUsuarios = (List<Usuario>) request.getAttribute("listado");
    %>
    <form method="GET" action="gestionUsuarios.jsp">
        <input type="submit" value="Aceptar">
    </form>
</body>
</html>
