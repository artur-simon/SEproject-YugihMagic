package Testes;

import java.util.LinkedList;
import java.util.List;

import javax.swing.JOptionPane;

import modelo.Acervo;
import modelo.AcervoGenerico;
import modelo.Jogador;
import modelo.JogadorDeCarta;
import modelo.Tipo;
import modelo.cartas.Carta;
import Aplicacao.LeitorDeConfiguracao;

public class TesteCriacaoDeck {

	public static void main(String[] args) {
		AcervoGenerico acervo = Acervo.instancia();
		LeitorDeConfiguracao.readFile(acervo);
		Jogador jogadorBoladao = new JogadorDeCarta("boladadinho", acervo);
		List<Carta> listaTemporariaCartas = new LinkedList<Carta>();
		boolean continuar = true;
		while (continuar) {

			System.out.println(acervo.mostrarTodasAsCartas());

			String nome = JOptionPane
					.showInputDialog("Nome da carta para adicionar no baralho:");
			Object[] possibilities = { "MONSTRO", "ATRIBUTO", "MAGIA",
					"ENCANTAMENTO" };
			String tipo = (String) JOptionPane.showInputDialog(null,
					"Escolha o tipo da carta:\n", "Tipo da Carta",
					JOptionPane.PLAIN_MESSAGE, null, possibilities, "MONSTRO");
			Tipo tipoDaCarta = LeitorDeConfiguracao.selectTipo(tipo);
			if ((acervo.retornaCarta(nome, tipoDaCarta) != null))
				listaTemporariaCartas.add(acervo
						.retornaCarta(nome, tipoDaCarta));
			System.out.println(listaTemporariaCartas.get(listaTemporariaCartas.size()-1));
			int resposta = JOptionPane
					.showConfirmDialog(
							null,
							"Continuar Montando?\nObs: baralho aceitavel min 40 cartas",
							"Continuar?", JOptionPane.YES_NO_OPTION);
			if (resposta == JOptionPane.NO_OPTION) {
				continuar = false;
				boolean isFail = jogadorBoladao
						.criarNovoBaralho(listaTemporariaCartas);
				if (isFail)
					System.out.println("BARALHO VALIDADO COM SUCESSO!");
				else
					System.out.println("!BARALHO NÃO VALIDADO!");
			}
		}
	}
}
