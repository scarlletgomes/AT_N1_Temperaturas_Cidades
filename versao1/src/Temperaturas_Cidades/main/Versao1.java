package Temperaturas_Cidades.main;

import Entidades.Ano;
import Entidades.Cidade;
import Entidades.Mes;

public class Versao1 {
	Versao1(){}
	
	void iniciarV1() {
		
        Organizador org = new Organizador();

        org.organizarCidades();
        System.out.println("TEMPERATURAS CIDADES\n");

        for (Cidade cidade : org.cidades) {
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
