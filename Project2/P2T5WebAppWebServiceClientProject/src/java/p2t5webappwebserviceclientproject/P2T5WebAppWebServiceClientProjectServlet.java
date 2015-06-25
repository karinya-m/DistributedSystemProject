/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package p2t5webappwebserviceclientproject;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Karinya
 */
@WebServlet(name = "P2T5WebAppWebServiceClientProject", urlPatterns = {"/P2T5WebAppWebServiceClientProject"})
public class P2T5WebAppWebServiceClientProjectServlet extends HttpServlet {
            

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        RequestDispatcher view = null;
        // Read parameters from user inputs.
        String opr = request.getParameter("operation");
        if (opr == null) {
            view = request.getRequestDispatcher("index.jsp");
        } else {
            if (opr.equals("create")) {
                view = request.getRequestDispatcher("create.jsp");
            } else if (opr.equals("read")) {
                view = request.getRequestDispatcher("read.jsp");
            } else if (opr.equals("update")) {
                view = request.getRequestDispatcher("update.jsp");
            } else if (opr.equals("delete")) {
                view = request.getRequestDispatcher("delete.jsp");
            }
        }
        view.forward(request, response);

 



    }

}
