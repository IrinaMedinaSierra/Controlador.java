package es.uned.master.java.registrodeusuarios.controlador;
/**
 * @author: Irina Medina Sierra
 * @version: 15/06/2022
 * @Description:  Este servlet realiza el llamado a la Clase UserDAO para VALIDAR los datos introducidos en el
 * index.jsp utilizando el método POST
 */
import es.uned.master.java.registrodeusuarios.modelo.Estado;
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
    Estado estado;
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
                String nombre="Usuario: "+u.getNombre();
                request.getSession().setAttribute("usuario",user);
                request.getSession().setAttribute("nombre",nombre);
                request.getRequestDispatcher("crudClientes.jsp").forward(request,response);
            }else{
                String errores=" &#10140; Existe un error en el usuario o en la contraseña. Verifique sus datos";
                request.getSession().setAttribute("error",errores);
                request.getRequestDispatcher("index.jsp").forward(request,response);
            }
        }
    }
}

