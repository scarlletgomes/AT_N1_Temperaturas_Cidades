package Temperaturas_Cidades.main;

public class Versoes2a10 {
	ControlaThreadCidade configT = new ControlaThreadCidade();
	
	void iniciarV2(){
		System.out.println("TEMPERATURAS CIDADES\n");
		configT.setThreads(2);
	}
	
	void iniciarV3(){
		System.out.println("TEMPERATURAS CIDADES\n");
		configT.setThreads(4);
	}
	
	void iniciarV4(){
		System.out.println("TEMPERATURAS CIDADES\n");
		configT.setThreads(8);
	}
	
	void iniciarV5(){
		System.out.println("TEMPERATURAS CIDADES\n");
		configT.setThreads(16);
	}
	
	void iniciarV6(){
		System.out.println("TEMPERATURAS CIDADES\n");
		configT.setThreads(32);
	}
	
	void iniciarV7(){
		System.out.println("TEMPERATURAS CIDADES\n");
		configT.setThreads(64);
	}
	
	void iniciarV8(){
		System.out.println("TEMPERATURAS CIDADES\n");
		configT.setThreads(80);
	}
	
	void iniciarV9(){
		System.out.println("TEMPERATURAS CIDADES\n");
		configT.setThreads(160);
	}
	
	void iniciarV10(){
		System.out.println("TEMPERATURAS CIDADES\n");
		configT.setThreads(320);
	}
}
