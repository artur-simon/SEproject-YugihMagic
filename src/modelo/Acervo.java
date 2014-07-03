package modelo;

import java.util.LinkedList;
import java.util.List;
import modelo.cartas.Carta;

public class Acervo implements AcervoGenerico {

	private List<Carta> allCards;
	private AbstractFactory cardsFactory;
	private volatile static Acervo unicaInstancia;

	private Acervo() {}

	public static Acervo instancia() {
		synchronized (Acervo.class) {
			if (unicaInstancia == null) {
				unicaInstancia = new Acervo();
				unicaInstancia.instanciaCartas();
			}
		}
		return unicaInstancia;
	}
	
	private void instanciaCartas()
	{
		allCards = new LinkedList<Carta>();
		cardsFactory = new CardsFactory();
		//Tirei o leitor daqui 
	}
	
	public void criarCarta(String nome,String descricao,Tipo tipo, String poder, String caracteristica)
	{
		allCards.add(cardsFactory.gerarCarta(nome, descricao, tipo, poder, caracteristica));
	}

	public Carta retornaCarta(String nome, Tipo tipo) {
		for(Carta carta : allCards)
		{
			if(carta.retornarNome().compareToIgnoreCase(nome) == 0 && carta.retornarTipo().compareTo(tipo)==0)
				return carta;
		}
		return null;
	}

	public List<Carta> mostrarTodasAsCartas() {
		return allCards;
	}

	public void deletarCarta(int posicao) {
		allCards.remove(posicao);
	}

}
