package Temperaturas_Cidades.main;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import Entidades.Ano;
import Entidades.Cidade;
import Entidades.Mes;

public class OrganizadorVersoes {
	File pasta = new File("temperaturas_cidades.arquivos");
	String arquivos[] = new String[pasta.listFiles().length];
	List<Cidade> cidades = new ArrayList<Cidade>();
	private Lock lock = new ReentrantLock();
	
	OrganizadorVersoes(){
		
	}
	
	void iniciarVersoes(int numThreadsCidade, boolean temThreadAno){
		ProcessadorCidade[] threadsCidade = new ProcessadorCidade[numThreadsCidade];
		int i = 0;
		
		
		System.out.println("TEMPERATURAS CIDADES\n");
		if(numThreadsCidade > 0) {
			for(File file:pasta.listFiles()) {
				arquivos[i] = file.getName();
				i++;
			}
			
			int divisao = arquivos.length/numThreadsCidade;
			
			for (i = 0; i < numThreadsCidade; i++) {
	            int posicaoInicio = i * divisao;
	            int posicaoFinal;
	            if (i == numThreadsCidade - 1) {
	                posicaoFinal = arquivos.length;
	            } else {
	                posicaoFinal = (i + 1) * divisao;
	            }
	           
	            threadsCidade[i] = new ProcessadorCidade(arquivos, posicaoInicio, posicaoFinal, lock, temThreadAno);
	            threadsCidade[i].start();
			}
		
        }else {
        	LeitorCSV lcsv = new LeitorCSV();
    		File pasta = new File("temperaturas_cidades.arquivos");
    		
    		for(File file:pasta.listFiles()) {
    			cidades.add(lcsv.lerCSV(pasta + "\\" + file.getName(), temThreadAno));
    		}
    		
            System.out.println("TEMPERATURAS CIDADES\n");

            for (Cidade cidade : cidades) {
                System.out.println("Cidade: " + cidade.getNomeCidade() + "\nPaís: " + cidade.getPais());

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

        
        try {
        	if(numThreadsCidade > 0) {
        		for (ProcessadorCidade thread : threadsCidade) {
        			thread.join();
        		}
        	}
            
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}