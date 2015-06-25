/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigInteger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Karinya
 */
@WebServlet(name = "BigCalc", urlPatterns = {"/BigCalc"})
public class BigCalc extends HttpServlet {

    /**
     * Processes requests for both HTTP
     * <code>GET</code> and
     * <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            /* TODO output your page here. You may use following sample code. */
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet BigCalc</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet BigCalc at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        } finally {            
            out.close();
        }
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

        response.setContentType("text/html;charset=UTF-8");
        // Create a writer for Http servlet response
        PrintWriter out = response.getWriter();
        // Read parameters from user inputs.
        String opr = request.getParameter("operation");
        // Validate the user input. Both inputs should be integers.
        if (!IsInteger(request.getParameter("x")) || !IsInteger(request.getParameter("y"))) {
            out.println("You must enter valid values for both parameters");
        } 
        else {
            int x = Integer.parseInt(request.getParameter("x"));
            int y = Integer.parseInt(request.getParameter("y"));
            
            // Create objects of BigInteger class to store input values.
            BigInteger bigX = new BigInteger(request.getParameter("x"));
            BigInteger bigY = new BigInteger(request.getParameter("y"));
            // Check an input operation and compute a result accordingly
            if (opr.equals("add")) {
                out.println(bigX + " + " + bigY + " = " + bigX.add(bigY));
            } 
            else if (opr.equals("multiply")) {
                out.println(bigX + " x " + bigY + " = " + bigX.multiply(bigY));
            } 
            else if (opr.equals("relativelyPrime")) {
                // If gcd of two integers are one, then the two integers are relatively prime.
                if (bigX.gcd(bigY).intValue() == 1) {
                    out.println(bigX + " and " + bigY + " are relatively prime.");
                } else {
                    out.println(bigX + " and " + bigY + " are not relatively prime.");
                }
            }
            else if (opr.equals("mod")) {
                out.println(bigX + " mod " + bigY + " = " + bigX.mod(bigY));
            }
            else if (opr.equals("modInverse")) {
                out.println(bigX + " modInverse " + bigY + " = " + bigX.modInverse(bigY));
            }
            else if (opr.equals("power")) {
                out.println(bigX + " to the power of " + bigY + " = " + Math.pow(x,y));
            }
            
        }
    }

    // Checks if the input is an integer.
    // return true, if it is an integer. 
    // return false otherwise
    public boolean IsInteger(String input) {
        try {
            Integer.parseInt(input);
        } catch (Exception e) {
            return false;
        }
        return true;
    }
}
