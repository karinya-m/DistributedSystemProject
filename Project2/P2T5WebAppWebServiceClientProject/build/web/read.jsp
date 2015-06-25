<%-- 
    Document   : read
    Created on : Oct 12, 2012, 7:23:22 PM
    Author     : Karinya
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Project2 Task5 Read Operation</title>
    </head>
    <body> 
        <form action="readServlet" method="GET">    
            <label for="studentID">Please enter student ID. </label><input type="text" name="studentID" value="" /><br>
            <input type="submit" value="Submit" />        
        </form>
    </body>
</html>
