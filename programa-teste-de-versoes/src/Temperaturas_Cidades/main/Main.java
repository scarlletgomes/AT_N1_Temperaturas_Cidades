package Temperaturas_Cidades.main;

public class Main {
	
	private static long[] tempoExecucoes;

	public static void main(String[] args) {
		GeraResultadoTeste resultado = new GeraResultadoTeste();
		OrganizadorVersoes orgV = new OrganizadorVersoes();
		
		
		int numExecucoes = 10;
		int numVersoes = 20;
		long tempoMedio = 0;
		tempoExecucoes = new long[numExecucoes];
		int numThreadsCidade = 0;
		boolean temThreadAno = false;
		
		for(int versao = 1; versao <= numVersoes; versao++) {
			if(versao < 11) {
				temThreadAno = false;
			}else {
				temThreadAno = true;
			}
			if(versao == 1 || versao == 11) {
				numThreadsCidade = 0;
			}else {
				if(versao == 2 || versao == 12) {
					numThreadsCidade = 2;
				}else {
					if(versao == 8 || versao == 18) {
						numThreadsCidade = 80;
					}else {
						numThreadsCidade += numThreadsCidade;
					}
				}
			}
			for(int teste = 0; teste < numExecucoes; teste++) {
				long tempoInicio = System.currentTimeMillis();
				orgV.iniciarVersoes(numThreadsCidade, temThreadAno);
				long tempoFim = System.currentTimeMillis();
				tempoExecucoes[teste] = tempoFim - tempoInicio;
				tempoMedio +=tempoExecucoes[teste];
			}
			tempoMedio = tempoMedio/numExecucoes;
			resultado.geraResultado(tempoExecucoes, tempoMedio, "VERSÃO " + versao);
			tempoMedio = 0;
		}	
	}
}
