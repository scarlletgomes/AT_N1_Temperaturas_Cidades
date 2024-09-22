package Temperaturas_Cidades.main;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import Entidades.Ano;
import Entidades.Dia;
import Entidades.Mes;

public class ProcessadorAno extends Thread {
    String path;
    int anoParaProcessar;
    Ano ano = null;

    ProcessadorAno(String path, int anoParaProcessar) {
        this.path = path;
        this.anoParaProcessar = anoParaProcessar;
        this.ano = new Ano(anoParaProcessar); 
    }

    public void run() {
        Mes mes = null;
        int mesAux = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line = br.readLine(); 
            line = br.readLine(); 

            while (line != null) {
                String[] vect = line.split(",");
                int numMes = Integer.parseInt(vect[2]);
                int numDia = Integer.parseInt(vect[3]);
                int numAno = Integer.parseInt(vect[4]);
                double tempMediaDiaria = Double.parseDouble(vect[5]);

                if (numAno == anoParaProcessar) {
                    if (mes == null) {
                        mes = new Mes(numMes);
                        mesAux = numMes;
                    }

                    if (numMes != mesAux) {
                        ano.getMeses().add(mes);
                        mes = new Mes(numMes);
                        mesAux = numMes;
                    }

                    Dia dia = new Dia(numDia, tempMediaDiaria);
                    mes.adicionarDia(dia);
                }

                line = br.readLine();
            }

            if (mes != null) {
                ano.getMeses().add(mes);
            }

        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo: " + e.getMessage());
        }
    }

    public Ano getAno() {
        return ano;
    }
}
