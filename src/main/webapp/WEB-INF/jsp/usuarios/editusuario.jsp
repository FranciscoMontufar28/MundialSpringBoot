<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    </head>
    <body>
        <div class="container">
            <ol class="breadcrumb">
                <li><a href="<c:url value="/usuarios/usuarios.htm"/>">Usuarios</a></li>
                <li class="active">Editar</li>
            </ol>

            <div class="panel panel-primary">
                <div class="panel-heading">Formulario</div>
                <div class="panel-body">
                    
                    <form:form method="post" modelAttribute="usuarios">
                        <h1>Editar Usuarios</h1>
                        
                        <form:errors path="*" element="div" cssClass="alert alert-danger"/>
                      
                        <p>
                            <form:label path="name">Nombres</form:label>
                            <form:input path="name" cssClass="form-control"/>                        
                        </p>
                        
                        <p>
                            <form:label path="lastname">Apellidos</form:label>
                            <form:input path="lastname" cssClass="form-control"/>                        
                        </p>
                        
                        <p>
                            <form:label path="identification">Cedula</form:label>
                            <form:input path="identification" cssClass="form-control"/>                        
                        </p>
                        <p>
                            <form:label path="password">Clave</form:label>
                            <form:input type="password" path="password" cssClass="form-control"/>                        
                        </p>
                        <p>
                            <form:label path="type">Tipo de Usuario (Admin/Normal | 1/0)</form:label>
                            <form:input path="type" cssClass="form-control"/>                        
                        </p>
                        <hr/>
                        <input type="submit" value="Enviar" class="btn btn-danger"/>
                        
                    </form:form>
                    
                </div>

            </div>
        </div>

    </body>
</html>