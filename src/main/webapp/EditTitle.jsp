<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<%
String pid = (String) request.getParameter("pid");
  %>
    <form action="title" method="post">
   
   <br> 
   <%  out.println(" Project Id:"+pid);                 %>
   <input type="hidden" name="pid" value=<%=pid %> > <br><br>
   Enter Title:  <input type="text" name="title"><br>
     
     <button type="submit" value="update"> Update </button>
 




</body>
</html>