package es.uned.master.java.registrodeusuarios.controlador;

import es.uned.master.java.registrodeusuarios.modelo.UserDAO;
import es.uned.master.java.registrodeusuarios.modelo.Usuario;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "Controlador", value = "/Controlador")
public class Controlador extends HttpServlet {
    UserDAO dao=new UserDAO();
    Usuario u=new Usuario();
    int r;
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String accion=request.getParameter("submit");
        if (accion.equals("Entrar")){
            //Si el usuario entra, se lee los datos de usuario y password para enviarlo a la interfaz validar
            String user=request.getParameter("user");
            String pass=request.getParameter("pass");
            u.setUsuario(user);
            u.setPassword(pass);
            r= dao.validar(u);
            //dao.validar nos devuelve un valor 0, para indicar que el usuario no existe y 1 nos lleva al CRUD
            if (r==1){
                request.getRequestDispatcher("crudClientes.jsp").forward(request,response);
            }else{
                request.getRequestDispatcher("index.jsp").forward(request,response);
            }
        }
    }
}

