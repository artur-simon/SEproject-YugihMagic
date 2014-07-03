package modelo;

import java.util.LinkedList;
import java.util.List;

import modelo.cartas.Carta;

public class JogadorDeCarta implements Jogador {
	// TODO nao implementado TOTALMENTE ainda :/
	// Deck deck;
	private Deck deck;
	private List<Carta> mao;
	private String nome;
	private VidaGenerica vida;
	private Estado estado;
	private AcervoGenerico acervo;

	public AcervoGenerico getAcervo() {
		return acervo;
	}

	public JogadorDeCarta(String nome, AcervoGenerico acervo) {
		deck = new Baralho();
		this.nome = nome;
		this.vida = new Vida();
		this.acervo = acervo;
	}

	public List<Carta> visualisarMao() {
		return mao;
	}

	public List<Carta> visualisarDeck() {
		List<Carta> foo = new LinkedList<Carta>();
		for(int x = 0; x < deck.tamanho(); x++) {
			foo.add(deck.pegarCarta(x));
		}
		return foo;
	}

	public Carta buscarCartaNoDeck(String nome, Tipo tipo) {
		return deck.pegarCarta(nome, tipo);
	}

	public void adicionaCartaAoDeck(String nome, Tipo tipo) {// Talvez tenha que
																// ser boolean
		Carta carta = acervo.retornaCarta(nome, tipo); // Escolhe uma carta do
														// acervo para
														// adicionar...]
		if (carta != null)
			deck.adicionarCarta(carta);
	}

	public void removeCartaDoDeck(String nome, Tipo tipo) {
		Carta carta = deck.pegarCarta(nome, tipo); // Escolhe uma carta do
													// acervo para adicionar...
		if(carta != null)
		deck.removerCarta(carta);
	}

	public void alterarEstado(Estado estado) {
		this.estado = estado;
	}

	public void adicionarNaMesa(String nome, Tipo tipo) {
		// TODO

	}

	public void atacar() {
		// TODO

	}

	public void defender() {
		// TODO

	}

	public String retornarNome() {
		return nome;
	}

	public boolean criarNovoBaralho(List<Carta> cartasSelecionadas) {
		return deck.gerarBaralho(cartasSelecionadas);
	}

}
