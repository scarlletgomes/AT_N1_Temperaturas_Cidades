package Temperaturas_Cidades.main;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import Entidades.Ano;
import Entidades.Cidade;
import Entidades.Dia;
import Entidades.Mes;

public class LeitorCSV {
    
    LeitorCSV() {}

    int[] identificarAnos(String path) {
        List<Integer> anos = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line = br.readLine(); 
            line = br.readLine(); 

            while (line != null) {
                String[] vect = line.split(",");
                int numAno = Integer.parseInt(vect[4]);

                if (!anos.contains(numAno)) {
                    anos.add(numAno);
                }

                line = br.readLine();
            }
        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo: " + e.getMessage());
        }

        return anos.stream().mapToInt(Integer::intValue).toArray();
    }

    public Cidade lerCSV(String path, boolean temThreadAno) {
        Cidade cidade = null;
        
        if (temThreadAno) {
            int[] anos = identificarAnos(path); 
            ProcessadorAno[] threadsAno = new ProcessadorAno[anos.length];

            try (BufferedReader br = new BufferedReader(new FileReader(path))) {
                String line = br.readLine(); 
                line = br.readLine(); 

                String[] vect = line.split(",");
                String pais = vect[0];
                String nomeCidade = vect[1];

                cidade = new Cidade(pais, nomeCidade);

                for (int i = 0; i < anos.length; i++) {
                    threadsAno[i] = new ProcessadorAno(path, anos[i]);
                    threadsAno[i].start(); 
                }

                for (int i = 0; i < anos.length; i++) {
                    try {
                        threadsAno[i].join(); 
                    } catch (InterruptedException e) {
                        System.out.println("Erro ao aguardar a thread terminar: " + e.getMessage());
                    }
                }

                for (int i = 0; i < anos.length; i++) {
                    cidade.getAnos().add(threadsAno[i].getAno());
                }

            } catch (IOException e) {
                System.out.println("Erro ao ler o arquivo: " + e.getMessage());
            }

        } else {
            int anoAux = 0;
            int mesAux = 0;
            Ano ano = null;
            Mes mes = null;

            try (BufferedReader br = new BufferedReader(new FileReader(path))) {
                String line = br.readLine(); 
                line = br.readLine(); 

                while (line != null) {
                    String[] vect = line.split(",");
                    String pais = vect[0];
                    String nomeCidade = vect[1];
                    int numMes = Integer.parseInt(vect[2]);
                    int numDia = Integer.parseInt(vect[3]);
                    int numAno = Integer.parseInt(vect[4]);
                    double tempMediaDiaria = Double.parseDouble(vect[5]);

                    if (cidade == null) {
                        cidade = new Cidade(pais, nomeCidade);
                        ano = new Ano(numAno);
                        mes = new Mes(numMes);
                        anoAux = numAno;
                        mesAux = numMes;
                    }

                    if (numAno != anoAux) {
                        ano.getMeses().add(mes); 
                        cidade.getAnos().add(ano);

                        ano = new Ano(numAno);
                        mes = new Mes(numMes);
                        anoAux = numAno;
                        mesAux = numMes;
                    }

                    if (numMes != mesAux) {
                        ano.getMeses().add(mes);

                        mes = new Mes(numMes);
                        mesAux = numMes;
                    }

                    Dia dia = new Dia(numDia, tempMediaDiaria);
                    mes.adicionarDia(dia);

                    line = br.readLine();
                }

                if (mes != null) {
                    ano.getMeses().add(mes);
                }
                if (ano != null) {
                    cidade.getAnos().add(ano);
                }

            } catch (IOException e) {
                System.out.println("Erro ao ler o arquivo: " + e.getMessage());
            }
        }

        return cidade;
    }
}
