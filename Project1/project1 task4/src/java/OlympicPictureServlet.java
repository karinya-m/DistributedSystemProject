/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

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
@WebServlet(name = "OlympicPicture", urlPatterns = {"/OlympicPictureServlet"})
public class OlympicPictureServlet extends HttpServlet {

      OlympicPictureModel ipm = null;

    @Override
    public void init() {
        ipm = new OlympicPictureModel();
    }
    
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

        // get the search parameter if it exists
        String search = request.getParameter("searchSport");
        

        // see if search parameter is present
        if(search != null && search != "") {
                 // use model to do the search and choose the result view
                 ipm.doOlympicPictureSearch(search);
                 request.setAttribute("pictureTag", ipm.getPictureTag());
                 request.setAttribute("pictureURL",ipm.getPictureURL());
                 RequestDispatcher view = request.getRequestDispatcher("OlympicPictureResult.jsp");
                 view.forward(request, response);
        }
        else {
            // no search parameter so choose the prompt view
            RequestDispatcher view = request.getRequestDispatcher("prompt.jsp");
            view.forward(request, response);
      }
    }
}
