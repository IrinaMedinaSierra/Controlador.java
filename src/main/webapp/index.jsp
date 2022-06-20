
<%@ page contentType="text/html;charset=UTF-8"  %>
<%--
  Created by IntelliJ IDEA.
  User: irina
  Date: 16/6/22
  Time: 23:24
  To change this template use File | Settings | File Templates.
--%>


<jsp:include page="header.html"></jsp:include>
<!DOCTYPE html>
<html lang="es">
<head>
    <title>Sistema de Alta Online- Login</title>

</head>

<body>
<div class="container">
    <div class="row">
        <div class="col text-center">
            <h1>Sistema de Alta Online</h1>
            <p>Por favor, complete sus credenciales para iniciar sesión.</p>
        </div>
    </div>
    <form action="Controlador" method="post" class="needs-validation" novalidate>
        <div class="row my-4 justify-content-center">
            <div class="col-4">
                <label for="user" class="form-label">Usuario:</label>
                <input type="text" name="user" id="user" class="form-control" required autocomplete>
            </div>
        </div>
        <div class="row my-4 justify-content-center">
            <div class="col-4">
                <label for="pass" class="form-label">Contraseña:</label>
                <input type="password" name="pass" class="form-control" id="pass" required autocomplete>
            </div>
        </div>
        <div class="row my-4 text-center justify-content-center">
            <div class="col-5">
                <input type="submit" name="submit" value="Entrar" class="btn boton">
            </div>
        </div>
    </form>
    <form method="post" action="Servlet">
    <div class="row my-4 mx-5">
        <div class="col text-center">
            <p>Si no esta registrado, puede hacerlo pulsando clic
            <a href="registro.jsp" class="btn boton my-4">aqui</a></p>


        </div>
    </div>
    </form>
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
</div>
</body>

</html>