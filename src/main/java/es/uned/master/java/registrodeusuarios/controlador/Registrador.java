package es.uned.master.java.registrodeusuarios.controlador;
/**
        * @author: Irina Medina Sierra
        * @version: 15/06/2022
        * @Description:  Este servlet realiza el llamado a la Clase UserDAO para almacenar los datos introducidos en el
        * registro.jsp utilizando el método POST
        */
import es.uned.master.java.registrodeusuarios.modelo.UserDAO;
import es.uned.master.java.registrodeusuarios.modelo.Usuario;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "Registrador", value = "/Registrador")
public class Registrador extends HttpServlet {
    Usuario usuarioNuevo=new Usuario();
    UserDAO newDAO=new UserDAO();
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String accion2=request.getParameter("registrar");
        int respuesta=0;
        if (accion2.equals("Enviar")){
            String mensaje;
            String nombre=request.getParameter("nombre");
            String email=request.getParameter("email");
            String user=request.getParameter("user");
            String pass=request.getParameter("pass");
            usuarioNuevo.setNombre(nombre);
            usuarioNuevo.setEmail(email);
            usuarioNuevo.setUsuario(user);
            usuarioNuevo.setPassword(pass);
            respuesta=newDAO.registrar(usuarioNuevo);
            if (respuesta==1){
                if(  request.getSession().getAttribute("usuario")==null){
                request.getRequestDispatcher("index.jsp").forward(request,response);}
                else{
                    request.getRequestDispatcher("crudClientes.jsp").forward(request,response);
                }

            }else if (respuesta==2){
                mensaje="&#10140;La contraseña introducida no cumple los requisitos";
                request.getSession().setAttribute("mensaje",mensaje);
                request.getRequestDispatcher("registro.jsp").forward(request,response);
            }
            else if (respuesta==3){
                mensaje="&#10140;El nombre de usuario ya existe en la Base de Datos";
            request.getSession().setAttribute("mensaje",mensaje);
            request.getRequestDispatcher("registro.jsp").forward(request,response);
             }
            else if (respuesta==0){
                mensaje="&#10140;Error al registrar el usuario. Contacte con el Administrador del Sistema";
                request.getSession().setAttribute("mensaje",mensaje);
                request.getRequestDispatcher("registro.jsp").forward(request,response);
            }
        }
    }
}
