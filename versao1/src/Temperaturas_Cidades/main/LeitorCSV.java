package Temperaturas_Cidades.main;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


import Entidades.Ano;
import Entidades.Cidade;
import Entidades.Dia;
import Entidades.Mes;

public class LeitorCSV {
	LeitorCSV(){}
	
	Cidade lerCSV(String path) {
	    int anoAux = 0;
	    int mesAux = 0;
	    Cidade cidade = null;
	    Ano ano = null;
	    Mes mes = null;
	    
	    try (BufferedReader br = new BufferedReader(new FileReader(path))) {
	        String line = br.readLine(); 
	        line = br.readLine(); 
	        
	        while (line != null) {
	            String[] vect = line.split(",");
	            String pais = vect[0];
	            String nomeCidade = vect[1];
	            int numMes = Integer.parseInt(vect[2]);
	            int numDia = Integer.parseInt(vect[3]);
	            int numAno = Integer.parseInt(vect[4]);
	            double tempMediaDiaria = Double.parseDouble(vect[5]);
	            
	            if (cidade == null) {
	                cidade = new Cidade(pais, nomeCidade);
	                ano = new Ano(numAno);
	                mes = new Mes(numMes);
	                anoAux = numAno;
	                mesAux = numMes;
	            }
	   
	            if (numAno != anoAux) {
	                ano.getMeses().add(mes); 
	                cidade.getAnos().add(ano);
	                
	                ano = new Ano(numAno);
	                mes = new Mes(numMes);
	                anoAux = numAno;
	                mesAux = numMes;
	            }
	            
	            if (numMes != mesAux) {
	                ano.getMeses().add(mes); 
	                
	                mes = new Mes(numMes);
	                mesAux = numMes;
	            }
	            
	            Dia dia = new Dia(numDia, tempMediaDiaria);
	            mes.adicionarDia(dia); 
	            
	            line = br.readLine();
	        }
	        
	        if (mes != null) {
	            ano.getMeses().add(mes);
	        }
	        if (ano != null) {
	            cidade.getAnos().add(ano);
	        }
	        
	    } catch (IOException e) {
	        System.out.println("Error: " + e.getMessage());
	    }
	    
	    return cidade;
	}
}
