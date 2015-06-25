<%-- 
    Document   : prompt
    Created on : Sep 21, 2012, 4:52:17 AM
    Author     : Karinya
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Project1 Task4</title>
    </head>
    <body>
       <p>Please select a sport and I'll give you a picture.</p>
        <form action="OlympicPictureServlet" method="GET">
            <label for="letter">Sport: </label>           
            <select name="searchSport">              
                <option selected="selected" value = "">
                    Select a sport...
                </option> 
                <option value="swimming">   
                    swimming
                </option>   
                <option value="football"> 
                    football 
                </option>
                <option value="weightlifting"> 
                    weightlifting 
                </option>
                <option value="boxing"> 
                    boxing
                </option>
                 <option value="tennis"> 
                    tennis
                </option>
                <option value="taekwondo"> 
                    taekwondo
                </option>     
                <option value="triathlon">   
                    triathlon
                </option>   
                <option value="volleyball"> 
                    volleyball
                </option>
                <option value="basketball"> 
                    basketball
                </option>
                <option value="archery"> 
                    archery
                </option>
                 <option value="judo"> 
                    judo
                </option>
                <option value="hockey"> 
                    hockey
                </option>
            </select><br>
            
            <input type="submit" value="Submit" />
        </form>
    </body>
</html>
