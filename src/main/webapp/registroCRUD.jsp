<jsp:include page="header.jsp"></jsp:include>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%--
  Created by IntelliJ IDEA.
  User: Irina Medina Sierra
  Date: 16/6/22
  Time: 23:24
  Despription: Página de registro  compuesta por un formulario  solicita la información necesaria para dar de alta a un nuevo usuario

--%>
<%@ page contentType="text/html;charset=UTF-8"  pageEncoding="UTF-8" %>


<!DOCTYPE html>
<html lang="es">
<head>
    <title>Sistema de Alta Online - Registro</title>
</head>

<body>
<div class="container">
    <div class="row negativo">
        <div class="col-lg-12 text-end">
            <p class="fs-6">  ${nombreL}</p>
            <a href="javascript:window.print()" title="Imprimir"><span class="material-icons  iconos">print</span></a>
            <a href="Logout" title="Salir"><span class="material-icons  iconos">logout</span></a></p>
        </div>
    </div>
    <div class="row">
        <div class="col-12 text-white text-center negro" style="padding: 50px">
            <h1>Sistema de Alta Online</h1>
        </div>
    </div>
    <div class="row bg-white py-4 text-center">


        <p>Por favor, complete el formulario para Actualizar sus datos.</p>
        <form action="Registrador" method="post" class="needs-validation " novalidate>
            <input type="hidden" value="${nombre}" name="usuarioLogeado">
            <input type="hidden" name="id" value="<c:out value='${user.id}' />" />

                <div class="row  justify-content-center text-danger mensaje fs-5  ">
                    ${mensaje}
                </div>

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
                        <label for="user" class="form-label">Estado de Conexión:</label>
                        <input type="text" name="idEstado" id="idEstado" class="form-control border-0 border-bottom" required value="<c:out value='${user.idEstado}' />">
                    </div>
                    <div class="col-4">
                        <label for="pass" class="form-label">Departamento:</label>
                         <input type="text" name="idDepartamento" id="idDepartamento" class="form-control border-0 border-bottom" required value="<c:out value='${user.idDepartamento}' />">
                    </div>
                </div>
                <div class="row my-4 text-center justify-content-center">
                    <div class="col-5">
                        <input type="submit" name="boton" value="Enviar" class="btn boton ">
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
