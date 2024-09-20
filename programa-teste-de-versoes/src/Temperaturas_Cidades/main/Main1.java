package Temperaturas_Cidades.main;

public class Main1 {
	
	private static long[] tempoExecucoes;

	public static void main(String[] args) {
		GeraResultadoTeste resultado = new GeraResultadoTeste();
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
		
		resultado.geraResultado(tempoExecucoes, tempoMedio, "VERSÃO 1");
		
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
		resultado.geraResultado(tempoExecucoes, tempoMedio, "VERSÃO 2");
		
		//TESTE VERSÃO 3
		for(int i = 0; i < numExecucoes; i++) {
			long tempoInicio = System.currentTimeMillis();
			
			v2a10.iniciarV3();
			
			// Captura o tempo final em milissegundos
		long tempoFim = System.currentTimeMillis();

		// Calcula o tempo total de execução
		tempoExecucoes[i] = tempoFim - tempoInicio;

			tempoMedio +=tempoExecucoes[i];
		}
		tempoMedio = tempoMedio/10;
		System.out.println("Tempo de execução médio V3: " + tempoMedio);
		resultado.geraResultado(tempoExecucoes, tempoMedio, "VERSÃO 3");
		
		//TESTE VERSÃO 4
		for(int i = 0; i < numExecucoes; i++) {
			long tempoInicio = System.currentTimeMillis();
			
			v2a10.iniciarV4();
			
			// Captura o tempo final em milissegundos
		long tempoFim = System.currentTimeMillis();

		// Calcula o tempo total de execução
		tempoExecucoes[i] = tempoFim - tempoInicio;

			tempoMedio +=tempoExecucoes[i];
		}
		tempoMedio = tempoMedio/10;
		System.out.println("Tempo de execução médio V4: " + tempoMedio);
		resultado.geraResultado(tempoExecucoes, tempoMedio, "VERSÃO 4");
		
		//TESTE VERSÃO 5
		for(int i = 0; i < numExecucoes; i++) {
			long tempoInicio = System.currentTimeMillis();
			
			v2a10.iniciarV5();
			
			// Captura o tempo final em milissegundos
		long tempoFim = System.currentTimeMillis();

		// Calcula o tempo total de execução
		tempoExecucoes[i] = tempoFim - tempoInicio;

			tempoMedio +=tempoExecucoes[i];
		}
		tempoMedio = tempoMedio/10;
		System.out.println("Tempo de execução médio V5: " + tempoMedio);
		resultado.geraResultado(tempoExecucoes, tempoMedio, "VERSÃO 5");


		//TESTE VERSÃO 6
		for(int i = 0; i < numExecucoes; i++) {
			long tempoInicio = System.currentTimeMillis();
			
			v2a10.iniciarV6();
			
			// Captura o tempo final em milissegundos
		long tempoFim = System.currentTimeMillis();

		// Calcula o tempo total de execução
		tempoExecucoes[i] = tempoFim - tempoInicio;

			tempoMedio +=tempoExecucoes[i];
		}
		tempoMedio = tempoMedio/10;
		System.out.println("Tempo de execução médio V6: " + tempoMedio);
		resultado.geraResultado(tempoExecucoes, tempoMedio, "VERSÃO 6");

		//TESTE VERSÃO 7
		for(int i = 0; i < numExecucoes; i++) {
			long tempoInicio = System.currentTimeMillis();
			
			v2a10.iniciarV7();
			
			// Captura o tempo final em milissegundos
		long tempoFim = System.currentTimeMillis();

		// Calcula o tempo total de execução
		tempoExecucoes[i] = tempoFim - tempoInicio;

			tempoMedio +=tempoExecucoes[i];
		}
		tempoMedio = tempoMedio/10;
		System.out.println("Tempo de execução médio V7: " + tempoMedio);
		resultado.geraResultado(tempoExecucoes, tempoMedio, "VERSÃO 7");


		//TESTE VERSÃO 8
		for(int i = 0; i < numExecucoes; i++) {
			long tempoInicio = System.currentTimeMillis();
			
			v2a10.iniciarV8();
			
			// Captura o tempo final em milissegundos
		long tempoFim = System.currentTimeMillis();

		// Calcula o tempo total de execução
		tempoExecucoes[i] = tempoFim - tempoInicio;

			tempoMedio +=tempoExecucoes[i];
		}
		tempoMedio = tempoMedio/10;
		System.out.println("Tempo de execução médio V8: " + tempoMedio);
		resultado.geraResultado(tempoExecucoes, tempoMedio, "VERSÃO 8");


		//TESTE VERSÃO 9
		for(int i = 0; i < numExecucoes; i++) {
			long tempoInicio = System.currentTimeMillis();
			
			v2a10.iniciarV9();
			
			// Captura o tempo final em milissegundos
		long tempoFim = System.currentTimeMillis();

		// Calcula o tempo total de execução
		tempoExecucoes[i] = tempoFim - tempoInicio;

			tempoMedio +=tempoExecucoes[i];
		}
		tempoMedio = tempoMedio/10;
		System.out.println("Tempo de execução médio V9: " + tempoMedio);
		resultado.geraResultado(tempoExecucoes, tempoMedio, "VERSÃO 9");


		//TESTE VERSÃO 10
		for(int i = 0; i < numExecucoes; i++) {
			long tempoInicio = System.currentTimeMillis();
			
			v2a10.iniciarV10();
			
			// Captura o tempo final em milissegundos
		long tempoFim = System.currentTimeMillis();

		// Calcula o tempo total de execução
		tempoExecucoes[i] = tempoFim - tempoInicio;

			tempoMedio +=tempoExecucoes[i];
		}
		tempoMedio = tempoMedio/10;
		System.out.println("Tempo de execução médio V10: " + tempoMedio);
		resultado.geraResultado(tempoExecucoes, tempoMedio, "VERSÃO 10");
		
	}
}
