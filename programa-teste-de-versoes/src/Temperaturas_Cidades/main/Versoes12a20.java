package Temperaturas_Cidades.main;

public class Versoes12a20 {
	ControlaThreadCidade configT = new ControlaThreadCidade();
	
	void iniciarV12(){
		System.out.println("TEMPERATURAS CIDADES\n");
		configT.setThreads(2, true);
	}
	
	void iniciarV13(){
		System.out.println("TEMPERATURAS CIDADES\n");
		configT.setThreads(4, true);
	}
	
	void iniciarV14(){
		System.out.println("TEMPERATURAS CIDADES\n");
		configT.setThreads(8, true);
	}
	
	void iniciarV15(){
		System.out.println("TEMPERATURAS CIDADES\n");
		configT.setThreads(16, true);
	}
	
	void iniciarV16(){
		System.out.println("TEMPERATURAS CIDADES\n");
		configT.setThreads(32, true);
	}
	
	void iniciarV17(){
		System.out.println("TEMPERATURAS CIDADES\n");
		configT.setThreads(64, true);
	}
	
	void iniciarV18(){
		System.out.println("TEMPERATURAS CIDADES\n");
		configT.setThreads(80, true);
	}
	
	void iniciarV19(){
		System.out.println("TEMPERATURAS CIDADES\n");
		configT.setThreads(160, true);
	}
	
	void iniciarV20(){
		System.out.println("TEMPERATURAS CIDADES\n");
		configT.setThreads(320, true);
	}

}
