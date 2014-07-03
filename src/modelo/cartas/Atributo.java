package modelo.cartas;

import modelo.Tipo;

public class Atributo extends Carta {

	public Atributo(String nome, String descricao, String caracteristica,
			String poder) {
		this.nome = nome;
		this.descricao = descricao;
		this.caracteristicaEspecial = caracteristica;
		this.poder = poder;
		tipoDeCarta = Tipo.ATRIBUTO;
	}
}
