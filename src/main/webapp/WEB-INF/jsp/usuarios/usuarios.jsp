<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset=UTF-8">
        <title>Usuarios</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    </head>
    <body>
        <div class="container">
            <div class="row">
                <h1>Usuarios</h1>
                <ol class="breadcrumb">
                    <li><a href="<c:url value="/menu/menu.htm"/>">Menu</a></li>
                    <li class="active">Usuarios</li>
                </ol>

                <p>
                    <a href="<c:url value="/usuarios/addusuario.htm"/>" class="btn btn-success"><span class="glyphicon glyphicon-plus" aria-hidden="true"></span>Agregar</a>
                </p>
                <table class="table table-bordered table-striped table-hover" >
                    <thead>
                        <tr>
                            <th>Nombres</th>
                            <th>Apellidos</th>
                            <th>Identificacion</th>
                            <th>Clave</th>
                            <th>Tipo de Usuario</th>
                            <th>Fecha Registro</th>
                            <th>Acciones</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${datos}" var="dato">
                            <tr>
                                <td><c:out value="${dato.name}"/></td>
                                <td><c:out value="${dato.lastname}"/></td>
                                <td><c:out value="${dato.identification}"/></td>
                                <td><c:out value="${dato.password}"/></td>
                                <td><c:out value="${dato.type}"/></td>
                                <td><c:out value="${dato.date}"/></td>
                                <td>
                                    <a href="<c:url value="/usuarios/editusuario.htm?id=${dato.idusuarios}"/>"><span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>Editar</a>
                                    <a href="<c:url value="/usuarios/deleteusuario.htm?id=${dato.idusuarios}"/>"><span class="glyphicon glyphicon-trash" aria-hidden="true"></span>Eliminar</a>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </body>
</html>