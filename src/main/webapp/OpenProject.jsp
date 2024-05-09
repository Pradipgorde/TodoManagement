<%@ page  import="login.LoginBean, Project.ProjectBean, todo.TodoBean, java.util.*"   language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>


table{

  border: 1 px solid;
  width:2px;
  background-color:antiquewhite;
  margin:auto;
  text-align:center;
  width:60%;
  
  

}
div{
    background-color: grey;
    width:80%;
    height:60%;
    text-align:center;
    margin:auto;
}
th{

border:1px solid;

}
td{
border:1px solid;

}
h1{
  
   color:red;
   background-color:aqua;
   text-align:center;
   text-font:bold;
 }
 
 caption{
  
  background-color:aqua;
  color:red;
  height:25px;
  text-align:center;
  font-weight:bold;
   
 }




.c5{

margin:auto;
height:auto;
weight:80%;
background-color:grey;


}


</style>


</head>
<body>

<%

LoginBean ab = (LoginBean) session.getAttribute("adminlog");
ProjectBean pb = (ProjectBean) request.getAttribute("projectopen");

String msg = (String) request.getAttribute("msg");




%>
<h2> <%  if(msg!=null)   out.println(msg); %>  </h2>
<h2> <% out.println(pb.getProjectId());   %>  </h2>

<div class="c5">  
  
  
<br>
 <p> <% out.println("Login User:-"+ab.getName()); %> </p>

<h2> <%  out.println("Project Title:"+pb.getProjectTitle() +"<a href='ptitle?pid="+pb.getProjectId()+"' > Edit </a>");    %>  </h2>
<h2> <%  out.println("Created On:"+pb.getDate());    %>  </h2>


 
 </div>
 <a  href="logout"> logOut </a>




<h5> <%  out.println("Todo  List  Summary: "+   pb.getComplted_todo()+" / "  +pb.getList_of_TODO()); %>  </h5>

<button> <%  out.println("<a href='todo?pid="+pb.getProjectId()+"' > Create new Todo </a>");    %>  </button>



<table>
<caption> Todo List </caption> 

<tr> 
 <th> Todo id </th> 
 <th> Todo Desc </th> 
 <th> Todo createdOn </th>
 <th> Todo updateOn </th>
 <th> Status </th>
 <th> Update/Delete </th>
 <th> mark as Completed</th>
 <tr> 
 
 <% ArrayList<TodoBean> list = (ArrayList<TodoBean>) session.getAttribute("todo"); 
      
   if(list==null)
   {
	   out.println("No Todo Available ");
   }
   else{
    
     Iterator<TodoBean> it = list.iterator();
     
     while(it.hasNext())
     {
    	   TodoBean td =  it.next();
    	   
    	   %> 
    	   
    	   <tr> 
    	   <td> <% out.println(td.getTodo_id());  %> </td>
    	   <td> <% out.println(td.getDescption()); %> </td>
    	   <td> <% out.println(td.getCreateOn()); %> </td>
           <td> <% out.println(td.getUpdate()); %> </td>
           <td> <% out.println(td.getStatus()); %></td>
           <td> <% out.println(" <a href='edit?tid="+td.getTodo_id()+"' > Edit </a> &nbsp; &nbsp; <a href='delete?tid="+td.getTodo_id()+"'>Delete</a>");%>  	  
    	   <td style="display:inline">  <form style="display:inline" action="commit" method="post"> <input type="checkbox" name="check1" value="completed">
    	   <input type="submit" value="submit">  </form> </td>
    	   
    	 <% 	 
        }
     
     
     
     
     
   }
     
 %>

 


</table> <br> <br> <br>

  












</body>
</html>