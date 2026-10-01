package ec.edu.epn.objetos.controlador;

import ec.edu.epn.objetos.dao.JPAUtil;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;

/**
 * Cierra la conexión con la base de datos cuando la aplicación se detiene.
 */
@WebListener
public class CierreJPAListener implements ServletContextListener {

    @Override
    public void contextDestroyed(ServletContextEvent evento) {
        JPAUtil.cerrar();
    }
}
