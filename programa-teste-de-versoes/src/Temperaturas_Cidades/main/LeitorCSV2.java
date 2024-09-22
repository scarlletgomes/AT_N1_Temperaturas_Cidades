package Temperaturas_Cidades.main;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import Entidades.Cidade;

public class LeitorCSV2 {

    LeitorCSV2() {}

    // Método que identifica os anos presentes no arquivo
    int[] identificarAnos(String path) {
        List<Integer> anos = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line = br.readLine(); // Lê o cabeçalho
            line = br.readLine(); // Lê a primeira linha de dados

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
        int[] anos = identificarAnos(path); // Lista de anos encontrados no arquivo
        Cidade cidade = null;
        ProcessadorAno[] threadsAno = new ProcessadorAno[anos.length];

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line = br.readLine(); // Lê o cabeçalho
            line = br.readLine(); // Lê a primeira linha de dados
            
            // Pega informações da cidade e país da primeira linha
            String[] vect = line.split(",");
            String pais = vect[0];
            String nomeCidade = vect[1];

            // Cria a cidade com base na primeira linha do arquivo
            cidade = new Cidade(pais, nomeCidade);
            
            if (temThreadAno) {
                // Inicializa as threads, cada uma processando um ano específico
                for (int i = 0; i < anos.length; i++) {
                    threadsAno[i] = new ProcessadorAno(path, anos[i]);
                    threadsAno[i].start(); // Iniciar a thread
                }
                
                for (int i = 0; i < anos.length; i++) {
                    try {
                        threadsAno[i].join(); // Aguarda a conclusão de cada thread
                    } catch (InterruptedException e) {
                        System.out.println("Erro ao aguardar a thread terminar: " + e.getMessage());
                    }
                }

                // Adiciona os anos processados pelas threads à cidade
                for (int i = 0; i < anos.length; i++) {
                    cidade.getAnos().add(threadsAno[i].getAno());
                }
            } else {
                // Se não usar threads, o processamento normal acontece aqui (caso você queira implementar essa opção também)
            }
            
        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo: " + e.getMessage());
        }

        return cidade;
    }
}
