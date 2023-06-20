package es.uned.master.java.registrodeusuarios.controlador;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
/*
 * @author: Irina Medina Sierra
        * @version: 15/06/2022
        * @Description:  Este servlet realiza el cierre de la sesion del usuario cuando selecciona salir en el CRUD
        *  y vuelve a la página de inicio index.jsp
        */

@WebServlet(name = "Logout", value = "/Logout")
public class Logout extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        HttpSession sesion = request.getSession(true);
        //Datos que se guardan cuando se inicia la sesion en el index correctamente y ejecuta el CRUD
        sesion.removeAttribute("usuarioL");
        sesion.removeAttribute("nombreL");
        //Cerrar sesion
        sesion.invalidate();

        //Redirecciono a index.jsp
        request.getRequestDispatcher("index.jsp").forward(request,response);

    }

}
