<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="../header.jsp"></jsp:include>

<%--
  Created by IntelliJ IDEA.
  User: Irina Medina Sierra
  Date: 17/6/22
  Time: 01:16
  To change this template use File | Settings | File Templates.
--%>
<div class="container">
    <div class="row">
        <div class="col-12 text-white text-center negro" style="padding: 50px">
            <h1>Sistema de Alta Online</h1>
        </div>
    </div>

<div class="row bg-white py-4">
    <div class="row justify-content-center">
        <div class="col-9 ">
        <form action="Registrador" method="Post">
            <button name="registrar" value="altaCRUD" class="iconos-crud"><span class="material-icons">person_add
</span> Nuevo Usuario</button>
        </form>
<%--        <a href="registroCRUD.jsp" class="iconos-crud"><span class="material-icons">person_add--%>
<%--</span> Nuevo Usuario</a>--%>
        </div>
    </div>
    <div class="row justify-content-center">
        <div class="col-9 ">
   <table class="table table-hover">
       <thead class="table-light">
       <tr>
           <th>Nombre </td>
           <td>Email </td>
           <td>Usuario</td>
           <td>Estado</td>
           <td>Departamento</td>
           <td>Opciones</td>
       </tr>
       </thead>
       <tbody>
       <c:set var="nFilas" value="10" />
       <c:forEach var="usuario" items="${listUser}" begin="${param.first}" end="${param.first + nFilas - 1}">
       <tr>
        <!--   <td id="usuarioID"><c:out value="${usuario.id}"/></td>-->
           <td><c:out value="${usuario.nombre}"/></td>
           <td><c:out value="${usuario.email}"/></td>
           <td><c:out value="${usuario.usuario}"/></td>
           <td><c:out value="${usuario.estado}"/></td>
           <td><c:out value="${usuario.departamento}"/></td>

           <td>
               <a href="Editar?id=${usuario.id}" id="editar">
                   <span class="material-icons iconos-crud">edit</span>
               </a>
               <a href="Eliminar?id=${usuario.id}" id="eliminar">
                   <span class="material-icons iconos-crud">delete</span>
               </a>
           </td>
       </tr>
       </c:forEach>
       </tbody>
   </table>
            <nav aria-label="Page navigation example">
                <ul class="pagination justify-content-center">
                <c:forEach items="listPag"  var="pag" varStatus="count">
                    <li class="page-item"><a class="page-link" href="#"><td>${pag.cout}</td>
                    </a></li>
                </c:forEach>
                </ul>
            </nav>



        </div>
    </div>
    </div>

</div>
</div>
</body>
</html>
