<%-- 
    Document   : create
    Created on : Oct 12, 2012, 7:23:04 PM
    Author     : Karinya
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
      <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Project2 Task5 Create Operation</title>
    </head>
    <body> 
        <form action="createServlet" method="GET">    
            <label for="studentID">Please enter student ID. </label><input type="text" name="studentID" value="" /><br>
            <label for="studentName">Please enter student name. </label><input type="text" name="studentName" value="" /><br>
            <label for="scholarship">Please enter scholarship amount. </label><input type="text" name="scholarship" value="" /><br>
            <input type="submit" value="Submit" />        
        </form>
    </body>
</html>
