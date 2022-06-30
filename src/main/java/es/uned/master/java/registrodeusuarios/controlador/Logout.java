package es.uned.master.java.registrodeusuarios.controlador;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;


@WebServlet(name = "Logout", value = "/Logout")
public class Logout extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        HttpSession sesion = request.getSession(true);
        sesion.removeAttribute("usuario");
        //Cerrar sesion
        sesion.invalidate();

        //Redirecciono a index.jsp
        request.getRequestDispatcher("index.jsp").forward(request,response);


    }

}
