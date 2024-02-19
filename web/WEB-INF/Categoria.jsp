<%-- 
    Document   : FormularioCliente
    Created on : 20/09/2023, 11:09:04 a. m.
    Author     : Sebas
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    <head>
        <link rel="stylesheet" href="bootstrap-5.3.2-dist/bootstrap-5.3.2-dist/css/bootstrap.css"/>
        <link rel="stylesheet" href="CssIndex.css"/>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Categorias</title>
    </head>
    <jsp:useBean id="unaCategoria" class="Modelo.Categoria" scope="request" />
    <body>


    <center>
        <h1>Categorias</h1>
        <table border="1">
            <tr>
                <th>Nombre</th>
                <th>Documento</th>
                <th><th>
            </tr>
            <c:forEach items="${unaCategoria.Listar(0)}" var="laCategoria">
                <tr>
                <form action="ControladorCategoria" method="post">

                    <td><input type="hidden" name="fidCategoria" value="${laCategoria.idCategoria}">
                        <input type="text" name="fnombreCategoria" value="${laCategoria.nombreCategoria}"></td>
                    <td><button type="submit" class="btn btn-outline-success" name="fAccion" value="Modificar">Modificar</button> 
                        <button type="submit" class="btn btn-outline-danger" name="fAccion" value="Eliminar">Eliminar</button></td>
                </form>
                </tr>
            </c:forEach>
            <tr>
            <tr>
            <form action="ControladorCategoria" method="post">
                <td><input type="text" name="fnombreCategoria" value="">
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

</body>
</html>
