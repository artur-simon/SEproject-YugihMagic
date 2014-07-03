package modelo;

import java.util.Collections;
import java.util.List;
import java.util.Stack;

import modelo.cartas.Carta;

public class Baralho implements Deck {
	private static int MAX_TAMANHO = 60, MIN_TAMANHO = 5, MAX_REPETIDAS = 2;
	private Stack<Carta> cartasDoBaralho;
	private ValidadorDeBaralho validador;

	public Baralho() {
		cartasDoBaralho = new Stack<Carta>();
		validador = new ValidadorDeBaralho();
	}

	public void embaralhar() {
		Collections.shuffle(cartasDoBaralho);
	}

	public void adicionarCarta(Carta carta) {
		if (validador.verificarLimitesCartas(this, carta, MAX_REPETIDAS) && tamanho() < MAX_TAMANHO)
			cartasDoBaralho.add(carta);
	}

	public void removerCarta(Carta carta) {
		if (tamanho() > MIN_TAMANHO) {
			int pos = cartasDoBaralho.search(carta);
			cartasDoBaralho.remove(pos);
		}
	}

	/*
	 * Troquei esse metodo na superclasse acho que fica melhor para o baralho
	 * receber já as cartas selecionadas para gera-lo e verificar se é valido
	 */
	public boolean gerarBaralho(List<Carta> cartasSelecionadas) {
		Stack<Carta> aux = cartasDoBaralho;
		for (int i = 0; i < cartasSelecionadas.size(); i++)
			adicionarCarta(cartasSelecionadas.get(i));
		if (!validarBaralho()) {
			cartasDoBaralho = aux;
			return false;
		}
		return true;

	}

	public boolean validarBaralho() {
		if (validador.verificarTotalBaralho(this, MAX_TAMANHO, MIN_TAMANHO))
			return true;
		return false;
	}

	public int tamanho() {
		return cartasDoBaralho.size();
	}

	public Carta pegarCarta(int pos) {

		return cartasDoBaralho.get(pos);
	}

	public Carta pegarCarta(String nome, Tipo tipo) {
		for (Carta carta : cartasDoBaralho) {
			if (carta.retornarNome().compareToIgnoreCase(nome) == 0
					&& carta.retornarTipo().compareTo(tipo) == 0)
				return carta;
		}
		return null;
	}

}
