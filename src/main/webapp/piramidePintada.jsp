<%--
  Created by IntelliJ IDEA.
  User: muffinsita
  Date: 3/12/23
  Time: 10:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Piramide pintada</title>
</head>
<body>

    <div id="piramide" style="text-align: center"></div>

    <script>
        let piramideHTML;
        //crear img
        const img = document.createElement('img');
        img.setAttribute("src", "https://www.verdeesvida.es/inc/timthumb.php?src=/files/reportage/11042015103647_iStock_Gato%20bengali%20Andreas%20Krappweiss.jpg&w=130");
        img.setAttribute("alt", "Gato");

        //cargar contenido
        document.addEventListener('DOMContentLoaded', () => {
            const piramideElement = document.getElementById('piramide');
            //obtener parametro de url
            const searchParams = new URLSearchParams(location.search);
            let altura;
            //construir piramide
            if (searchParams.has("altura")){
                altura = parseInt(searchParams.get("altura"));
                //se crea un fragment para renderizar cuando haya acabado el loop
                const fragment = document.createDocumentFragment();
                for (let i = 0; i <= altura; i++) {
                    const filaDiv = document.createElement('div');
                    for (let k = 1; k <= (2 * i - 1); k++){
                        //se clona el nodo para no machacarlo
                        filaDiv.append(img.cloneNode());
                    }
                    //se anaden las filas al fragment
                    fragment.append(filaDiv);
                }
                //se anade el fragmento completo al div del html
                piramideElement.append(fragment);
            }
        });
    </script>

</body>
</html>
