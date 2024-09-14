package Entidades;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Cidade implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private String pais;
	private String nomeCidade;
	private List<Ano> anos = new ArrayList<Ano>();
	
	public Cidade(){}

	public Cidade(String pais, String nomeCidade) {
		super();
		this.pais = pais;
		this.nomeCidade = nomeCidade;
	}

	public String getPais() {
		return pais;
	}

	public String getNomeCidade() {
		return nomeCidade;
	}

	public List<Ano> getAnos() {
		return anos;
	}	
	
	
}
