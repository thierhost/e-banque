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
<title>Accueil-Client</title>
<link href="../assets/css/bootstrap.min.css" rel="stylesheet">
<link href="../assets/css/style.css" rel="stylesheet">
</head>
<body>

<jsp:include page="menu.jsp"></jsp:include>
<%
	List<Compte> mescomptes = new ArrayList<Compte>();
	mescomptes = (ArrayList<Compte>) request.getAttribute("mescomptes");
	if(mescomptes==null){
        
        %>
			<div class="conatiner">
			<div class="alert alert-danger">
			<a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
				<strong>Error!</strong> <%out.println("Aucun compte"); %>!
		
			</div>
			</div>
       <%
    }else{
    	%>
    	<div class="col-md-12">
    	<h1 class="page-header">Mes comptes bancaires</h1>
				<div class="table-responsive">
					<table class="table  table-bordered table-striped table-condensed" id="mytable">
			  			<thead>
					      <tr class="active info">  
					        <th>Numero </th>
					        <th>Solde</th>
					        <th>Debit Maximal</th>
					        <th>Decouvert Maximal</th>	        	
						    </tr>
				   		</thead> 
				   		<tbody >
    	
    	
    	<%
    	
    	for(Iterator<Compte> it = mescomptes.iterator(); it.hasNext();){
           Compte compte = it.next();
            out.println("<tr>");
            out.println("<td>"+compte.getNumerocompte()+"</td>");
            out.println("<td>"+compte.getSolde()+"</td>");
            out.println("<td>"+compte.getDebitmaximal()+"</td>");
            out.println("<td>"+compte.getDecouvertmaximal()+"</td>");
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