package es.uned.master.java.registrodeusuarios.controlador;
/**
 * @author: Irina Medina Sierra
 * @version: 15/06/2022
 * @Description:  Este servlet realiza el llamado a la Clase UserDAO para VALIDAR los datos introducidos en el
 * index.jsp utilizando el método POST
 */
import es.uned.master.java.registrodeusuarios.modelo.*;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "Controlador", value = "/Controlador")

public class Controlador extends HttpServlet {
    private static final long serialVersionUID = 1L;
    UserDAO dao = new UserDAO();
    Usuario u = new Usuario();
    int r;
    DepartamentoDAO d = new DepartamentoDAO();
    EstadoDeLaCuentaDAO c = new EstadoDeLaCuentaDAO();
    Paginacion p=new Paginacion();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //Si el usuario entra, se lee los datos de usuario y password para enviarlo a la interfaz validar
        String user = request.getParameter("user");
        String pass = request.getParameter("pass");
        u.setUsuario(user);
        u.setPassword(pass);
        r = dao.validar(u);

        //dao.validar nos devuelve un valor 0, para indicar que el usuario no existe y 1 nos lleva al CRUD
        if (r == 1) {
            String nombre = "Usuario: " + u.getNombre();
            request.getSession().setAttribute("usuarioL", user);
            request.getSession().setAttribute("nombreL", nombre);
            System.out.println(request.getRequestedSessionId());
            listarCRUD(request, response);
        } else {
            String errores = " &#10140; Existe un error en el usuario o en la contraseña. Verifique sus datos";
            request.getSession().setAttribute("error", errores);
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }
    }

    private void listarCRUD(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //System.out.println("llega aqui");
        List<Usuario> listUser = dao.listar();
        int nRegistros=listUser.size();
        System.out.println(nRegistros);
        int nPaginas=(nRegistros/10)+1;
        List<Paginacion> listPag =  new ArrayList<>();
        int pag=0,fin=0;
        int comienzo=0;
        for (int i=1;i<=nPaginas;i++){
            if(i==1){
                comienzo= 1;
                fin=comienzo*10;
                pag=i;
            }else{
                comienzo=fin+1;
                fin=comienzo+9;
                pag=i;
            }
            p.setComienzo(comienzo);
            p.setFin(fin);
            p.setPagina(pag);
            System.out.println(pag+"-"+comienzo+"-"+fin);
            listPag.add(p);

        }
        request.setAttribute("listPag",listPag);
        request.setAttribute("listUser", listUser);
        request.getRequestDispatcher("restringido/crudClientes.jsp").forward(request, response);
    }


}
