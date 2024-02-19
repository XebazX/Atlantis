<%-- 
    Document   : Carrito
    Created on : 21/11/2023, 10:51:20 a. m.
    Author     : Sebas
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="bootstrap-5.3.0-alpha2-dist/bootstrap-5.3.0-alpha2-dist/css/bootstrap.css"> <link rel="stylesheet" href="bootstrap-5.3.2-dist/bootstrap-5.3.2-dist/css/bootstrap.css"/>
        <link rel="stylesheet" href="bootstrap-5.3.2-dist/bootstrap-5.3.2-dist/css/bootstrap.css"/>
        <link rel="stylesheet" href="CssIndex.css"/>

        <title>Carrito</title>
        
    </head>

    <jsp:useBean id="UnProducto" class="Modelo.Producto" scope="request"/>
    <jsp:useBean id="UnCarrito" class="Modelo.Carrito" scope="request"/>
    <body>
        <h1>Formulario Producto</h1>
        <div class="tabla">
            <table border="1">
                <tr>
                    
                    <th align='center'>idProducto</th>
                    <th>Nombre</th>
                    <th>Detalle</th>
                    <th>Precio</th>
                    <th>Stock</th>

                    <th></th>
                </tr>
                <c:forEach items="${UnProducto.Listar(0)}" var="UnProducto">
                    <tr> 
                    <form action="ControladorCarrito" method="post">
                        <td><input type="number" name="fidProducto" value="${UnProducto.idProducto}"></td>  
                        <td> <input type="text" name="fnombreProducto" value="${UnProducto.nombreProducto}"></td>
                        <td> <input type="text" name="fdetalleProducto" value="${UnProducto.detalleProducto}"></td>
                        <td><input type="number" name="fprecioProducto" value="${UnProducto.precioProducto}"></td>
                        <td><input type="number" name="fstockProducto" value="${UnProducto.stockProducto}"></td>
                        <td><button type="submit" class="btn btn-info" name="fAccion" value="Agregar">Agregar</button></td>
                    </form>
                    </tr>
                </c:forEach>
                <tr>

            </table>
        </div>


        <div class="tabla">
            <table border="1">
                <tr>
                    <th>idProducto</th>
                    <th>Descripión producto</th>
                    <th>Detalle</th>
                    <th>Precio</th>
                    <th>Stock</th>

                    <th></th>
                </tr>

                <c:forEach items="${UnCarrito.listar()}" var="UnProducto">
                    <tr> 
                    <form action="ControladorCarrito" method="post">
                        <td><input type="number" name="fidProducto" value="${UnProducto.idProducto}"></td>  
                        <td> <input type="text" name="fnombreProducto" value="${UnProducto.nombreProducto}"></td>
                        <td> <input type="text" name="fdetalleProducto" value="${UnProducto.detalleProducto}"></td>
                        <td><input type="number" name="fprecioProducto" value="${UnProducto.precioProducto}"></td>
                        <td><input type="number" name="fstockProducto" value="${UnProducto.stockProducto}"></td>
                        <td><button type="submit" name="fAccion" class="btn btn-info" value="modificar">Modificar</button>
                            <button type="submit" name="fAccion" class="btn btn-info" value="Eliminar">Eliminar</button></td>
                    </form>
                    </tr>
                </c:forEach>

            </table>

        </div>

        <div>
            <h1>Total</h1>
            <h2>${Carrito.total}</h2>
            <a name="" href="ControladorFactura">Comprar</a>
        </div>


    </body>
    <style>
        body{
            background-color: buttonhighlight;
        }
        .tabla{
            display: flex;
            margin: 5rem 12rem
        }
    </style>
</html>
