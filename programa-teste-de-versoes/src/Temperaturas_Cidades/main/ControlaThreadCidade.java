package Temperaturas_Cidades.main;

import java.io.File;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ControlaThreadCidade {
	File pasta = new File("temperaturas_cidades.arquivos");
	String arquivos[] = new String[pasta.listFiles().length];
	private Lock lock = new ReentrantLock();
	
	ControlaThreadCidade(){
		
	}
	
	void setThreads(int numThreads){
		ProcessadorCidade[] threads = new ProcessadorCidade[numThreads];
		int i = 0;
		
		for(File file:pasta.listFiles()) {
			arquivos[i] = file.getName();
			i++;
		}
		
		int divisao = arquivos.length/numThreads;
		
		for (i = 0; i < numThreads; i++) {
            int posicaoInicio = i * divisao;
            int posicaoFinal;
            if (i == numThreads - 1) {
                posicaoFinal = arquivos.length;
            } else {
                posicaoFinal = (i + 1) * divisao;
            }
            
            threads[i] = new ProcessadorCidade(arquivos, posicaoInicio, posicaoFinal, lock);
            threads[i].start();
        }

       
        try {
            for (ProcessadorCidade thread : threads) {
                thread.join();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
