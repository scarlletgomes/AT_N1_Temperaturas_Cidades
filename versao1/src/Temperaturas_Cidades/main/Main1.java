package Temperaturas_Cidades.main;

public class Main1 {
	
	private static long[] tempoExecucoes;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Versao1 v1 = new Versao1();
		Versoes2a10 v2a10 = new Versoes2a10();
		
		int numExecucoes = 10;
		long tempoMedio = 0;
		tempoExecucoes = new long[numExecucoes];
		
		//TESTE VERSÃO 1
		for(int i = 0; i < numExecucoes; i++) {
			long tempoInicio = System.currentTimeMillis();
			
			v1.iniciarV1();
			
			// Captura o tempo final em milissegundos
	        long tempoFim = System.currentTimeMillis();

	        // Calcula o tempo total de execução
	        tempoExecucoes[i] = tempoFim - tempoInicio;

			tempoMedio +=tempoExecucoes[i];
		}
		tempoMedio = tempoMedio/10;
		System.out.println("Tempo de execução médio V1: " + tempoMedio);
		//FUNÇÃO PARA COLOCAR O RESULTADO EM UM ARQUIVO TXT
		
		//TESTE VERSÃO 2
		for(int i = 0; i < numExecucoes; i++) {
			long tempoInicio = System.currentTimeMillis();
			
			v2a10.iniciarV2();
			
			// Captura o tempo final em milissegundos
	        long tempoFim = System.currentTimeMillis();

	        // Calcula o tempo total de execução
	        tempoExecucoes[i] = tempoFim - tempoInicio;

			tempoMedio +=tempoExecucoes[i];
		}
		tempoMedio = tempoMedio/10;
		System.out.println("Tempo de execução médio V2: " + tempoMedio);
	}
	
	//IMPLEMENTAR TESTE DAS OUTRAS VERSÕES...
	//(AS OUTRAS VERSÕES, DE 2 A 10, DEVEM FICAR EM UM ARQUIVO SÓ...)
}
