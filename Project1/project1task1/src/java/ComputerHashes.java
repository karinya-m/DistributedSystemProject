/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import java.util.logging.Level;
import sun.misc.BASE64Encoder;

/**
 *
 * @author Karinya
 */
@WebServlet(name = "ComputerHashes", urlPatterns = {"/ComputerHashes"})
public class ComputerHashes extends HttpServlet {

    //From the website "Real's How To"
    //Get the hexadecimal notation of the string
    public String getHexString(byte[] b) throws Exception {
        String result = "";
        for (int i = 0; i < b.length; i++) {
            result += Integer.toString((b[i] & 0xff) + 0x100, 16).substring(1).toUpperCase();
        }
        return result;
    }
    
    //Get a hash value according to hash function specified in the argument.
    public byte[] hash(String text, String hashFunction)
            throws NoSuchAlgorithmException, UnsupportedEncodingException {
        MessageDigest m = MessageDigest.getInstance(hashFunction);
        m.update(text.getBytes(), 0, text.length());
        return m.digest();
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
      //  processRequest(request, response);
        
        // get the search parameter if it exists
        String word = request.getParameter("word");
        String hashResultHex = null;
        String hashResultBase64 = null;
        BASE64Encoder base64Encoder = new BASE64Encoder();

        // see if word parameter is present
        if(word != null && word != "") {
            String hashFunction = request.getParameter("hashFunc");
            if(hashFunction != null){
                try{   
                hashResultHex = getHexString(hash(word, hashFunction));    
                hashResultBase64 = base64Encoder.encode(hash(word, hashFunction)); 
                }
                catch(Exception ex){
                   Logger.getLogger(ComputerHashes.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
 
            request.setAttribute("word", word);           
            request.setAttribute("hashFunc", hashFunction);
            request.setAttribute("hashedWordHex", hashResultHex);
            request.setAttribute("hashedWordBase64", hashResultBase64);
            
            RequestDispatcher view = request.getRequestDispatcher("hashResult.jsp");
            view.forward(request, response);
        }
        else {
            // no search parameter so choose the prompt view
            RequestDispatcher view = request.getRequestDispatcher("index.jsp");
            view.forward(request, response);
        }
    }


}
