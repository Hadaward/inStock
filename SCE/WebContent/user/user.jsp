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

</head>
<body>
	<jsp:include page="barra_superior_user.jsp" />
	<div class="container">
		<h1 class="display-5 mt-3">Lista de Produtos</h1>
		<table class="mt-3 table">
			<thead>
				<tr>
					<th>ID</th>
					<th>Nome</th>
					<th>Quantidade</th>
					<th></th>
					<th></th>
				</tr>
			</thead>
			<%
				for (Produto registro : lista) {
			%>
			<tr>
				<td><%=registro.getCodigo()%></td>
				<td><%=registro.getName()%></td>
				<td><%=registro.getQuantidade()%></td>
				<td>
					<button class="btn border-0" data-toggle="modal"
						data-target=".alterar-modal-<%=registro.getId()%>">
						<i class="far fa-edit text-dark"></i>
					</button>
					<button class="btn border-0" data-toggle="modal"
						data-target=".excluir-modal-<%=registro.getId()%>">
						<i class="fas fa-trash text-dark"></i>
					</button>
					<button class="btn border-0" data-toggle="modal"
						data-target=".mostrar-modal-<%=registro.getId()%>">
						<i class="fas fa-eye text-dark"></i>
					</button>
				</td>
				<td>
					<div class="btn-group btn-group-sm float-right" role="group"
						aria-label="Basic example">
						<button type="button" class="btn btn-danger" data-toggle="modal"
							data-target=".saida-modal-<%=registro.getId()%>">
							<i class="fas fa-minus"></i>
						</button>
						<button type="button" class="btn btn-success" data-toggle="modal"
							data-target=".entrada-modal-<%=registro.getId()%>">
							<i class="fas fa-plus"></i>
						</button>
					</div>
				</td>
			</tr>

			<!-- Modal Excluir -->
			<div class="modal fade excluir-modal-<%=registro.getId()%>"
				tabindex="-1" role="dialog" aria-hidden="true">
				<div class="modal-dialog modal-dialog-centered" role="document">
					<div class="modal-content">
						<div class="modal-header">
							<h5 class="modal-title" id="exampleModalCenterTitle">Excluir
								Produto</h5>
							<button type="button" class="close" data-dismiss="modal"
								aria-label="Close">
								<span aria-hidden="true">&times;</span>
							</button>
						</div>
						<div class="modal-body">
							Você tem certeza que deseja excluir permanentemente o produto
							<%=registro.getName()%>?
						</div>
						<div class="modal-footer">
							<button type="button" class="btn btn-outline-dark"
								data-dismiss="modal">Fechar</button>
							<form action="../ExcluirProduto" method="post">
								<input name="produto_id" type="hidden"
									value="<%=registro.getId()%>">
								<button type="submit" class="btn btn-danger">Confirmar</button>
							</form>
						</div>
					</div>
				</div>
			</div>

			<!-- Modal Alterar -->
			<div class="modal fade alterar-modal-<%=registro.getId()%>"
				tabindex="-1" role="dialog" aria-hidden="true">
				<div class="modal-dialog modal-dialog-centered" role="document">
					<div class="modal-content">
						<div class="modal-header">
							<h5 class="modal-title" id="exampleModalCenterTitle">Alterar
								Produto</h5>
							<button type="button" class="close" data-dismiss="modal"
								aria-label="Close">
								<span aria-hidden="true">&times;</span>
							</button>
						</div>
						<form action="../AlterarProduto" method="post">
							<div class="modal-body">
								<div class="form-group">
									<label for="produto_nome">Código de Identificação</label> <input
										type="text" class="form-control" id="produto_codigo"
										name="produto_codigo" value="<%=registro.getCodigo()%>">
								</div>
								<div class="form-group">
									<label for="produto_nome">Nome do Produto</label> <input
										type="text" class="form-control" id="produto_nome"
										name="produto_nome" value="<%=registro.getName()%>">
								</div>
								<div class="form-group">
									<label for="produto_peso">Descrição do Produto</label> <input
										type="text" class="form-control" id="produto_descricao"
										name="produto_descricao" value="<%=registro.getDescricao()%>">
								</div>
								<div class="form-group">
									<label for="produto_unidade">Unidade</label> <input type="text"
										class="form-control" id="produto_unidade"
										name="produto_unidade" maxlength="3"
										value="<%=registro.getUnidade()%>">
								</div>
								<div class="form-group">
									<label for="produto_fonecedor">Fornecedor</label> <input
										type="text" class="form-control" id="produto_fornecedor"
										name="produto_fornecedor"
										value="<%=registro.getFornecedor()%>">
								</div>
							</div>
							<div class="modal-footer">
								<button type="button" class="btn btn-outline-dark"
									data-dismiss="modal">Fechar</button>
								<input name="produto_id" type="hidden"
									value="<%=registro.getId()%>">
								<button type="submit" class="btn btn-dark">Confirmar</button>
							</div>
						</form>
					</div>
				</div>
			</div>

			<!-- Modal Mostrar -->
			<div class="modal fade mostrar-modal-<%=registro.getId()%>"
				tabindex="-1" role="dialog" aria-hidden="true">
				<div class="modal-dialog modal-dialog-centered modal-lg"
					role="document">
					<div class="modal-content">
						<div class="modal-header">
							<h5 class="modal-title" id="exampleModalCenterTitle"><%=registro.getName()%></h5>
							<button type="button" class="close" data-dismiss="modal"
								aria-label="Close">
								<span aria-hidden="true">&times;</span>
							</button>
						</div>
						<div class="modal-body">
							<div class="row">
								<div class="col-6">
									<p class="h5">Código de Identificação</p>
									<p class="h6"><%=registro.getCodigo()%></p>
								</div>
								<div class="col-6">
									<p class="h5">Fornecedor</p>
									<p class="h6"><%=registro.getFornecedor()%></p>
								</div>
								<div class="col-12">
									<p class="h5">Descrição do Produto</p>
									<p class="h6"><%=registro.getDescricao()%></p>
								</div>
								<div class=col-12>
									<p class="h5">Quantidade</p>
									<p class="h6"><%=registro.getQuantidade() + " " + registro.getUnidade()%></p>
								</div>
								<div class="chart-div"></div>
							</div>
						</div>
						<div class="modal-footer">
							<button type="button" class="btn btn-outline-dark"
								data-dismiss="modal">Fechar</button>
						</div>
					</div>
				</div>
			</div>

			<!-- Modal Saida -->
			<div class="modal fade saida-modal-<%=registro.getId()%>"
				tabindex="-1" role="dialog" aria-hidden="true">
				<div class="modal-dialog modal-dialog-centered" role="document">
					<div class="modal-content">
						<div class="modal-header">
							<h5 class="modal-title" id="exampleModalCenterTitle">Saída
								de Produto</h5>
							<button type="button" class="close" data-dismiss="modal"
								aria-label="Close">
								<span aria-hidden="true">&times;</span>
							</button>
						</div>
						<form action="../SaidaProduto" method="post">
							<div class="modal-body">
								<label for="qnt_saida">Qual a quantidade do produto <%=registro.getName()%>
									a ser retirada?
								</label> <input type="number" min="0" name="qnt_saida"
									class="form-control"> <small class="text-muted">Quantidade
									atual: <%=registro.getQuantidade()%></small>
							</div>
							<div class="modal-footer">
								<button type="button" class="btn btn-outline-dark"
									data-dismiss="modal">Fechar</button>
								<input name="produto_id" type="hidden"
									value="<%=registro.getId()%>">
								<button type="submit" class="btn btn-danger">Confirmar</button>
						</form>
					</div>
				</div>
			</div>
			</div>

			<!-- Modal Entrada -->
			<div class="modal fade entrada-modal-<%=registro.getId()%>"
				tabindex="-1" role="dialog" aria-hidden="true">
				<div class="modal-dialog modal-dialog-centered" role="document">
					<div class="modal-content">
						<div class="modal-header">
							<h5 class="modal-title" id="exampleModalCenterTitle">Saída
								de Produto</h5>
							<button type="button" class="close" data-dismiss="modal"
								aria-label="Close">
								<span aria-hidden="true">&times;</span>
							</button>
						</div>
						<form action="../EntradaProduto" method="post">
							<div class="modal-body">
								<label for="qnt_entrada">Qual a quantidade do produto <%=registro.getName()%>
									a ser entrada?
								</label> <input type="number" min="0" name="qnt_entrada"
									class="form-control"> <small class="text-muted">Quantidade
									atual: <%=registro.getQuantidade()%></small>
							</div>
							<div class="modal-footer">
								<button type="button" class="btn btn-outline-dark"
									data-dismiss="modal">Fechar</button>
								<input name="produto_id" type="hidden"
									value="<%=registro.getId()%>">
								<button type="submit" class="btn btn-success">Confirmar</button>
						</form>
					</div>
				</div>
			</div>
			</div>

			<%
				}
			%>
		</table>

		<button type="button" class="btn btn-dark mt-3 float-right"
			data-toggle="modal" data-target="#novo-produto">Novo Produto</button>

		<div class="modal fade" id="novo-produto" tabindex="-1" role="dialog"
			aria-hidden="true">
			<div class="modal-dialog modal-dialog-centered" role="document">
				<div class="modal-content">
					<div class="modal-header">
						<h5 class="modal-title" id="exampleModalCenterTitle">Novo
							Produto</h5>
						<button type="button" class="close" data-dismiss="modal"
							aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
					</div>
					<form action="../NovoProduto" method="post">
						<div class="modal-body">
							<div class="form-group">
								<label for="produto_nome">Código de Identificação</label> <input
									type="text" class="form-control" id="produto_codigo"
									name="produto_codigo">
							</div>
							<div class="form-group">
								<label for="produto_nome">Nome do Produto</label> <input
									type="text" class="form-control" id="produto_nome"
									name="produto_nome">
							</div>
							<div class="form-group">
								<label for="produto_peso">Descrição do Produto</label> <input
									type="text" class="form-control" id="produto_descricao"
									name="produto_descricao">
							</div>
							<div class="form-group">
								<label for="produto_unidade">Unidade</label> <input type="text"
									class="form-control" id="produto_unidade"
									name="produto_unidade" maxlength="3">
							</div>
							<div class="form-group">
								<label for="produto_fonecedor">Fornecedor</label> <input
									type="text" class="form-control" id="produto_fornecedor"
									name="produto_fornecedor">
							</div>
							<div class="modal-footer">
								<button type="button" class="btn btn-outline-dark"
									data-dismiss="modal">Fechar</button>
								<button type="submit" class="btn btn-dark">Confirmar</button>
							</div>
						</div>
					</form>
				</div>
			</div>
		</div>
		<%
			if (request.getParameter("msg_success") != null) {
				String msg = request.getParameter("msg_success");
		%>
		<div class="alert alert-success fixed-bottom mx-5" role="alert">
			<%=msg%>
			<button type="button" class="close" data-dismiss="alert"
				aria-label="Close">
				<span aria-hidden="true">&times;</span>
			</button>
		</div>
		<%
			} else if (request.getParameter("msg_error") != null) {
				String msg = request.getParameter("msg_error");
		%>
		<div class="alert alert-danger fixed-bottom mx-5" role="alert">
			<%=msg%>
			<button type="button" class="close" data-dismiss="alert"
				aria-label="Close">
				<span aria-hidden="true">&times;</span>
			</button>
		</div>
		<%
			}
		%>
	</div>
</body>
<jsp:include page="../resources/imports.jsp" />
</html>