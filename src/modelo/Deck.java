package modelo;

import java.util.List;

import modelo.cartas.Carta;

public interface Deck {
	void embaralhar();
	void adicionarCarta(Carta carta);
	void removerCarta(Carta carta);
	boolean gerarBaralho(List<Carta> cartasSelecionadas); //Mudado
	boolean validarBaralho();
	Carta pegarCarta(int pos);
	int tamanho();
	Carta pegarCarta(String nome, Tipo tipo);

}
