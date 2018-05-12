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
                <p>
                    <a href="<c:url value="/jugadores/jugadores.htm"/>" class="btn btn-success">Jugadores</a>
                    <a href="<c:url value="/usuarios.htm"/>" class="btn btn-success">Usuarios</a>
                </p>
            </div>
        </div>
    </body>
</html>