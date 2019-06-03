package sce.model;

import java.util.Calendar;

public class Saida {
	public int saida_id;
	public Calendar saida_data;
	public int saida_quantidade;
	
	public int getSaida_id() {
		return saida_id;
	}
	public void setSaida_id(int saida_id) {
		this.saida_id = saida_id;
	}
	public Calendar getSaida_data() {
		return saida_data;
	}
	public void setSaida_data(Calendar saida_data) {
		this.saida_data = saida_data;
	}
	public int getSaida_quantidade() {
		return saida_quantidade;
	}
	public void setSaida_quantidade(int saida_quantidade) {
		this.saida_quantidade = saida_quantidade;
	}
	
}
