<%-- 
    Document   : index
    Created on : Oct 12, 2012, 5:53:24 AM
    Author     : Karinya
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Project2 Task5</title>
    </head>
    <body>
        <% if (request.getAttribute("result") != null) {
                out.print(request.getAttribute("result"));
                out.print("<br><br>");
            }%> 
        <p>Please enter numbers and select operation.</p>
        <form action="P2T5WebAppWebServiceClientProject" method="GET">

            <br>
            <select name="operation">          
                <option value="create">   
                    Create
                </option>   
                <option value="read"> 
                    Read 
                </option>
                <option value="update"> 
                    Update
                </option>
                <option value="delete"> 
                    Delete
                </option>
            </select>
            <br>
            <br>
            <input type="submit" value="Submit" />
        </form>
    </body>
</html>
