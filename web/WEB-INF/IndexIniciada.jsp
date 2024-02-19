<!DOCTYPE html>
<!--
Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Html.html to edit this template
-->
<html>
    <head>
        <link rel="stylesheet" href="CssIndex.css"/>
        <title>IndexIniciada</title>
        
        <meta charset="UTF-8">
        <style type="text/css">
        body {
            cursor: url(http://www.rw-designer.com/cursor-extern.php?id=172758), auto;
        }
    </style>
        <meta name="viewport" content="width    =device-width, initial-scale=1.0">
    </head>
    <body>

    <center> <div  id="logo">
            <img class="dl" src="imagenes/logo deli.png" width="150" height="150" alt="A"/>
            <a id="btt" href="ControladorMenu1?opcion=Administradores"><h3>Administrador</h3></a>
            <a id="btt1" href="ControladorMenu1?opcion=Productos"><h3>Productos</h3></a>
            <a id="btt2" href="ControladorMenu1?opcion=ClienteAdm"><h3>Clientes</h3></a>
            <a id="btt2" href="ControladorMenu1?opcion=index"><h3>Cerrar Sesion</h3></a>


        </div>
    </center>



    <div id="lp"> <center><h2>---------Productos que te pueden interesar-------aa-- </h2> </center></div>

    <br>  <br>  <br>

    <div id="imgs">    


        <div id="im">
            <center><h3>---Productos De Paquetes---</h3></center><a href="ControladorMenu1?opcion=Productos">
                <img id="im" src="imagenes/paquetes.png" alt="alt" width="220" height="220"/></a>
        </div>
        <div id="im">
            <center><h3>---Productos Lacteos---</h3></center><a href="ControladorMenu1?opcion=Productos">
                <img id="im" src="imagenes/lacteos.jpeg" alt="alt" width="220" height="220"/></a>
        </div>
        <div id="im">
            <center><h3>---Comidas Rapidas---</h3></center><a href="ControladorMenu1?opcion=Productos">
                <img id="im" src="imagenes/descarga.jpeg" alt="alt" width="220" height="220"/> </a>
        </div>
        <div id="im"> 
            <center><h3>---Carnes y Mariscos---</h3></center><a href="ControladorMenu1?opcion=Productos">
                <img id="im" src="imagenes/carnes.jpeg" alt="alt" width="220" height="220"/></a>
        </div>
        <div id="im">
            <center><h3>---Productos De Aseo---</h3></center><a href="ControladorMenu1?opcion=Productos">
                <img  src="imagenes/aseo.jpg" alt="alt" width="220" height="220"/></a>
        </div>
        <div >
            <center><h3>---Herramientas---</h3></center><a href="ControladorMenu1?opcion=Productos">
                <img id="im" src="imagenes/herramientas.jpg" alt="alt" width="220" height="220"/></a>
        </div>
        <div id="im">
            <center><h3>---Embutidos---</h3></center><a href="ControladorMenu1?opcion=Productos">
                <img id="im" src="imagenes/pizza.jpeg" alt="alt" width="220" height="220"/> </a>
        </div>
        <div id="im"> 
            <center> <h3>---Frutas y Vegetales---</h3></center><a href="ControladorMenu1?opcion=Productos">
                <img id="im" src="imagenes/frutas y vegetales.jpg" alt="alt" width="220" height="220"/></a>
        </div>

    </div>
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
    <style type="text/css">
        body {
            cursor: url(http://www.rw-designer.com/cursor-extern.php?id=172758);
        }
    </style>
    <a href="http://www.rw-designer.com/cursor-set/electric-3"
       title="Get free cursors for your web.">Electric Cursors</a>

</body>
</html>
