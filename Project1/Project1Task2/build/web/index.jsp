<%-- 
    Document   : index
    Created on : Sep 20, 2012, 11:19:02 PM
    Author     : Karinya
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Project1 Task2</title>
    </head>
    <body>
        <p>Please enter numbers and select operation.</p>
        <form action="BigCalc" method="GET">
            <label for="letter">x = </label>
            <input type="text" name="x" value="" /><br>
            <label for="letter">y = </label>
            <input type="text" name="y" value="" /><br>

            <select name="operation">          
                <option value="add" selected="selected">   
                    Add
                </option>   
                <option value="multiply"> 
                    Multiply 
                </option>
                <option value="relativelyPrime"> 
                    Relatively Prime 
                </option>
                <option value="mod"> 
                    Mod 
                </option>
                 <option value="modInverse"> 
                    Mod Inverse 
                </option>
                <option value="power"> 
                    Power 
                </option>
            </select><br>
            
            <input type="submit" value="Submit" />
        </form>
    </body>
</html>
