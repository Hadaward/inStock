<%@page import ="sce.model.UserDAO"%>
<%@page import ="sce.model.User"%>
<%@page import ="java.util.List"%>

<%	UserDAO dao = new UserDAO();
	List<User> lista;
	lista = dao.listar();
	%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	
</head>
<body>
	<jsp:include page="barra_superior_admin.jsp"/>
	<div class="container">
		<h1 class="display-5 mt-3">Lista de Usuários</h1>
		<ul class="mt-2 list-group">
		  <%for(User registro:lista){ %>
		  <li class="mt-1 list-group-item"><%=registro.getUsername()%>
		  <div class="float-right">
			  <a data-toggle="modal" data-target=".alterar-modal-<%=registro.getId()%>"><i class="far fa-edit text-dark"></i></a>
			  <a data-toggle="modal" data-target=".excluir-modal-<%=registro.getId()%>"><i class="fas fa-trash text-dark"></i></a>
		  </div>
		  </li>
		  <!-- Modal Excluir -->
			<div class="modal fade excluir-modal-<%=registro.getId()%>" tabindex="-1" role="dialog" aria-hidden="true">
			  <div class="modal-dialog modal-dialog-centered" role="document">
			    <div class="modal-content">
			      <div class="modal-header">
			        <h5 class="modal-title" id="exampleModalCenterTitle">Excluir Usuário</h5>
			        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
			          <span aria-hidden="true">&times;</span>
			        </button>
			      </div>
			      <div class="modal-body">
			        Você tem certeza que deseja excluir permanentemente o usuário <%=registro.getUsername()%>?
			      </div>
			      <div class="modal-footer">
			        <button type="button" class="btn btn-secondary" data-dismiss="modal">Fechar</button>
			        <form action="../ExcluirUser" method="post">
			        	<input name="user_id" type="hidden" value="<%=registro.getId()%>">
			        	<button type="submit" class="btn btn-danger">Confirmar</button>
			        </form>
			      </div>
			    </div>
			  </div>
			</div>
			
			<!-- Modal Alterar -->
			<div class="modal fade alterar-modal-<%=registro.getId()%>" tabindex="-1" role="dialog" aria-hidden="true">
			  <div class="modal-dialog modal-dialog-centered" role="document">
			    <div class="modal-content">
			      <div class="modal-header">
			        <h5 class="modal-title" id="exampleModalCenterTitle">Alterar Usuário</h5>
			        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
			          <span aria-hidden="true">&times;</span>
			        </button>
			      </div>
			      	<form action="../AlterarUser" method="post">
			      		<div class="modal-body">
				      	    <div class="form-group">
						    	<label for="user_name">Nome do Usuário</label>
						    	<input type="text" class="form-control" id="user_name" name="user_name" value="<%=registro.getUsername()%>">
							</div>
						    <div class="form-group">
							    <label for="user_login">Login do Usuário</label>
							    <input type="text" class="form-control" id="user_login" name="user_login" value="<%=registro.getLogin()%>">
							</div>
						    <div class="form-group">
						    	<label for="user_password">Senha</label>
						    	<input type="password" class="form-control" id="user_password" name="user_password" value="<%=registro.getPassword()%>">
						    </div>
				      	</div>
					    <div class="modal-footer">
					        <button type="button" class="btn btn-secondary" data-dismiss="modal">Fechar</button>
					        <input name="user_id" type="hidden" value="<%=registro.getId()%>">
					        <button type="submit" class="btn btn-danger">Confirmar</button>
					    </div>
			        </form>
			    </div>
			  </div>
			</div>
		 	  
		  <%} %>
		</ul>
		<div class="mt-2 float-right">
			<button type="button" id="btn-novo_user" class="btn btn-dark" data-toggle="modal" data-target="#novo-user">Novo Usuário</button>
		</div>
	
	<!-- Modal Novo User -->
			<div class="modal fade" id="novo-user" tabindex="-1" role="dialog" aria-hidden="true">
			  <div class="modal-dialog modal-dialog-centered" role="document">
			    <div class="modal-content">
			      <div class="modal-header">
			        <h5 class="modal-title" id="exampleModalCenterTitle">Novo Usuário</h5>
			        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
			          <span aria-hidden="true">&times;</span>
			        </button>
			      </div>
			      	<form action="../NovoUser" method="post">
			      		<div class="modal-body">
				      	    <div class="form-group">
							    <label for="user_name">Nome do Usuário</label>
							    <input type="text" class="form-control" id="user_name" name="user_name" placeholder="Digite o nome do usuário">
							</div>
							<div class="form-group">
							    <label for="user_login">Login do Usuário</label>
							    <input type="text" class="form-control" id="user_login" name="user_login" placeholder="Digite o login do usuário,será usado como nome de acesso">
							</div>
							<div class="row">
								<div class="form-group col-6">
							    	<label for="user_password">Senha</label>
							    	<input type="password" class="form-control" id="user_password" name="user_password" placeholder="Senha do usuário">
								</div>
								<div class="form-group col-6">
								    <label for="user_password-check">Confirmar Senha</label>
								    <input type="password" class="form-control" id="user_password_check" name="user_password-check" placeholder="Confirmação da senha">
								</div>
							</div>
				      	</div>
					    <div class="modal-footer">
					        <button type="button" class="btn btn-secondary" data-dismiss="modal">Fechar</button>
					        <button type="submit" class="btn btn-danger">Confirmar</button>
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
			<%} %>
	</div>
</body>
	<jsp:include page="../resources/imports.jsp"/>
</html>