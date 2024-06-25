<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
    if (session.getAttribute("logueado") != "OK") {
        response.sendRedirect("login.jsp");
    }
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
    <head>
        <title>MEDI SANA</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
        <link rel="stylesheet" href="./css/main.css">
        <script src="//cdn.jsdelivr.net/npm/sweetalert2@11"></script>
    </head>
    <body>
        <!-- Menu -->
        <jsp:include page="WEB-INF/Menu.jsp"/>

        <!-- Content page-->
        <section class="full-box dashboard-contentPage">
            <!-- NavBar -->
            <nav class="full-box dashboard-Navbar">
                <ul class="full-box list-unstyled text-right">
                    <li class="pull-left">
                        <a href="#!" class="btn-menu-dashboard"><i class="zmdi zmdi-more-vert"></i></a>
                    </li>
                </ul>
            </nav>
            <!-- Content page -->
            <div class="container-fluid">
                <div class="page-header">
                    <h1 class="text-titles"><i class="zmdi zmdi-truck zmdi-hc-fw"></i>ESTADOS <small>Consultorio</small></h1>
                </div>
                <c:if test="${requestScope.action == 'add'}" var="res" scope="request">
                    <p class="lead">Formulario para registrar nuevo estado.</p>
                </c:if>
                <c:if test="${requestScope.action == 'edit'}" var="res" scope="request">
                    <p class="lead">Formulario para editar datos de estado.</p>
                </c:if>
            </div>

            <div class="container-fluid">
                <ul class="breadcrumb breadcrumb-tabs">
                    <li>
                        <a href="EstadoControlador" class="btn btn-info">
                            <i class="zmdi zmdi-format-list-bulleted"></i> &nbsp; LISTA DE ESTADOS
                        </a>
                    </li>
                    <li>
                        <a href="EstadoControlador?action=add" class="btn btn-success">
                            <i class="zmdi zmdi-plus"></i> &nbsp; NUEVO ESTADO
                        </a>
                    </li>
                </ul>
            </div>

            <!-- panel datos de la empresa -->
            <div class="container-fluid">
                <div class="panel panel-success">
                    <div class="panel-heading">
                        <h3 class="panel-title"><i class="zmdi zmdi-plus"></i> &nbsp; 
                            <c:if test="${requestScope.action == 'add'}" var="res" scope="request">
                                NUEVO
                            </c:if>
                            <c:if test="${requestScope.action == 'edit'}" var="res" scope="request">
                                EDITAR
                            </c:if>
                            REGISTRO DE ESTADO
                        </h3>
                    </div>
                    <div class="panel-body">
                        <form action="EstadoControlador" method="POST" >
                            <fieldset>
                                <legend><i class="zmdi zmdi-assignment"></i> &nbsp; DATOS BASICOS</legend>
                                <div class="container-fluid">
                                    <div class="row">
                                        <input type="hidden" name="id" value="${estado.id}">
                                        <div class="col-xs-12">
                                            <div class="form-group label-floating">
                                                <label class="control-label">INGRESE ESTADO</label>
                                                <input class="form-control" type="text" name="estado" required="" value="${estado.estado}">
                                            </div>
                                            <div class="form-group label-floating">
                                                <label class="control-label">INGRESE DESCRIPCIÓN</label>
                                                <input class="form-control" type="text" name="descripcion" required="" value="${estado.descripcion}">
                                            </div>
                                        </div>
                                    </div>
                            </fieldset>                            
                            <br>
                            <br>
                            <p class="text-center" style="margin-top: 20px;">
                                <button type="submit" class="btn btn-info btn-raised btn-lg"><i class="zmdi zmdi-floppy"></i> GUARDAR </button>
                            </p>
                        </form>
                    </div>
                </div>
            </div>

        </section>
        <jsp:include page="WEB-INF/Scripts.jsp"/>
    </body>
</html>

