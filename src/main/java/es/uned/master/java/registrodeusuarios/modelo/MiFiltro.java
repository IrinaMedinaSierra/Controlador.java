package es.uned.master.java.registrodeusuarios.modelo;
/**
 * @author: Irina Medina Sierra
 * @version: 15/06/2022
 * @Description:  La clase Filter para crear el control de sesiones en la aplicación
 Te pillé sin documentación!!!! offfffff

 */

        import java.io.IOException;
        import javax.servlet.Filter;
        import javax.servlet.FilterChain;
        import javax.servlet.FilterConfig;
        import javax.servlet.ServletException;
        import javax.servlet.ServletRequest;
        import javax.servlet.ServletResponse;
        import javax.servlet.http.*;

public class MiFiltro implements Filter {

    public void destroy() {
        // TODO Auto-generated method stub

    }

    // Esta filtro gestionará la sesión iniada
    // Para ello debe garantizarse que la sesión ha sido previamente iniciada.
    // Por eso gestionamos de la sesión "usuarioL" como objeto de sesión a incluir en el sesión.
    public void doFilter(ServletRequest request, ServletResponse response,
                         FilterChain chain) throws IOException, ServletException {
        // TODO Auto-generated method stub
        // Antes valido si es un HttpServlequest
        // Pero que chapuza es esta?????????
        // Try catch...como dios manda Irina
        if (request instanceof HttpServletRequest){
            // El objeto sessión que solicito del request
            HttpSession sesion = (HttpSession) ((HttpServletRequest) request).getSession();
            if (sesion.isNew())
                //verifico
                ((HttpServletResponse)response).sendRedirect("index.jsp");
            } else {
                // Que siga con el siguiente filtro u serlvet
                chain.doFilter(request,response);
            }
        }

    public void init(FilterConfig arg0) throws ServletException {
        // TODO Auto-generated method stub

    }
}

