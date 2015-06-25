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
@WebServlet(name = "createServlet", urlPatterns = {"/createServlet"})
public class CreateServlet extends HttpServlet {

  

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
               
       Short studentID = Short.parseShort(request.getParameter("studentID"));
       String stduentName = request.getParameter("studentName");
       Double scholarship = Double.parseDouble(request.getParameter("scholarship"));
       
       if(P2T5WebAppWebServiceClientProjectModel.createStudent(studentID, stduentName, scholarship)){
           request.setAttribute("result", "Student record is created.");
       } else {
           request.setAttribute("result", "Fail to create student record");
       }
           
       RequestDispatcher view = request.getRequestDispatcher("index.jsp");
       view.forward(request, response);
    }

  
}
