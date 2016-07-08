<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Iterator"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="com.ebanque.beans.*" %>
<%
	User user = (User) request.getSession().getAttribute("user");
	if(user == null)
	{
		response.sendRedirect("/e-banque/index");
	}
%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Accueil-Admin</title>
<link href="../assets/css/bootstrap.min.css" rel="stylesheet">
<link href="../assets/css/style.css" rel="stylesheet">
</head>
<body>

<jsp:include page="menu.jsp"></jsp:include>

<%
	List<User> admins = new ArrayList<User>();
	admins = (ArrayList<User>) request.getAttribute("admins");
	if(admins==null){
        
        %>
			<div class="conatiner">
			<div class="alert alert-danger">
			<a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
				<strong>Error!</strong> <%out.println("Vide"); %>!
		
			</div>
			</div>
       <%
    }else{
    	%>
    	<div class="col-md-12">
    	<h1 class="page-header">Liste des administrateurs</h1>
				<div class="table-responsive">
					<table class="table  table-bordered table-striped table-condensed" id="mytable">
			  			<thead>
					      <tr class="active info">  
					        <th>Nom</th>
					        <th>Prenom</th>
					        <th>Login</th>
					        <th>Adresse</th>	        	
						    </tr>
				   		</thead> 
				   		<tbody >
    	
    	
    	<%
    	
    	for(Iterator<User> it = admins.iterator(); it.hasNext();){
            User admin = it.next();
            out.println("<tr>");
            out.println("<td>"+admin.getNom()+"</td>");
            out.println("<td>"+admin.getPrenom()+"</td>");
            out.println("<td>"+admin.getLogin()+"</td>");
            out.println("<td>"+admin.getAdresse()+"</td>");
            out.println("</tr>");
            
        }
    	%>
    		
	  </tbody>
		</table>
		</div>	
		</div>
    	
    	<%
    
    }
%>

<%------------------------------------------- liste des clients--%>
<%
	List<User> clients = new ArrayList<User>();
	clients = (ArrayList<User>) request.getAttribute("clients");
	if(clients==null){
        
        %>
			<div class="conatiner">
			<div class="alert alert-danger">
			<a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
				<strong>Error!</strong> <%out.println("Aucun client"); %>!
		
			</div>
			</div>
       <%
    }else{
    	%>
    	<div class="col-md-12">
    	<h1 class="page-header">Liste des clients</h1>
				<div class="table-responsive">
					<table class="table  table-bordered table-striped table-condensed" id="mytable">
			  			<thead>
					      <tr class="active info">  
					        <th>Nom</th>
					        <th>Prenom</th>
					        <th>Login</th>
					        <th>Adresse</th>	        	
						    </tr>
				   		</thead> 
				   		<tbody >
    	
    	
    	<%
    	
    	for(Iterator<User> it = clients.iterator(); it.hasNext();){
            User client = it.next();
            out.println("<tr>");
            out.println("<td>"+client.getNom()+"</td>");
            out.println("<td>"+client.getPrenom()+"</td>");
            out.println("<td>"+client.getLogin()+"</td>");
            out.println("<td>"+client.getAdresse()+"</td>");
            out.println("</tr>");
            
        }
    	%>
    		
	  </tbody>
		</table>
		</div>	
		</div>
    	
    	<%
    
    }
%>



<script src="../assets/js/jquery.js"></script>
<script src="../assets/js/bootstrap.min.js"></script>

</body>
</html>