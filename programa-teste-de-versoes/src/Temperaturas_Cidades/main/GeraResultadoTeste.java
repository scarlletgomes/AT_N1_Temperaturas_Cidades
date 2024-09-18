package Temperaturas_Cidades.main;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class GeraResultadoTeste {
	GeraResultadoTeste(){
		
	}
	
	void geraResultado(long[] tempoExecucao, long tempoMedio, String versao){
		//Path path = Path.of("resultado_experimentos" + "//"+versao+".txt");
		File file = new File("resultado_experimentos" + "//"+versao+".txt");
		
		
		
		try{
			FileWriter fw = new FileWriter(file);
			try (BufferedWriter bw = new BufferedWriter(fw)) {
				
				String temposExecucaoStr = "";
				for(int i = 0; i < tempoExecucao.length; i++) {
					int j = i+1;
					temposExecucaoStr += "Rodada " + j + ": Tempo de Execução = " + tempoExecucao[i] + " milisecundos\n";
				}		
				
				bw.write("RESULTADO " + versao);
				bw.newLine();
				bw.write(temposExecucaoStr + "Tempo médio = " + tempoMedio);
				bw.newLine();
				bw.newLine();
			}
			
		}catch(IOException e) {
			e.printStackTrace();
		}
		
		
	}
}
