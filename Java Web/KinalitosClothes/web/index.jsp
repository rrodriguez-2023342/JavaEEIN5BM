<%-- 
    Document   : Index
    Created on : 22/07/2025, 10:16:00
    Author     : informatica
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>K.C - Login</title>
        <link rel="icon" type="image/x-icon" href="Images/Logo_K.C.png">
        <link rel="stylesheet" href="Styles/index.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.7.2/css/all.min.css">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/material-icons@1.13.12/iconfont/material-icons.min.css">
    </head>

    <body>
        <nav class="navbar">
            <div class="container">
                <div class="logo">K<span>C</span></div>
            </div>
        </nav>

        <section>
            <div class="container">
                <div class="segundo_contenedor">
                    <div class="informacion">
                        <span class="line"></span>
                        <h2>Bienvenido a <br><span>Kinalitos Clothes</span></h2>
                        <p>Encuentra toda tu ropa a buenos precios</p>
                        <a href="https://wa.link/cp8m9x" class="btnContacto">Contactanos</a>
                        <div class="redes-sociales">
                            <a href="https://www.facebook.com/"><i class="fa-brands fa-facebook-f"></i></a>
                            <a href="https://www.instagram.com/"><i class="fa-brands fa-instagram"></i></a>
                            <a href="https://discord.gg/K5C57rwJGM"><i class="fa-brands fa-discord"></i></a>
                        </div>
                    </div>

                    <div class="login">
                        <div class="form">
                            <div class="text-center">
                                <h6><span>Log in </span> <span>Sign up</span></h6>
                                <input type="checkbox" class="checkbox" id="reg-log">
                                <label for="reg-log"></label>

                                <div class="card-3d-wrap">
                                    <div class="card-3d-wrapper">

                                        <!-- FORMULARIO DE LOGIN -->
                                        <div class="card-front">
                                            <div class="center-wrap">
                                                <form action="LoginServlet" method="post">
                                                    <h4 class="heading">Inicio de Sesión</h4>
                                                    <div class="form-group">
                                                        <input type="text" name="usuario" id="usuario_login" class="form-style" placeholder="Usuario" autocomplete="off" required>
                                                        <i class="input-icon material-icons">perm_identity</i>
                                                    </div>
                                                    <div class="form-group">
                                                        <input type="password" name="password" id="password_login" class="form-style" placeholder="Contraseña" autocomplete="off" required>
                                                        <i class="input-icon material-icons">lock</i>
                                                    </div>
                                                    <button type="submit" class="btnIniciar">Entrar</button>
                                                    <p class="text-center">
                                                        <a href="Index/menu.jsp" class="link">No te recuerdas de tu contraseña???</a>
                                                    </p>
                                                </form>
                                            </div>
                                        </div>

                                        <!-- FORMULARIO DE REGISTRO -->
                                        <div class="card-back">
                                            <div class="center-wrap">
                                                <form action="RegistroServlet" method="post">
                                                    <h4 class="heading">Registrarse</h4>
                                                    <div class="form-group">
                                                        <input type="text" name="usuario" id="usuario_registro" class="form-style" placeholder="Usuario" autocomplete="off" required>
                                                        <i class="input-icon material-icons">perm_identity</i>
                                                    </div>
                                                    <div class="form-group">
                                                        <input type="password" name="password" id="password_registro" class="form-style" placeholder="Contraseña" autocomplete="off" required>
                                                        <i class="input-icon material-icons">lock</i>
                                                    </div>
                                                    <div class="form-group">
                                                        <input type="password" name="confirmar" id="confirmar_registro" class="form-style" placeholder="Confirmar contraseña" autocomplete="off" required>
                                                        <i class="input-icon material-icons">lock</i>
                                                    </div>
                                                    <button type="submit" class="btnRegistrar">Registrarme</button>
                                                </form>
                                            </div>
                                        </div>

                                    </div>
                                </div>

                            </div>
                        </div>
                    </div>

                </div>
            </div>
        </section>
    </body>

</html>
