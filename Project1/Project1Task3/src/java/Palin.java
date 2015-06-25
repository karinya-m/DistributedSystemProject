/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Karinya
 */
@WebServlet(name = "Palin", urlPatterns = {"/Palin"})
public class Palin extends HttpServlet {

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
            out.println("<title>Servlet Palin</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Palin at " + request.getContextPath() + "</h1>");
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
        // determine what type of device our user is
  
        // Create a writer for Http servlet response
        PrintWriter out = response.getWriter();
        // Read an input from the textfield
        String input = request.getParameter("word");
        //display if it is palindrome
        if(isPalindrome(input)){
            out.println(input + " is a palindrome.");
        }
        else{
            out.println(input + " is not a palindrome.");
        }
    }

    //Check if the "word" argument is palindrome  
    public boolean isPalindrome(String word) {
        //If word is empty or only 1 char, it is palindrome
        if (word.length() == 0 || word.length() == 1) {
            return true;
        } 
        //remove whitespace, punctuation and change to lower case
        String plainWord = word.toLowerCase().replaceAll("\\W", "");
        
        //Indexes from the left and right sides of the word
        int leftIndex = 0;                
        int rightIndex = plainWord.length() - 1;  

        //Continue until both indexes reach the center
        while (leftIndex < rightIndex) {         
            //If chars are different, the word is not palindrome
            if (plainWord.charAt(leftIndex) != plainWord.charAt(rightIndex)) {
                return false;          
            }
            //move both indexes to the center
            leftIndex++;                    
            rightIndex--;                  
        }
        //All characters are the same, the word is palindrome
        return true;                   
    }
}

