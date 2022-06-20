package es.uned.master.java.registrodeusuarios.controlador;

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
                request.getRequestDispatcher("index.jsp").forward(request,response);
            }else{
                request.getRequestDispatcher("registro.jsp").forward(request,response);
            }
        }
    }
}
