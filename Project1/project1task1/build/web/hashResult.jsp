<%-- 
    Document   : hashResult
    Created on : Sep 20, 2012, 8:28:55 PM
    Author     : Karinya
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
<body>
        <h1>The <%= request.getAttribute("hashFunc")%> hash of <%= request.getAttribute("word")%></h1>
        <p>Hex : <%= request.getAttribute("hashedWordHex")%></p>
        <p>Base 64 : <%= request.getAttribute("hashedWordBase64")%></p>
         <form action="ComputerHashes" method="GET">
            <label for="letter">Please choose hash functions.</label><br>
            <input TYPE="radio" NAME="hashFunc" VALUE="MD5" CHECKED>MD5<BR>
            <INPUT TYPE="radio" NAME="hashFunc" VALUE="SHA-1">SHA-1<BR>
            <br>
            <label for="letter">Please type the word.</label><br>
            <input type="text" name="word" value="" /><br>
            <input type="submit" value="Submit" />
        </form>
    </body>
</html>
