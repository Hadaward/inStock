<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>SCE - Login</title>
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="conteiner">
		<div class="col-md-6 offset-3 mt-5">
			<div class="card shadow">
				<div class="card-body">
					<div class="text-center mx-auto">
						<img src="resources/img/img-logo.png" width="60" height="60" class="text-center align-top" alt="">
						<h3 class="display-4">inStock</h3>
					</div>
					<form action="Login" method="post">
					  <div class="form-group">
					    <input type="text" class="form-control" name="login" id="login" placeholder="Login">
					  </div>
					  <div class="form-group">
					    <input type="password" class="form-control" name="password" id="password" placeholder="Senha">
					  </div>
					  <div class="text-right">
					  	<button type="submit" class="btn btn-dark">Acessar</button>
					  </div>
					</form>
				</div>
			</div>
		</div>
		<%if (request.getParameter("msg_success") != null){ 
			String msg = request.getParameter("msg_success");%>
			<div class="alert alert-success fixed-bottom mx-5" role="alert">
			  <%=msg%>
			  <button type="button" class="close" data-dismiss="alert" aria-label="Close">
			    <span aria-hidden="true">&times;</span>
			  </button>
			</div>
		<%} else if (request.getParameter("msg_error") != null) { 
			String msg = request.getParameter("msg_error");	%>
			<div class="alert alert-danger fixed-bottom mx-5" role="alert">
			  <%=msg%>
			  <button type="button" class="close" data-dismiss="alert" aria-label="Close">
			    <span aria-hidden="true">&times;</span>
			  </button>
			</div>
		<%}%>
	</div>
</body>
</html>