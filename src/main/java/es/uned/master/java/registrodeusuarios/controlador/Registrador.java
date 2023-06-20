package es.uned.master.java.registrodeusuarios.controlador;
/**
        * @author: Irina Medina Sierra
        * @version: 15/06/2022
        * @Description:  Este servlet realiza el llamado a la Clase UserDAO para almacenar los datos introducidos en el
        * registro.jsp utilizando el método POST
        */
import es.uned.master.java.registrodeusuarios.modelo.*;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

import static es.uned.master.java.registrodeusuarios.modelo.DepartamentoDAO.listarDep;

@WebServlet(name = "Registrador", value = "/Registrador")
public class Registrador extends HttpServlet {
    Usuario usuarioNuevo = new Usuario();
    UserDAO newDAO = new UserDAO();
    DepartamentoDAO d = new DepartamentoDAO();
    EstadoDeLaCuentaDAO c = new EstadoDeLaCuentaDAO();
    int respuesta = 0;
    String mensaje = "";
    String errores = "";

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {



        request.getRequestDispatcher("registro.jsp").forward(request, response);
        String nombre = request.getParameter("nombre");
        String email = request.getParameter("email");
        String user = request.getParameter("user");
        String pass = request.getParameter("pass");
        String idEstado = request.getParameter("idEstado");
        String idDepartamento = request.getParameter("idDepartamento");
        usuarioNuevo.setNombre(nombre);
        usuarioNuevo.setEmail(email);
        usuarioNuevo.setUsuario(user);
        usuarioNuevo.setPassword(pass);
        usuarioNuevo.setIdEstado(Integer.parseInt(idEstado));
        usuarioNuevo.setIdDepartamento(Integer.parseInt(idDepartamento));
        String id = "";
               /* try{
                    id= request.getParameter("id");
                     usuarioNuevo.setId(Integer.parseInt(id));
            }catch (Exception e){
                    System.out.println("no hay id de consulta");
                //procede de home o es un alta nueva
            }*/
        respuesta = newDAO.registrar(usuarioNuevo);
        System.out.println("la respuesta que llega es:" + respuesta);
        if (respuesta == 1) {
            System.out.println("entra al if de enviar al index");
            // Mensaje de que se ha creado correctamente el usuario
            mensaje = "&#10140;El usuario se ha creado correctamente";
            request.getSession().setAttribute("error", mensaje);
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }
        if (respuesta == 2) {
            errores = "&#10140;La contraseña introducida no cumple los requisitos";
            usuarioNuevo.setPassword("");
        }
        if (respuesta == 3) {
            errores = "&#10140;El nombre de usuario ya existe en la Base de Datos";
            usuarioNuevo.setUsuario("");
        }
        if (respuesta == 4) {
            errores = "&#10140;El email de usuario ya existe en la Base de Datos";
            usuarioNuevo.setEmail("");
        }
        if (respuesta == 0) {
            errores = "&#10140;Error al registrar el usuario. Contacte con el Administrador del Sistema";
        }
        if (respuesta == 0 || respuesta > 1) {
            request.setAttribute("user", usuarioNuevo);
            request.getSession().setAttribute("mensajeDeError", errores);
            listarEstadoYDep(request, response);
            request.getRequestDispatcher("registro.jsp").forward(request, response);
        }

    }


    /**
     * Este servlet se encarga de leer los datos necesrios que se mostraran en la vista de  Registro
     *
     * @return registro.jsp
     * @return los datos que lee en la vista
     */
    private void listarEstadoYDep(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Departamento> listDep = d.listarDep();
        request.setAttribute("listDep", listDep);
        List<EstadoDeLaCuenta> listEstado = c.listarEstado();
        request.setAttribute("listEstado", listEstado);
    }

}





