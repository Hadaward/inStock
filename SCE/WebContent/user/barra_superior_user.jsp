<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.1/css/all.css">
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>SCE - User</title>
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
	<meta name="viewport" content="width=device-width, user-scalable=no">
</head>
<body>
	<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
	  <a class="navbar-brand" href="user.jsp">
	    <img src="../resources/img/img-logo.png" width="30" height="30" class="d-inline-block align-top" alt="">
	    inStock
	  </a>
	  <ul class="navbar-nav mr-auto">
		  <li class="nav-item">
	        <a class="nav-link" href="relatorio_produtos.jsp" target="_blank">Lista de Produtos</a>
	      </li>
	  </ul>
	  <div class="float-right">
	  	<form action="Logout" action="post">
	  		<button type="submit" class="btn btn-dark border-0"><span class="fas fa-sign-out-alt"></span></button>
	  	</form>
	  </div> 
	</nav>
</body>
</html>