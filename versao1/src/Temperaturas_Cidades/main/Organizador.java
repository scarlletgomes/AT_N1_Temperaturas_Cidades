package Temperaturas_Cidades.main;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import Entidades.Cidade;

public class Organizador {
	List<Cidade> cidades = new ArrayList<Cidade>();
	
	Organizador(){
		
	}
	
	void organizarCidades(){
		LeitorCSV lcsv = new LeitorCSV();
		File pasta = new File("C:\\Users\\tcoel\\OneDrive\\Área de Trabalho\\Projetos\\AT_N1_Temperaturas_Cidades\\versao1\\temperaturas_cidades.arquivos");
		
		for(File file:pasta.listFiles()) {
			cidades.add(lcsv.lerCSV(pasta + "\\" + file.getName())); 
		}
	}
}
