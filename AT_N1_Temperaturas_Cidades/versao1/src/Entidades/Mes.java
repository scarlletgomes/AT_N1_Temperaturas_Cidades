package Entidades;

import java.util.ArrayList;
import java.util.List;

public class Mes {
    private int numero;
    private int ano;
    private List<Dia> dias = new ArrayList<Dia>();
    private double mediaTempMensal;
    private double tempMaxima = Double.MIN_VALUE;
    private double tempMinima = Double.MAX_VALUE;
    
    public Mes(int numero) {
        this.numero = numero;
    }

    public int getNumero() {
        return numero;
    }
    
    public int getAno() {
        return ano;
    }

    public List<Dia> getDias() {
        return dias;
    }

    public double getMediaTempMensal() {
        return mediaTempMensal;
    }

    public double getTempMaxima() {
        return tempMaxima;
    }

    public double getTempMinima() {
        return tempMinima;
    }

    public void adicionarDia(Dia dia) {
        dias.add(dia);
        atualizarTemperaturas();
    }

    private void atualizarTemperaturas() {
        double somaTemperaturas = 0;
        tempMaxima = Double.MIN_VALUE; 
        tempMinima = Double.MAX_VALUE;

        for (Dia dia : dias) {
            double temp = dia.getTempMediaDiaria();
            somaTemperaturas += temp;

            if (temp > tempMaxima) {
                tempMaxima = temp;
            }

            if (temp < tempMinima) {
                tempMinima = temp;
            }
        }

        if (!dias.isEmpty()) {
            mediaTempMensal = somaTemperaturas / dias.size();
        }
    }
}
