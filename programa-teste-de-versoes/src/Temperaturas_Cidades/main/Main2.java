package Temperaturas_Cidades.main;

public class Main2 {
	
	private static long[] tempoExecucoes;

	public static void main(String[] args) {
		GeraResultadoTeste resultado = new GeraResultadoTeste();
		Versao11 v11 = new Versao11();
		Versoes12a20 v12a20 = new Versoes12a20();
		
		int numExecucoes = 10;
		long tempoMedio = 0;
		tempoExecucoes = new long[numExecucoes];
		
		//TESTE VERSÃO 11
			for(int i = 0; i < numExecucoes; i++) {
			long tempoInicio = System.currentTimeMillis();
			
			v11.iniciarV11();
	
	        long tempoFim = System.currentTimeMillis();

	        tempoExecucoes[i] = tempoFim - tempoInicio;

			tempoMedio +=tempoExecucoes[i];
		}
		tempoMedio = tempoMedio/10;
		System.out.println("Tempo de execução médio V1: " + tempoMedio);
		resultado.geraResultado(tempoExecucoes, tempoMedio, "VERSÃO 11");
		
		//TESTE VERSÃO 12
			for(int i = 0; i < numExecucoes; i++) {
			long tempoInicio = System.currentTimeMillis();
					
			v12a20.iniciarV12();
					
			long tempoFim = System.currentTimeMillis();

			tempoExecucoes[i] = tempoFim - tempoInicio;

			tempoMedio +=tempoExecucoes[i];
		}
		tempoMedio = tempoMedio/10;
		System.out.println("Tempo de execução médio V1: " + tempoMedio);
        resultado.geraResultado(tempoExecucoes, tempoMedio, "VERSÃO 12");
        
        //TESTE VERSÃO 13
        for(int i = 0; i < numExecucoes; i++) {
			long tempoInicio = System.currentTimeMillis();
			
			v12a20.iniciarV13();
			
	        long tempoFim = System.currentTimeMillis();

	        tempoExecucoes[i] = tempoFim - tempoInicio;

			tempoMedio +=tempoExecucoes[i];
		}
		tempoMedio = tempoMedio/10;
		System.out.println("Tempo de execução médio V1: " + tempoMedio);
		
		resultado.geraResultado(tempoExecucoes, tempoMedio, "VERSÃO 13");
				
		//TESTE VERSÃO 14
        for(int i = 0; i < numExecucoes; i++) {
			long tempoInicio = System.currentTimeMillis();
			
			v12a20.iniciarV14();
			
	        long tempoFim = System.currentTimeMillis();

	        tempoExecucoes[i] = tempoFim - tempoInicio;

			tempoMedio +=tempoExecucoes[i];
		}
		tempoMedio = tempoMedio/10;
		System.out.println("Tempo de execução médio V1: " + tempoMedio);
		
		resultado.geraResultado(tempoExecucoes, tempoMedio, "VERSÃO 14");
		
		//TESTE VERSÃO 15
        for(int i = 0; i < numExecucoes; i++) {
			long tempoInicio = System.currentTimeMillis();
			
			v12a20.iniciarV15();
			
	        long tempoFim = System.currentTimeMillis();

	        tempoExecucoes[i] = tempoFim - tempoInicio;

			tempoMedio +=tempoExecucoes[i];
		}
		tempoMedio = tempoMedio/10;
		System.out.println("Tempo de execução médio V1: " + tempoMedio);
		
		resultado.geraResultado(tempoExecucoes, tempoMedio, "VERSÃO 15");
		
		//TESTE VERSÃO 16
      for(int i = 0; i < numExecucoes; i++) {
			long tempoInicio = System.currentTimeMillis();
			
			v12a20.iniciarV16();
			
		long tempoFim = System.currentTimeMillis();

		tempoExecucoes[i] = tempoFim - tempoInicio;

			tempoMedio +=tempoExecucoes[i];
		}
		tempoMedio = tempoMedio/10;
		System.out.println("Tempo de execução médio V1: " + tempoMedio);
		
		resultado.geraResultado(tempoExecucoes, tempoMedio, "VERSÃO 16");
	}
}
