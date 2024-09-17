package Temperaturas_Cidades.main;

import java.io.File;

public class ControlaThreadCidade {
	private String[] arquivos;

	ControlaThreadCidade(){
		
	}
	
	void setThreads(int numThreads){
		ProcessadorCidade[] threads = new ProcessadorCidade[numThreads];
		File pasta = new File("temperaturas_cidades.arquivos");
		arquivos = null;
		int i = 0;
		for(File file:pasta.listFiles()) {
			arquivos[i] = file.getName();
			i++;
		}
		
		int divisao = arquivos.length/numThreads;
		
		for(i = 0; i<numThreads; i++) {
			int posicaoInicio = i * divisao;
			int posicaoFinal;
			if (i == numThreads - 1) {
				posicaoFinal = arquivos.length;
			} else {
				posicaoFinal = (i + 1) * divisao;
			}
			threads[i] = new ProcessadorCidade(arquivos, posicaoInicio, posicaoFinal);
		}
	}
}
