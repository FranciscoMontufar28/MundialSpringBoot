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
                <h1>Votos</h1>
                <ol class="breadcrumb">
                <li><a href="<c:url value="/menu/menu.htm"/>">Menu</a></li>
                <li class="active">Votacion</li>
                </ol>
                
                <table class="table table-bordered table-striped table-hover" >
                    <thead>
                        <tr>
                            <th>Nombres</th>
                            <th>Apellidos</th>
                            <th>Club Deportivo</th>
                            <th>Votos</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${datos}" var="votos">
                            <tr>
                                <td><c:out value="${votos.name}"/></td>
                                <td><c:out value="${votos.lastname}"/></td>
                                <td><c:out value="${votos.club}"/></td>
                                <td><c:out value="${votos.votes}"/></td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </body>
</html>
