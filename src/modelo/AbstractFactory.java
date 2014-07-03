package modelo;

import modelo.cartas.Carta;

public interface AbstractFactory {
	Carta gerarCarta(String nome,String descricao, Tipo tipo, String poder,
			String caracteristica);
}
