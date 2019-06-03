<%@page import="sce.model.ProdutoDAO"%>
<%@page import="sce.model.Produto"%>
<%@page import="java.util.List"%>

<%
	ProdutoDAO dao = new ProdutoDAO();
	List<Produto> lista;
	lista = dao.listar();
%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
</head>
<body>
	<jsp:include page="barra_superior_user.jsp" />
	<div class="container">
		<form>
			<input class="btn btn-dark btn-lg mt-3" type="button" value="Imprimir" onClick="window.print()"/>
		</form>
		<h1 class="display-5 mt-3">Todos os produtos</h1>
		<table class="mt-3 table">
			<thead>
				<tr>
					<th>Código</th>
					<th>Nome</th>
					<th>Descrição</th>
					<th>Unidade</th>
					<th>Quantidade</th>
				</tr>
			</thead>
			<%
				for (Produto registro : lista) {
			%>
			<tr>
				<td><%=registro.getCodigo()%></td>
				<td><%=registro.getName()%></td>
				<td><%=registro.getDescricao()%>
				<td><%=registro.getUnidade() %></td>
				<td><%=registro.getQuantidade()%></td>
			</tr>
			<%
				}
			%>
		</table>
	</div>
</body>
</html>