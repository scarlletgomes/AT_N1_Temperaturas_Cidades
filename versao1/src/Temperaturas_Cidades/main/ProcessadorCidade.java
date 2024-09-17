package Temperaturas_Cidades.main;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import Entidades.Ano;
import Entidades.Cidade;
import Entidades.Mes;
import java.util.concurrent.locks.Lock;

public class ProcessadorCidade extends Thread {
    private String[] arquivos;
    private int inicio;
    private int fim;
    private List<Cidade> cidades = new ArrayList<Cidade>();
    private Lock lock; 

    public ProcessadorCidade(String[] arquivos, int inicio, int fim, Lock lock) {
        this.arquivos = arquivos;
        this.inicio = inicio;
        this.fim = fim;
        this.lock = lock;
    }

    @Override
    public void run() {
        LeitorCSV lcsv = new LeitorCSV();
        File pasta = new File("temperaturas_cidades.arquivos");

        for (int i = inicio; i < fim; i++) {
            cidades.add(lcsv.lerCSV(pasta + "\\" + arquivos[i]));
        }

        
        lock.lock(); 
        try {
            imprime(); 
        } finally {
            lock.unlock(); 
        }
    }

    public void imprime() {
        for (Cidade cidade : cidades) {
            System.out.println("Cidade: " + cidade.getNomeCidade() + "\nPaís: " + cidade.getPais());
            System.out.println(Thread.currentThread().getName());

            for (Ano ano : cidade.getAnos()) {
                System.out.println("Ano: " + ano.getNumeroAno());

                for (Mes mes : ano.getMeses()) {
                    System.out.println("  Mês: " + mes.getNumero());
                    System.out.printf("    Média do mês: %.2f\n", mes.getMediaTempMensal());
                    System.out.printf("    Máxima do mês: %.2f\n", mes.getTempMaxima());
                    System.out.printf("    Mínima do mês: %.2f\n", mes.getTempMinima());
                }
                System.out.println("\n");
            }
        }
    }
}

