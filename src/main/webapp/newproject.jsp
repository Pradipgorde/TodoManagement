<%@ page import="login.LoginBean"  language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>


<!DOCTYPE html>
<html lang="en">
<head>
<title>Registration page</title>

<style>
p{

color:yellow;
text-align:right;
padding-right:50px;


}
</style>

<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.min.css">

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">


</head>
<body class=" bg-dark">
	
	<%   String mail = (String) request.getAttribute("email");    
	LoginBean ab = (LoginBean) session.getAttribute("adminlog");
	
	%>
	 <p> <% out.println(" User:-"+ab.getName()); %> </p>
	
<div class="container-fluid d-flex justify-content-center align-items-center " style="height:500px">
	 
	  
	<form class=" bg-warning m-4 w-75 p-4 border border-primary border-3 rounded-4"  action="newproj" method="post" >
 
  <h1 class="bi bi-person"> Project Create Page</h1>
       
        <input type="hidden" name="mail" value=<%=mail %> > <br><br>
       <label class=""> Enter Project id</label>
         <input class=" " type="text" placeholder="Unique Id" name="pid"> 
         
       <label class=""> Enter Project title</label>
         <input class="" type="text" placeholder="Name" name="title"> 
        
         <button class="" type="submit" value="display">create Project </button>
       
      
     
	</form>
   	
	
</div>





<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>

	

</body>
</html>