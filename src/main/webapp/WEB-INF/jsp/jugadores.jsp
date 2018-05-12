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
                <h1>Eventos</h1>
                <p>
                    <a href="<c:url value="addjugador.htm"/>" class="btn btn-success"><span class="glyphicon glyphicon-plus" aria-hidden="true"></span>Agregar</a>
                </p>
                <table class="table table-bordered table-striped table-hover" >
                    <thead>
                        <tr>
                            <th>Nombres</th>
                            <th>Apellidos</th>
                            <th>Club</th>
                            <th>Acciones</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${datos}" var="dato">
                            <tr>
                                <td><c:out value="${dato.name}"/></td>
                                <td><c:out value="${dato.lastname}"/></td>
                                <td><c:out value="${dato.club}"/></td>
                                <td>
                                    <a href="<c:url value="editjugador.htm?id=${dato.idusuarios}"/>"><span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>Editar</a>
                                    <a href="<c:url value="deletejugador.htm?id=${dato.idusuarios}"/>"><span class="glyphicon glyphicon-trash" aria-hidden="true"></span>Eliminar</a>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </body>
</html>
