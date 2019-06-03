package sce.model;

import java.util.Calendar;

public class Entrada {
	public int entrada_id;
	public Calendar entrada_data;
	public int entrada_quantidade;
	
	public int getId() {
		return entrada_id;
	}
	public void setId(int entrada_id) {
		this.entrada_id = entrada_id;
	}
	public Calendar getData() {
		return entrada_data;
	}
	public void setData(Calendar entrada_data) {
		this.entrada_data = entrada_data;
	}
	public int getQuantidade() {
		return entrada_quantidade;
	}
	public void setQuantidade(int entrada_quantidade) {
		this.entrada_quantidade = entrada_quantidade;
	}
}
