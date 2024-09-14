package Entidades;

import java.util.ArrayList;
import java.util.List;

public class Ano {
	private int numeroAno;
	private List<Mes> meses = new ArrayList<Mes>();
	
	public Ano(int numeroAno){
		this.numeroAno = numeroAno;
	}

	public int getNumeroAno() {
		return numeroAno;
	}

	public List<Mes> getMeses() {
		return meses;
	}
	
	
}
