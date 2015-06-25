<%-- 
    Document   : index
    Created on : Sep 21, 2012, 12:51:46 AM
    Author     : Karinya
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%     
String ua = request.getHeader("User-Agent");
        boolean mobile;
        // prepare the appropriate DOCTYPE for the view pages
        if (ua != null && ua.indexOf("Android") != -1) {
            mobile = true;
            request.setAttribute("doctype", "<!DOCTYPE html PUBLIC \"-//WAPFORUM//DTD XHTML Mobile 1.0//EN\" \"http://www.wapforum.org/DTD/xhtml-mobile10.dtd\">");
        } else {
            mobile = false;
            request.setAttribute("doctype", "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">");
        }
%>
<%= request.getAttribute("doctype") %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Project1 Task3</title>
    </head>
    <body>
         <form action="Palin" method="GET">
        <label for="letter">Please type the word.</label><br>
            <input type="text" name="word" value="" /><br>
            <input type="submit" value="Submit" />
         </form>
    </body>
</html>
