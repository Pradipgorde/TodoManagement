<%@page  import="Project.ProjectBean , java.util.*,login.LoginBean"  %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Project Details</title>


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

p{

color:yellow;
text-align:right;
padding-right:50px;


}

h2{

color:yellow;
text-align:left;


}
.c5{

margin:auto;
height:auto;
weight:80%;
background-color:grey;


}


</style>

<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.min.css">

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">

</head>
<body>
<a></a>
<% LoginBean ab = (LoginBean) session.getAttribute("adminlog");

String msg = (String) request.getAttribute("msg");
 %>
 
<div class="c5">  
<br>
 <p> <% out.println("Login User:-"+ab.getName()); %> </p>

<h2> <%  out.println(msg); %>  </h2>
 
 </div>

 <a  href="logout"> logOut </a>

<% 

out.println(" <a href='proj?email="+ab.getEmail()+"' > <button >Create new project </button>  </a>");
%>
<table> 



<caption> List of Project  </caption>
<tr>
<th> ID</th>
<th>Name</th>
<th> View Project</th>
</tr>
 
 <%  ArrayList<ProjectBean> list = (ArrayList<ProjectBean>) request.getAttribute("project");
 
 if(list!=null)
 {
       Iterator<ProjectBean> it=list.iterator();
      
      while(it.hasNext())
      {
    	  ProjectBean pb = (ProjectBean) it.next();
      
 %>
 
 <tr> 
 <td> <% out.println(pb.getProjectId());  %> </td>
    	   <td> <% out.println(pb.getProjectTitle()); %> </td>
            <td> <% out.println(" <a href='view?Pid="+pb.getProjectId()+"' > View </a> &nbsp; &nbsp; ");%> </td>    
 </tr>
<% } }else {out.println("  Project is Empty create new project ");}  %>
  


 </table>



<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>


</body>
</html>