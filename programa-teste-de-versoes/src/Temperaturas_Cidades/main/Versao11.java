package Temperaturas_Cidades.main;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import Entidades.Ano;
import Entidades.Cidade;
import Entidades.Mes;

public class Versao11 {
	List<Cidade> cidades = new ArrayList<Cidade>();

	Versao11(){}
	
	void organizarCidades(){
		LeitorCSV lcsv = new LeitorCSV();
		File pasta = new File("temperaturas_cidades.arquivos");
		
		for(File file:pasta.listFiles()) {
			cidades.add(lcsv.lerCSV(pasta + "\\" + file.getName(), true));
		}
	}
	
	void iniciarV11() {
        organizarCidades();
        System.out.println("TEMPERATURAS CIDADES\n");

        for (Cidade cidade : cidades) {
            System.out.println("Cidade: " + cidade.getNomeCidade() + "\nPaís: " + cidade.getPais());

            for (Ano ano : cidade.getAnos()) {
                System.out.println("Ano: " + ano.getNumeroAno());

                for (Mes mes : ano.getMeses()) {
                    System.out.println("  Mês: " + mes.getNumero());
                    System.out.printf("    Média do mês: %.2f\n", mes.getMediaTempMensal());
                    System.out.printf("    Máxima do mês: %.2f\n", mes.getTempMaxima());
                    System.out.printf("    Mínima do mês: %.2f\n", mes.getTempMinima());
                }
                System.out.println("\n");
            }
        }
	}

	
}
