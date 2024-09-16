package Temperaturas_Cidades.main;

public class Main1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Versao1 v1 = new Versao1();
		double tempoMedio = 0;
		
		
		//TESTE VERSÃO 1
		for(int i = 0; i < 9; i++) {
			long tempoInicio = System.currentTimeMillis();
			
			v1.iniciarV1();
			
			// Captura o tempo final em milissegundos
	        long tempoFim = System.currentTimeMillis();

	        // Calcula o tempo total de execução
	        long tempoExecucao = tempoFim - tempoInicio;

			tempoMedio += tempoExecucao;
		}
		tempoMedio = tempoMedio/10;
		System.out.println("Tempo de execução médio V1: " + tempoMedio);
		//FUNÇÃO PARA COLOCAR O RESULTADO EM UM ARQUIVO TXT
	}
	
	//IMPLEMENTAR TESTE DAS OUTRAS VERSÕES...
	//(AS OUTRAS VERSÕES, DE 2 A 10, DEVEM FICAR EM UM ARQUIVO SÓ...)

}
