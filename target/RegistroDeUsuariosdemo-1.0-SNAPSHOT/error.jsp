<%--
  Created by IntelliJ IDEA.
  User: irina
  Date: 19/6/22
  Time: 10:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isErrorPage="true" %>
<jsp:include page="header.jsp"></jsp:include>
<html>
<head>
    <title>Title</title>
</head>
    <body>

    <div class="container">
        <div class="row">
            <div class="col text-center">
                    <h1>Sistema de Alta Online</h1>
            </div>
        </div>
        <div class="row my-4 ">
                    <div class="col text-center border ">
                        <p><%= exception.getMessage() %></p><br/><br/>
                    <h3>Por favor contacte con su administrador</h3>
                    <a href="index.jsp" class="btn boton my-4">Volver al Inicio</a>
                    </div>
    </div>
</div>

</body>
</html>
