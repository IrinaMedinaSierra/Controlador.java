<%@ page import="java.util.List" %>
<%@ page import="es.uned.master.java.registrodeusuarios.modelo.Usuario" %>
<%@ page import="java.util.Iterator" %>
<%@ page import="es.uned.master.java.registrodeusuarios.modelo.UserDAO" %>
<%--
  Created by IntelliJ IDEA.
  User: Irina Medina Sierra
  Date: 17/6/22
  Time: 01:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="header.jsp"></jsp:include>

<html>
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<div class="container">
    <div class="row">
        <div class="col-lg-12 text-end">
            <p class="fs-6">  ${nombre}</p>
            <p> <a href="" title="Cambiar Clave"><span class="material-icons iconos">admin_panel_settings</span></a>
                <a href="javascript:window.print()" title="Imprimir"><span class="material-icons  iconos">print</span></a>
                <a href="Logout" title="Salir"><span class="material-icons  iconos">logout</span></a></p>
        </div>
    </div>
    <div class="row">
        <div class="col-12 text-white text-center negro" style="padding: 50px">
            <h1>Sistema de Alta Online</h1>
        </div>
    </div>

<div class="row bg-white py-4">
    <div class="row justify-content-center">
        <div class="col-9 ">
        <a href='registroCRUD.jsp' class="iconos-crud"><span class="material-icons">person_add
</span> Nuevo Usuario</a>
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
           <td>Opciones</td>
       </tr>
       </thead>
       <%
           //Optimizar este codigo
           UserDAO dao=new UserDAO();
           List<Usuario>list=dao.listar();
           Iterator<Usuario> iter=list.iterator();
           Usuario user=null;
           while (iter.hasNext()){
               user=iter.next();
       %>
       <tbody>
       <tr>
           <td><%=user.getNombre()%></td>
           <td><%=user.getEmail()%></td>
           <td><%=user.getUsuario()%></td>
           <td>
               <a href="" title="Editar"><span class="material-icons iconos-crud">edit</span></a>
               <a href="" title="Eliminar"><span class="material-icons iconos-crud">delete</span></a>
           </td>
       </tr>
       <%}%>
       </tbody>

   </table>
        </div>
    </div>
</div>
</div>
</body>
</html>
