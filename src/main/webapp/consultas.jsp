<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
                    <h1 class="text-titles"><i class="zmdi zmdi-assignment zmdi-hc-fw"></i>CONSULTAS <small>Consultorio</small></h1>
                </div>
                <p class="lead">Lista de las consultas que tiene el consultorio.</p>
            </div>


            <div class="container-fluid">
                <ul class="breadcrumb breadcrumb-tabs">
                    <li>
                        <a href="ConsultaControlador" class="btn btn-info">
                            <i class="zmdi zmdi-format-list-bulleted"></i> &nbsp; LISTA DE CONSULTAS
                        </a>
                    </li>
                    <li>
                        <a href="ConsultaControlador?action=add" class="btn btn-success">
                            <i class="zmdi zmdi-plus"></i> &nbsp; NUEVA CONSULTA
                        </a>
                    </li>
                </ul>
            </div>

            <!-- panel lista de empresas -->
            <div class="container-fluid">
                <div class="panel panel-info">
                    <div class="panel-heading">
                        <h3 class="panel-title"><i class="zmdi zmdi-format-list-bulleted"></i> &nbsp; LISTA DE CONSULTAS</h3>
                    </div>
                    <div class="panel-body">
                        <div class="table-responsive">
                            <table class="table table-hover text-center">
                                <thead>
                                    <tr>
                                        <th class="text-center">ID</th>
                                        <th class="text-center">DOCTOR</th>
                                        <th class="text-center">PACIENTE</th>
                                        <th class="text-center">FECHA</th>
                                        <th class="text-center">HORA</th>
                                        <th class="text-center">SINTOMAS</th>
                                        <th class="text-center">DIAGNOSTICO</th>
                                        <th class="text-center">RECETAS</th>
                                            <c:if test="${rol=='Administrador'}">
                                            <th class="text-center">EDITAR</th>
                                            <th class="text-center">ELIMINAR</th>
                                            </c:if>
                                    </tr>
                                </thead>
                                <tbody>
                                    <c:forEach var="item" items="${consultas}">
                                        <tr>
                                            <td>${item.id}</td>
                                            <td>${item.doctor}</td>
                                            <td>${item.paciente}</td>
                                            <td>${item.fecha}</td>
                                            <td>${item.hora}</td>
                                            <td>${item.sintomas}</td>
                                            <td>${item.diagnostico}</td>
                                            <td>
                                                <a href="RecetaDeterminadaControlador?id_consulta=${item.id}&paciente=${item.paciente}&sex_paciente=${item.sex_paciente}" class="btn btn-primary btn-raised btn-xs">
                                                    <i class="zmdi zmdi-assignment"></i>
                                                </a>
                                            </td>
                                            <c:if test="${rol=='Administrador'}">
                                                <td>                                                                    
                                                    <a href="ConsultaControlador?action=edit&id=${item.id}" class="btn btn-success btn-raised btn-xs">
                                                        <i class="zmdi zmdi-edit"></i>
                                                    </a>
                                                </td>
                                                <td>
                                                    <a href="ConsultaControlador?action=delete&id=${item.id}" class="btn btn-danger btn-raised btn-xs" onclick='return confirm("¿Estas seguro de eliminar la consulta \"${item.id}\"?")'>
                                                        <i class="zmdi zmdi-delete"></i>
                                                    </a>
                                                </td>
                                            </c:if>
                                        </tr>
                                    </c:forEach>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
            </div>
        </section>
        <jsp:include page="WEB-INF/Scripts.jsp"/>
    </body>
</html>