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
                <h1>Jugadores</h1>
                <ol class="breadcrumb">
                    <li><a href="<c:url value="/menu/menu.htm"/>">Menu</a></li>
                    <li class="active">Jugadores</li>
                </ol>
                <p>
                    <a href="<c:url value="/jugadores/addjugador.htm"/>" class="btn btn-success"><span class="glyphicon glyphicon-plus" aria-hidden="true"></span>Agregar</a>
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
                        <c:forEach items="${datosp}" var="datop">
                            <tr>
                                <td><c:out value="${datop.name}"/></td>
                                <td><c:out value="${datop.lastname}"/></td>
                                <td><c:out value="${datop.club}"/></td>
                                <td>
                                    <a href="<c:url value="/jugadores/editjugador.htm?id=${datop.idjugadores}"/>"><span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>Editar</a>
                                    <a href="<c:url value="/jugadores/deletejugadores.htm?id=${datop.idjugadores}"/>"><span class="glyphicon glyphicon-trash" aria-hidden="true"></span>Eliminar</a>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </body>
</html>