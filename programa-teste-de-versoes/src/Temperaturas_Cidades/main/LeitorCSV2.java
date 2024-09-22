package Temperaturas_Cidades.main;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import Entidades.Cidade;

public class LeitorCSV2 {

    LeitorCSV2() {}

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

    public Cidade lerCSV2(String path, boolean temThreadAno) {
        int[] anos = identificarAnos(path); 
        Cidade cidade = null;
        ProcessadorAno[] threadsAno = new ProcessadorAno[anos.length];

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line = br.readLine(); 
            line = br.readLine(); 
            
            String[] vect = line.split(",");
            String pais = vect[0];
            String nomeCidade = vect[1];

            cidade = new Cidade(pais, nomeCidade);
            
            if (temThreadAno) {
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
            } else {
            }
            
        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo: " + e.getMessage());
        }
        return cidade;
    }
}
