<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=${encoding}">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="./assets/css/bootstrap.min.css" rel="stylesheet">
<link href="./assets/css/style.css" rel="stylesheet">
<title>Index-Connexion</title>
</head>
<body>
<div class="container">
  <div class="row">
    <diV class="col-md-offset-3 col-md-6">
        <div class="panel panel-info">
          <diV class="panel-heading">
            <div class="page-header">
                  <p>
                        <h1 class="text-center"> Connexion</h1>
            
                  </p>
            </div>

          </diV>
          <div class="panel-body">
              <form class="text-center" id="form1" method="POST" >
              
            <label for="text">Email</label> 
                <div class="row">
                  <div class="col-md-offset-3 col-md-6">
              <input type="email" name="login"  class="form-control" tabindex="1" required placeholder="votre mail" autofocus> <br/>                     
                  </div>
                </div>
             
             <label for="text">Password</label> 
                      <div class="row">
             
                      <div class="col-md-offset-3 col-md-6">
             <input type="password" name="password"  class="form-control" tabindex="2" required placeholder="login de l'utilisateur" autofocus> <br/>

                      </div>  
                      </div>
             

            </form>

          </div>

          <div class="panel-footer">
              <button type="submit" class="btn btn-success" name="connexion"  form="form1">Connexion</button>             
              <button type="reset" class="btn btn-warning  pull-right" >Annuler</button>

          </div>

        </div>

    </div>  
  </div>


</div>



<script src="assets/js/jquery.js"></script>
<script src="/assets/js/bootstrap.min.js"></script>
</body>
</html>