package Aplicacao;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;

import modelo.AbstractFactory;
import modelo.Acervo;
import modelo.AcervoGenerico;
import modelo.CardsFactory;
import modelo.Tipo;
import modelo.cartas.Carta;

public class LeitorDeConfiguracao {

	private static BufferedReader reader;
	private static final String caminhoConfiguracao = "cardsBase.cfg";

	private LeitorDeConfiguracao() {
	}

	public static void readFile(AcervoGenerico acervo) {
		try {
			String linhaAtual, nome = null, descricao = null, tipo = null, poder = null, caracteristica = null;
			int line = 0;
			InputStream input = LeitorDeConfiguracao.class.getClassLoader()
					.getResourceAsStream(caminhoConfiguracao);
			reader = new BufferedReader(new InputStreamReader(input));
			while ((linhaAtual = reader.readLine()) != null) {
				if (!linhaAtual.contains("#")) {
					switch (line) {
					case 0:
						nome = linhaAtual;
						line++;
						break;
					case 1:
						descricao = linhaAtual;
						line++;
						break;
					case 2:
						tipo = linhaAtual;
						line++;
						break;
					case 3:
						poder = linhaAtual;
						line++;
						break;
					case 4:
						caracteristica = linhaAtual;
						acervo.criarCarta(nome, descricao, selectTipo(tipo),
								poder, caracteristica);
						line = 0;
						break;
					}
				}

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static Tipo selectTipo(String tipo) {
		if (tipo.equalsIgnoreCase(Tipo.MONSTRO.toString()))
			return Tipo.MONSTRO;
		else if (tipo.equalsIgnoreCase(Tipo.ATRIBUTO.toString()))
			return Tipo.ATRIBUTO;
		else if (tipo.equalsIgnoreCase(Tipo.MAGIA.toString()))
			return Tipo.MAGIA;
		else
			return Tipo.ENCANTAMENTO;
	}

}
