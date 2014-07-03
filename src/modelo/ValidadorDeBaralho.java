package modelo;

import modelo.cartas.Carta;

public class ValidadorDeBaralho {

	public boolean verificarLimitesCartas(Deck baralho, Carta cartaComparada,
			int maxCartasRepetidas) {
		Carta cartaAtual;
		int numeroRepeticoes = 0;
		for (int i = 0; i < baralho.tamanho(); i++) {
			cartaAtual = baralho.pegarCarta(i);
			if (comparaCarta(cartaAtual, cartaComparada))
				numeroRepeticoes++;
		}
		if (numeroRepeticoes < maxCartasRepetidas || baralho.tamanho() == 0 )
			return true;
		return false;

	}

	public boolean verificarTotalBaralho(Deck baralho, int limitMax,
			int limiteMin) {
		if (limiteMin <= baralho.tamanho() && baralho.tamanho() < limitMax) {
			return true;
		}
		return false;
	}

	private boolean comparaCarta(Carta c1, Carta c2) {
		return c1.equals(c2);
	}
}
