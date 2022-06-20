<%--
  Created by IntelliJ IDEA.
  User: irina
  Date: 16/6/22
  Time: 23:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="header.html"></jsp:include>
<!DOCTYPE html>
<html lang="es">
<head>
    <title>Sistema de Alta Online - Registro</title>
</head>

<body>
<div class="container">
    <div class="row ">
        <div class="col text-center">
            <h1>Sistema de Alta Online</h1>
        </div>
    </div>
    <div class="row my-4 mx-5 justify-content-center">
        <div class="col-6 text-center">

        </div>
    </div>
    <div class="row my-4 mx-5">
        <div class="col text-center">
            <p>Por favor, complete sus credenciales para Registrarse.</p>
        </div>
    </div>
    <form action="Registrador" method="post" class="needs-validation" novalidate>
        <div class="row my-4 justify-content-center">
            <div class="col-4">
                <label for="nombre" class="form-label">Nombres y Apellidos:</label>
                <input type="text" name="nombre" id="nombre" class="form-control" required>
            </div>
            <div class="col-4">
                <label for="email" class="form-label">Email:</label>
                <input type="text" name="email" id="email" class="form-control" required>
            </div>
        </div>
        <div class="row my-4 justify-content-center">
            <div class="col-4">
                <label for="user" class="form-label">Usuario:</label>
                <input type="text" name="user" id="user" class="form-control" required>
            </div>
            <div class="col-4">
                <label for="pass" class="form-label">Contraseña:</label>
                <input type="password" name="pass" id="pass" class="form-control" required>
            </div>
        </div>
        <div class="row my-4 text-center justify-content-center">
            <div class="col-5">
                <input type="submit" name="registrar" value="Enviar" class="btn boton ">
            </div>
        </div>
    </form>
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
