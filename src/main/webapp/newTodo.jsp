+<%@ page import="login.LoginBean " language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<%

LoginBean ab = (LoginBean) session.getAttribute("adminlog");


String pid = (String) request.getAttribute("Pid");    

%>

<h2> Create Todo </h2>

<form action="newtodo" method="post">

<h2>  <%  out.println(pid); %>  </h2>
 <input type="hidden" name="pid1" value=<%=pid %> > <br><br>
 
 Enter Todo Id: <input type="text" name="tid"> <br> <br>
 Enter Todo DEsc: <input type="text" name="desc"><br> <br>
 Status Complete <input type="checkbox" name="status" value="completed"> <br> <br>
 Status Pending <input type="checkbox" name="status" value="pending"><br> <br>
 
 <button type="submit" value="display">Submit</button>



</form>





</body>
</html>