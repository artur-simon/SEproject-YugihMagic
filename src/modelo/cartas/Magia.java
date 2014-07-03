package modelo.cartas;

import modelo.DanoGenerico;
import modelo.Tipo;
import modelo.VidaGenerica;

public class Magia extends Carta {
	private DanoGenerico dano;
	
	public Magia(String nome, String descricao, String caracteristica,
			String poder) {
		this.nome = nome;
		this.descricao = descricao;
		this.caracteristicaEspecial = caracteristica;
		this.poder = poder;
		tipoDeCarta = Tipo.MAGIA;
	}
}
