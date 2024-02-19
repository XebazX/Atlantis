<%-- 
    Document   : InicioSesion
    Created on : 12/10/2023, 10:35:22 a. m.
    Author     : Sebas
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <link rel="stylesheet" href="bootstrap-5.3.2-dist/bootstrap-5.3.2-dist/css/bootstrap.css"/>
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="bootstrap-5.3.0-alpha2-dist/bootstrap-5.3.0-alpha2-dist/css/bootstrap.css">
        <link rel="stylesheet" href="bootstrap-5.3.0-alpha2-dist/bootstrap-5.3.0-alpha2-dist/js/bootstrap.js">
        <link rel="stylesheet" href="estiloiniciada.css">
        <title>Inicio de Sesion</title>
    </head>
    <jsp:useBean id="unCliente" class="Modelo.Cliente" scope="request" />
    <body id="bdy">


        <div id="isss">

            <br>
            <center>
                <h1 id="tle">Inicio de Sesion C.</h1>
            </center>

            <c:forEach items="${unCliente.Listar(0)}" var="elAdministrador">
                <Center>   <p id="di" class="shining-text" ></p> </Center>
                <form action="ControladorLogin2" method="post" id="fm" class="row g-3 needs-validation" novalidate>

                    <div class="col-md-9">
                        <br><label id="lbl" for="validationCustom01" class="form-label">Ingrese Su Nombre</label><br>
                        <input name="fnombreCliente" type="text" class="form-control" value="${unCliente.nombreCliente}" id="validationCustom01" required>
                        <div class="valid-feedback">
                            Ok
                        </div>
                        <div class="invalid-feedback">
                            Portugal
                        </div>

                        <div class="col-md-12">
                            <br><br>
                            <label id="lbl" for="validationCustom03" class="form-label">Ingrese su Documento</label>
                            <br><input name="fdocumentoCliente" type="numeric" class="form-control" value="${unCliente.documentoCliente}" id="validationCustom03" required>
                            <div class="valid-feedback">
                                Ok
                            </div>
                            <div class="invalid-feedback">
                              España
                            </div>
                        </div>
                        <br>
                        <center> <a id="shining-text" href="Registro.php">No tienes cuenta? Registrate!</a> </center>
                        <br>
                        <div id="lbl" class="col-12">
                            <button id="lbl" name="fEnviar" value="sesion" class="btn btn-primary" type="submit">Enviar</button>
                        </div>
                </form>
        </div>
                            <script>
                                (() => {
                                'use strict'
                                        const forms = document.querySelectorAll('.needs-validation')
                                        Array.from(forms).forEach(form => {
                                form.addEventListener('submit', event => {
                                if (!form.checkValidity()) {
                                event.preventDefault()
                                        event.stopPropagation()
                                }

                                form.classList.add('was-validated')
                                }, false)
                                })
                                })()
                            </script>
                            <style>
                                @keyframes shining {
                                    0% {
                                        color: #ffbbbb;
                                    }
                                    50% {
                                        color: rgb(255, 0, 0);
                                        text-shadow: 0 0 50px rgb(255, 0, 0);
                                    }
                                    100% {
                                        color: #ffbbbb;
                                    }
                                }

                                .shining-text {
                                    animation: shining 2s linear infinite;
                                }
                            </style>
                </script>
                <style>
                    @keyframes shining {
                        0% {
                            color: #013cff;
                        }
                        50% {
                            color: rgb(255, 0, 0);
                            text-shadow: 0 0 50px rgb(170, 236, 255);
                        }
                        100% {
                            color: #013cff;
                        }
                    }

                    #shining-text {
                        animation: shining 4s linear infinite;
                        text-decoration: none;
                    }
                </style>

    <div id="mensaje-sesion">
        <!-- El mensaje de sesión iniciada se mostrará aquí -->
    </div>

    <script>
                // Comprueba si la sesión ha sido iniciada
                        function checkSession() {
                        var isLoggedIn = <?php echo(isset($_SESSION['loggedin']) && $_SESSION['loggedin'] === true) ? 'true' : 'false'; ?>;
        
        if (isLoggedIn) {
                                var username = '<?php echo isset($_SESSION['username']) ? $_SESSION['username'] : ''; ?>';
                        var mensaje = document.getElementById('mensaje-sesion');
                        mensaje.innerHTML = '<p>Sesión iniciada como: ' + username + '</p>';
            }
            }
            
            // Llama a la función para comprobar la sesión al cargar la página
                window.onload = checkSession;
                </script>
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
