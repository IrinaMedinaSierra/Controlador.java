package es.uned.master.java.registrodeusuarios.controlador;

/**
 * @author: Irina Medina Sierra
 * @version: 15/06/2022
 * @Description:  Este servlet realiza el llamado a la Clase UserDAO para VALIDAR los datos introducidos en el
 * index.jsp utilizando el método POST
 */
import es.uned.master.java.registrodeusuarios.modelo.UserDAO;
import es.uned.master.java.registrodeusuarios.modelo.Usuario;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "Editar", value = "/Editar")

public class Editar extends HttpServlet {
    private static final long serialVersionUID = 1L;
    UserDAO newDAO = new UserDAO();
    Usuario user = new Usuario();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        System.out.println(id);
        Usuario registroUsuario = newDAO.seleccioanrUsuario(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("registro.jsp");
        request.setAttribute("user", registroUsuario);
        dispatcher.forward(request, response);


    }
}