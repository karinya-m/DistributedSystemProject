/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package p2t3webapplicationclientproject;

import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigInteger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.WebServiceRef;
import p2t2webserviceproject.BookTripWebService_Service;

/**
 *
 * @author Karinya
 */
@WebServlet(name = "BookTripServlet", urlPatterns = {"/BookTripServlet"})
public class BookTripServlet extends HttpServlet {

    @WebServiceRef(wsdlLocation = "WEB-INF/wsdl/localhost_8080/P2T2WebServiceProject/BookTripWebService.wsdl")
    private BookTripWebService_Service service;


    /*
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Check valid inputs
        if (!IsInteger(request.getParameter("hotelID")) || !IsInteger(request.getParameter("rooms_num"))
                || !IsInteger(request.getParameter("carID")) || !IsInteger(request.getParameter("cars_num"))
                || !IsInteger(request.getParameter("planeID")) || !IsInteger(request.getParameter("seats_num"))) {
            request.setAttribute("bookResult", "You must enter valid values");
        } else {
            // Create objects of BigInteger class to store input values.
            int intHotelID = Integer.parseInt(request.getParameter("hotelID"));
            int intRooms_num = Integer.parseInt(request.getParameter("rooms_num"));

            int intCarID = Integer.parseInt(request.getParameter("carID"));
            int intCars_num = Integer.parseInt(request.getParameter("cars_num"));

            int intPlaneID = Integer.parseInt(request.getParameter("planeID"));
            int intSeats_num = Integer.parseInt(request.getParameter("seats_num"));

//set result message
            if (bookTrip(intHotelID, intRooms_num, intCarID, intCars_num, intPlaneID, intSeats_num)) {
                request.setAttribute("bookResult", "Trip booked");
            } else {
                request.setAttribute("bookResult", "Trip cannot be booked. One or more constrains are violated");
            }
        }
        RequestDispatcher view = request.getRequestDispatcher("index.jsp");
        view.forward(request, response);
    }

    /**
     *
     * Check if the string input is an integer
     *
     * @param input string to be checked if it is integer
     * @return true if the input string is an integer
     */
    public boolean IsInteger(String input) {
        try {
            Integer.parseInt(input);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    /**
     *
     * bookTrip method from web service
     *
     * @return true if successfully booked
     */
    private boolean bookTrip(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5) {
        p2t2webserviceproject.BookTripWebService port = service.getBookTripWebServicePort();
        return port.bookTrip(arg0, arg1, arg2, arg3, arg4, arg5);
    }
}
