package Temperaturas_Cidades.main;

public class Versoes2a10 {
	ControlaThreadCidade configT = new ControlaThreadCidade();
	
	void iniciarV2(){
		System.out.println("TEMPERATURAS CIDADES\n");
		configT.setThreads(2, false);
	}
	
	void iniciarV3(){
		System.out.println("TEMPERATURAS CIDADES\n");
		configT.setThreads(4, false);
	}
	
	void iniciarV4(){
		System.out.println("TEMPERATURAS CIDADES\n");
		configT.setThreads(8, false);
	}
	
	void iniciarV5(){
		System.out.println("TEMPERATURAS CIDADES\n");
		configT.setThreads(16, false);
	}
	
	void iniciarV6(){
		System.out.println("TEMPERATURAS CIDADES\n");
		configT.setThreads(32, false);
	}
	
	void iniciarV7(){
		System.out.println("TEMPERATURAS CIDADES\n");
		configT.setThreads(64, false);
	}
	
	void iniciarV8(){
		System.out.println("TEMPERATURAS CIDADES\n");
		configT.setThreads(80, false);
	}
	
	void iniciarV9(){
		System.out.println("TEMPERATURAS CIDADES\n");
		configT.setThreads(160, false);
	}
	
	void iniciarV10(){
		System.out.println("TEMPERATURAS CIDADES\n");
		configT.setThreads(320, false);
	}

}
