<?xml version="1.0" encoding="ISO-8859-1"?> 
<%@ page contentType="text/xml;charset=ISO-8859-1" %> 

<getAgeResponse>
   <Age><%= request.getAttribute("age")%></Age>
   <Result><%= request.getAttribute("result")%></Result>
</getAgeResponse>