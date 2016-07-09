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
<title>Ajout d'un compte</title>
<link href="../assets/css/bootstrap.min.css" rel="stylesheet">
<link href="../assets/css/style.css" rel="stylesheet">
</head>
<body>

<jsp:include page="menu.jsp"></jsp:include>
<div class="container">
		<div class="page-header text-center">
			<h1>Créer un nouveau compte</h1>
		</div>
		
		<div class="row">
			<div  class="col-md-offset-3 col-md-6">
						
		<div class="panel panel-info">
			<div class="panel text-center panel-heading">
				<h4>Formulaire d'ajout</h4>
			</div>
			<div class="panel panel-body">
				
				<form method="post">
					
					<label for="inputPrenom" class="sr-only">Prenom</label>
					 <input type="text" class="form-control"placeholder="Prenom" required autofocus name="prenom"><br>
					 <input type="text" class="form-control"placeholder="Nom" required name="nom">	 <br>	
					<label	for="inputAdresse" class="sr-only">Adresse</label> 
					<input type="text" class="form-control"placeholder="Adresse" required  name="adresse"><br>
					<label	for="inputAdresse" class="sr-only">@mail </label> 
					<input type="email" class="form-control"placeholder="votre email" required  name="login"><br>
					<label	for="inputAdresse" class="sr-only">Mot de passe </label> 
					<input type="password" class="form-control"placeholder="password" required  name="password"><br>
					<label	for="inputAdresse" class="sr-only">Solde du compte </label> 
					<input type="number" class="form-control"placeholder="Solde de départ" required  name="solde"><br>
					<label	for="inputAdresse" class="sr-only">Debit Maximal </label> 
					<input type="number" class="form-control"placeholder="Debit maximal" required  name="debitmaximal"><br>
					
					<label	for="inputAdresse" class="sr-only">Decouvert Maximal </label> 
					<input type="number" class="form-control" placeholder="Decouvert Maximal" required  name="decouvertmaximal"><br>
					
								
					<input  class="btn btn-success" type="submit" value="Ajouter" name="ajouter"> 
					
					
				</form>

			</div>
		</div>
			
			</div>
		</div>


	</div>







<script src="../assets/js/jquery.js"></script>
<script src="../assets/js/bootstrap.min.js"></script>
</body>
</html>