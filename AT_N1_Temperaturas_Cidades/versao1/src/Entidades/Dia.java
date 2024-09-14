package Entidades;

public class Dia {
	private int numero;
	private double tempMediaDiaria;
	
	public Dia(int numero, double tempMediaDiaria){
		this.numero = numero;
		this.tempMediaDiaria = tempMediaDiaria;
	}

	public int getNumero() {
		return numero;
	}

	public double getTempMediaDiaria() {
		return tempMediaDiaria;
	}
	
}
