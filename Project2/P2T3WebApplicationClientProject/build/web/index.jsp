<%-- 
    Document   : index
    Created on : Oct 11, 2012, 4:50:47 AM
    Author     : Karinya
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Project2 Task3</title>
    </head>
    <body>
        <% if (request.getAttribute("bookResult") != null) {
                out.print(request.getAttribute("bookResult"));
                out.print("<br><br>");
            }%> 

        <h1>Book Trip</h1>
        <form action="BookTripServlet" method="GET">    
            <label for="hotelID">Please enter hotel ID. </label><input type="text" name="hotelID" value="" /><br>
            <label for="rooms_num">Please enter number of rooms. </label><input type="text" name="rooms_num" value="" /><br><br>

            <label for="carID">Please enter car rental ID. </label><input type="text" name="carID" value="" /><br>
            <label for="cars_num">Please enter number of cars. </label><input type="text" name="cars_num" value="" /><br><br>

            <label for="planeID">Please enter airline ID. </label><input type="text" name="planeID" value="" /><br>
            <label for="seats_num">Please enter number of seats. </label><input type="text" name="seats_num" value="" /><br><br>

            <input type="submit" value="Submit" />        
        </form>
    </body>
</html>
