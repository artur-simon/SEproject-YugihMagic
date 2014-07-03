package modelo.cartas;

import modelo.DanoGenerico;
import modelo.Tipo;
import modelo.VidaGenerica;

public class Monstro extends Carta {

	private DanoGenerico dano;
	private VidaGenerica vida;
	
	public Monstro(String nome, String descricao, String caracteristica,
			String poder) {
		this.nome = nome;
		this.descricao = descricao;
		this.caracteristicaEspecial = caracteristica;
		this.poder = poder;
		tipoDeCarta = Tipo.MONSTRO;
	}

}
