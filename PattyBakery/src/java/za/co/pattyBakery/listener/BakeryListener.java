package za.co.pattyBakery.listener;

import java.sql.Connection;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import za.co.pattyBakery.database.DatabaseConnect;

/**
 *
 * @author Dimakatso Sebatane
 */
public class BakeryListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ServletContext context = sce.getServletContext();
        Connection con = DatabaseConnect.getInstance().getConnection();
        context.setAttribute("con", con);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
