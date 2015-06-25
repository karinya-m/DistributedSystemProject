<%-- 
    Document   : index
    Created on : Sep 20, 2012, 3:37:49 PM
    Author     : Karinya
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Project1 Task1</title>
    </head>
    <body>
        <p>Give me a word, and I'll give you a hashed word.</p>
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
