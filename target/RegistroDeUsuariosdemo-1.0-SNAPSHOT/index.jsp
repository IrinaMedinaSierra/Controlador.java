
<%@ page contentType="text/html;charset=UTF-8"  %>
<%--
  Created by IntelliJ IDEA.
  User: Irina Medina Sierra
  Date: 16/6/22
  Time: 23:24
  Despription: Página principal donde el usuario se auntetica para entrar en el CRUD. Esta compuesta por un formulario
  solicita la información necesaria, y en caso de no estar registrado, tiene un boton, que lleva a otro formulario de
  registro
--%>
<jsp:include page="header.jsp"></jsp:include>
<!DOCTYPE html>
<html lang="es">
<head>
    <title>Sistema de Alta Online- Login</title>

</head>
<body>
<div class="container">
    <div class="row">
        <div class="col-12 text-white text-center negro" style="padding: 50px">
            <h1>Sistema de Alta Online</h1>
        </div>
    </div>
    <div class="row bg-white py-4 text-center">
            <p>Por favor, complete sus credenciales para iniciar sesión.</p>

    <div class="row my-4 justify-content-center text-danger mensaje fs-5">
        ${error}
    </div>
    <form action="Controlador" method="post" class="needs-validation" novalidate>
        <div class="row my-4 justify-content-center">
            <div class="col-4">
                <label for="user" class="form-label">Usuario:</label>
                <input type="text" name="user" id="user" class="form-control border-0 border-bottom" required autocomplete>
            </div>
        </div>
        <div class="row my-4 justify-content-center">
            <div class="col-4">
                <label for="pass" class="form-label">Contraseña:</label>
                <input type="password" name="pass" class="form-control border-0 border-bottom" id="pass" required autocomplete>
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
</div>
</body>

</html>