package es.uned.master.java.registrodeusuarios.controlador;


/**
 * @author: Irina Medina Sierra
 * @version: 15/06/2022
 * @Description:  Este servlet realiza el llamado a la Clase UserDAO para VALIDAR los datos introducidos en el
 * index.jsp utilizando el método POST
 */
import es.uned.master.java.registrodeusuarios.modelo.UserDAO;
import es.uned.master.java.registrodeusuarios.modelo.Usuario;
import es.uned.master.java.registrodeusuarios.controlador.Controlador;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "Eliminar", value = "/Eliminar")

public class Eliminar extends HttpServlet {
    private static final long serialVersionUID = 1L;
    UserDAO dao = new UserDAO();
    Usuario u = new Usuario();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id=(request.getParameter("id"));
        dao.borrar(id);
        List<Usuario> listUser = dao.listar();
        request.setAttribute("listUser",listUser);
        request.getRequestDispatcher("restringido/crudClientes.jsp").forward(request,response);
    }

}