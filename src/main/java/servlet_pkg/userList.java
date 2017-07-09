/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet_pkg;

import DAO.sprUsersDAO;
import DAO.tIncidentDAO;
import beans.TIncident;
import beans.TSprUsers;
import interfaces.HibernateUtil;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.naming.NamingException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.HttpMethodConstraint;
import javax.servlet.annotation.ServletSecurity;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.hibernate.Session;

/**
 *
 * @author vasil
 *
 */
@WebServlet(name = "userList", urlPatterns = {"/userList"})
@ServletSecurity(httpMethodConstraints = {
    @HttpMethodConstraint(value = "GET", rolesAllowed = "Admin")
    ,
    @HttpMethodConstraint(value = "POST", rolesAllowed = "Admin")
})
public class userList extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    private Logger log = Logger.getLogger(getClass().getName());
    private Session session1;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config); //To change body of generated methods, choose Tools | Templates.
        session1 = HibernateUtil.getSessionFactory().openSession();
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, NamingException, SQLException {

        //InitialContext initContext = new InitialContext();
        //DataSource dataSource = (DataSource) initContext.lookup("java:/helpDeskDS");
        //Connection conn = dataSource.getConnection();
        //log.info(dataSource.toString());
        log.info("servlet begin");
        List<TSprUsers> userList = (new sprUsersDAO(this.session1)).getList();
        List<TIncident> incidentList = (new tIncidentDAO(session1)).getList();
        request.setAttribute("list", userList);
        request.setAttribute("incidentList", incidentList);
        getServletContext().getRequestDispatcher("/jsp/admin/userList.jsp").forward(request, response);
//        List<TSprUsers> userList = (new sprUsersDAO(this.session1)).getList();
//        response.setContentType("text/html;charset=UTF-8");
//        try (PrintWriter out = response.getWriter()) {
//            userList.forEach((item) -> {
//                out.println("" + item.getFName());
//            });
//
//            out.println("<!DOCTYPE html>");
//            out.println("<html>");
//            out.println("<head>");
//            out.println("<title>Servlet userList</title>");
//            out.println("</head>");
//            out.println("<body>");
//            int count = 1;
//
//            /* TODO output your page here. You may use following sample code. */
//            out.println("<h1>Servlet userList at " + request.getContextPath() + "</h1>");
//            out.println("</body>");
//            out.println("</html>");
    }

// <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);

        } catch (NamingException ex) {
            Logger.getLogger(userList.class
                    .getName()).log(Level.SEVERE, null, ex);

        } catch (SQLException ex) {
            Logger.getLogger(userList.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);

        } catch (NamingException ex) {
            Logger.getLogger(userList.class
                    .getName()).log(Level.SEVERE, null, ex);

        } catch (SQLException ex) {
            Logger.getLogger(userList.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
