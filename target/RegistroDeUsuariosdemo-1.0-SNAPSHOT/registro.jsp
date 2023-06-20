<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8"  pageEncoding="UTF-8" %>

<%--
  Created by IntelliJ IDEA.
  User: Irina Medina Sierra
  Date: 16/6/22
  Time: 23:24
  Despription: Página de registro  compuesta por un formulario  solicita la información necesaria para dar de alta a un nuevo usuario

--%>
<jsp:include page="header.jsp"></jsp:include>
<!DOCTYPE html>
<html lang="es">
<head>
    <title>Sistema de Alta Online - Registro</title>

</head>
<body>

<div class="container">

    <div class="row">
        <div class="col-12 text-white text-center negro" style="padding: 50px">
            <h1>Sistema de Alta Online</h1>
        </div>
    </div>
    <div class="row bg-white py-4 text-center">
        <p>Por favor, complete sus credenciales para Registrarse.</p>
        <div class="row  justify-content-center text-danger mensaje fs-5  ">
            ${mensajeDeError}
        </div>
        <form action="Registrador" method="Post" class="needs-validation " novalidate>
            <div class="row my-4 justify-content-center  ">
                <div class="col-4  ">
                    <label for="nombre" class="form-label">Nombres y Apellidos:</label>
                    <input type="text" name="nombre" id="nombre" class="form-control border-0 border-bottom" required value="<c:out value='${user.nombre}' />" >
                </div>
                <div class="col-4 ">
                    <label for="email" class="form-label">Email:</label>
                    <input type="text" name="email" id="email" class="form-control border-0 border-bottom" required value="<c:out value='${user.email}' />">
                </div>
            </div>
            <div class="row my-4 justify-content-center">
                <div class="col-4">
                    <label for="user" class="form-label">Usuario:</label>
                    <input type="text" name="user" id="user" class="form-control border-0 border-bottom" required value="<c:out value='${user.usuario}' />">
                </div>
                <div class="col-4">
                    <label for="pass" class="form-label">Contraseña:</label>
                    <input type="password" name="pass" id="pass" class="form-control border-0 border-bottom" required value="<c:out value='${user.password}' />">
                </div>
            </div>
            <div class="row my-4 justify-content-center">
                <div class="col-4">
                    <label for="pass" class="form-label">Permiso de Entrada:</label><br>
                    <select name="idEstado" class="form-select" >
                        <option value=""></option>
                        <c:forEach var="EstadoTem" items="${listEstado}">
                            <option value="<c:out value='${EstadoTem.id}'/>">
                                <c:out value="${EstadoTem.estado}"/>
                            </option>
                        </c:forEach>
                    </select>
                </div>
                <div class="col-4">
                    <label for="pass" class="form-label">Departamento:</label><br>
                    <select name="idDepartamento" class="form-select" >
                        <option value=""></option>
                        <c:forEach var="depTem" items="${listDep}">
                            <option value="<c:out value='${depTem.id}'/>">
                            <c:out value="${depTem.departamento}"/>
                            </option>
                        </c:forEach>
                        </select>
                </div>
            </div>

        <div class="row my-4 text-center justify-content-center" >
                        <div class="col-5">
                            <button value="Volver" onclick="window.history.back();" class="btn boton">Volver</button>
                            <input type="submit" name="boton" value="Guardar" class="btn boton ">
                        </div>
                </div>

        </form>
        <div class="row my-4 justify-content-center">
            <div class="col-5">
                <h4>Requisitos de la Contraseña:</h4>
                <ul class="list-group">
                    <li class="list-group-item">Al menos ocho caracteres</li>
                    <li class="list-group-item">Al menos dos letras mayúsculas</li>
                    <li class="list-group-item">AL menos dos letras minúsculas</li>
                    <li class="list-group-item">Al menos dos símbolos especiales</li>
                </ul>
            </div>
        </div>
    </div>
</div>
<script>
    const forms = document.querySelectorAll('.needs-validation')

    // Cuando pulsen click en siguiente, valida que no esten vacio los campos
    Array.from(forms).forEach(form => {
        form.addEventListener('submit', event => {
            if (!form.checkValidity()) {
                event.preventDefault()
                event.stopPropagation()
            }

            form.classList.add('was-validated')
        }, false)
    })
</script>
</body>

</html>
