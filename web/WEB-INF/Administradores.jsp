<%-- 
    Document   : Administradores
    Created on : 5/10/2023, 8:04:39 a. m.
    Author     : Sebas
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="bootstrap-5.3.0-alpha2-dist/bootstrap-5.3.0-alpha2-dist/css/bootstrap.css">
        <link rel="stylesheet" href="bootstrap-5.3.0-alpha2-dist/bootstrap-5.3.0-alpha2-dist/js/bootstrap.js">
        <link rel="stylesheet" href="bootstrap-5.3.2-dist/bootstrap-5.3.2-dist/css/bootstrap.css"/>
        <link rel="stylesheet" href="CssIndex.css"/>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Log Administradores</title>
    </head>
    <jsp:useBean id="unAdministrador" class="Modelo.Administrador" scope="request" />
    <body>

    </body>
    <center>
        <h1>Registro Administradores</h1>
        <table border="1">
            <tr>
                <th>Correo</th>  <br>
            <th>Contraseña</th> <br>
            <br>

            <th><th>
                </tr>
                <c:forEach items="${unAdministrador.Listar(0)}" var="elAdministrador">
                <tr>
                <form action="ControladorAdministrador" method="post">
                  
                        <td><input type="hidden" name="fIdAdministrador"
                                   value="${elAdministrador.idAdministrador}">
                            <input type="email" name="fCorreoAdm" value="${elAdministrador.correoAdm}"></td>
                        <td><input type="password" name="fContraseñaAdm" value="${elAdministrador.contraseñaAdm}"></td>
                        
                        <td><button type="submit" class="btn btn-outline-success" name="fAccion" value="Modificar">Modificar</button> 
                            <button type="submit" class="btn btn-outline-danger" name="fAccion" value="Eliminar">Eliminar</button></td>
                </form>
                </tr>
            </c:forEach>
            <tr>
            <tr>
            <form action="ControladorAdministrador" method="post">
                <td><input type="text" name="fCorreoAdm" >
                <td><input type="text" name="fCAdm">
                
                <td><button type="submit" class="btn btn-outline-warning" name="fAccion" value="Insertar">Insertar</button> 
                    <button type="reset" class="btn btn-outline-info" name="fAccion" value="Limpiar">Limpiar</button></td>
                <br>
                <br>
                <button id="lbl"  href="ControladorMenu1?opcion=IndexIniciada" class="btn btn-primary" type="submit"><a href="ControladorMenu1?opcion=IndexIniciada"">Volver a Inicio</a></button>
                <br>
                <br>
            </form>
            </tr>
        </table>  
    </center>
    <svg id="loading-svg" xmlns='http://www.w3.org/2000/svg' viewBox='0 0 300 150'><path fill='none' stroke='#19fffb' stroke-width='15' stroke-linecap='round' stroke-dasharray='300 385' stroke-dashoffset='0' d='M275 75c0 31-27 50-50 50-58 0-92-100-150-100-28 0-50 22-50 50s23 50 50 50c58 0 92-100 150-100 24 0 50 19 50 50Z'><animate attributeName='stroke-dashoffset' calcMode='spline' dur='2' values='685;-685' keySplines='0 0 1 1' repeatCount='indefinite'></animate></path></svg>
    <script>// Escucha el evento "beforeunload" que se dispara antes de cambiar de página
        window.addEventListener("beforeunload", function () {
            // Muestra el SVG antes de que la página cambie
            document.getElementById('loading-svg').style.display = 'block';
        });

// Escucha el evento "load" que se dispara después de cargar la nueva página
        window.addEventListener("load", cerrar);

        function cerrar() {
            document.getElementById('loading-svg').style.display = 'none';
        }
    </script>


    <style>
        #loading-svg{
            position: absolute;
            inset: 0 0 0 0;
        }
    </style>
</html>
