package modelo;

import java.util.List;

import modelo.cartas.Carta;

public interface AcervoGenerico {
	void criarCarta(String nome,String descricao,Tipo tipo, String poder, String caracteristica);
	Carta retornaCarta(String nome,Tipo tipo);
	List<Carta> mostrarTodasAsCartas();
	void deletarCarta(int posicao);
	
}
