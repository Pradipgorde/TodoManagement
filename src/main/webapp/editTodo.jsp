<%@ page   import="todo.TodoBean, java.util.*" language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>


 <%
 
 ArrayList<TodoBean> list = (ArrayList<TodoBean>) session.getAttribute("todo");
 
 String tid = (String) request.getParameter("tid");
 
    Iterator<TodoBean> it= list.iterator();    
     
        while(it.hasNext())
        {
        	TodoBean pb = (TodoBean)it.next();
        	if(pb.getTodo_id().equals(tid))
        	{
   %>
    <form action="update" method="post">
   
   <br> 
   Todo Code:  <%out.println("<span> "+pb.getTodo_id()+"</span>"); %> <br><br>
   <input type="hidden" name="tid" value=<%=pb.getTodo_id() %> > <br><br>
   <input type="hidden" name="pid" value=<%=pb.getProjectId() %> > <br><br>   
    Todo Desc: <input type="text" name="desc" value=<%=pb.getDescption() %> ><br><br>
      Todo Completed: <input type="checkbox" name="status" value="completed"><br><br>
      Todo Pending: <input type="checkbox" name="status" value="pending"><br><br>
     
     <button type="submit" value="update"> Update </button>
 
 <%}
        } %>
 

</body>
</html>