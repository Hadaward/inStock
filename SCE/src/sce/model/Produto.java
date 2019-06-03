package sce.model;

public class Produto {
	public int produto_id;
	public String produto_codigo;
	public String produto_name;
	public String produto_descricao;
	public String produto_unidade;
	public String produto_fornecedor;
	public int produto_quantidade;
	
	public int getId() {
		return produto_id;
	}
	public void setId(int produto_id) {
		this.produto_id = produto_id;
	}
	public String getCodigo() {
		return produto_codigo;
	}
	public void setCodigo(String produto_codigo) {
		this.produto_codigo = produto_codigo;
	}
	public String getName() {
		return produto_name;
	}
	public void setName(String produto_name) {
		this.produto_name = produto_name;
	}
	public String getDescricao() {
		return produto_descricao;
	}
	public void setDescricao(String produto_descricao) {
		this.produto_descricao = produto_descricao;
	}
	public String getUnidade() {
		return produto_unidade;
	}
	public void setUnidade(String produto_unidade) {
		this.produto_unidade = produto_unidade;
	}
	public String getFornecedor() {
		return produto_fornecedor;
	}
	public void setFornecedor(String produto_fornecedor) {
		this.produto_fornecedor = produto_fornecedor;
	}
	public int getQuantidade() {
		return produto_quantidade;
	}
	public void setQuantidade(int produto_quantidade) {
		this.produto_quantidade = produto_quantidade;
	}
	
	
	
}
