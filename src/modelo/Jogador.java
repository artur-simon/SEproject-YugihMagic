package modelo;

import java.util.List;

import modelo.cartas.Carta;

public interface Jogador {
	public List<Carta> visualisarMao();

	public List<Carta> visualisarDeck();

	public Carta buscarCartaNoDeck(String nome, Tipo tipo);

	public void adicionaCartaAoDeck(String nome, Tipo tipo);

	public void removeCartaDoDeck(String nome, Tipo tipo);

	public void alterarEstado(Estado estado);

	public void adicionarNaMesa(String nome, Tipo tipo);

	public void atacar();

	public void defender();
	
	public boolean criarNovoBaralho(List<Carta> cartasSelecionadas);
}
