<%--
  Created by IntelliJ IDEA.
  User: muffinsita
  Date: 1/12/23
  Time: 13:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Introduce tus datos</title>
</head>
<body>
    <h2>Introduce tus datos</h2>
    <form action="ListarUsuariosServlet" method="GET">
        <label for="nombre">Nombre:</label>
        <input type="text" id="nombre" name="nombre" required><br><br>
        <label for="contrasena">Contraseña:</label>
        <input type="password" id="contrasena" name="contrasena" required><br><br>
        <input type="submit" value="Iniciar Sesión">
    </form>

</body>
</html>
