package modelo.cartas;

import modelo.Tipo;

public abstract class Carta {
	/*
	 * !! Tem que verificar se PODER vai ser string, como vai ser feito para
	 * atribuir as caracteristicas das cartas.
	 */
	protected String nome, descricao, caracteristicaEspecial, poder;
	protected Tipo tipoDeCarta;

	public String retornarNome() {
		return nome;
	}

	public String retornarDescricao() {
		return descricao;
	}

	public String retornarPoder() {
		return poder;
	}

	public Tipo retornarTipo() {
		return tipoDeCarta;
	}

	public boolean equals(Carta c2) {
		if (nome == c2.nome && descricao == c2.descricao && poder == c2.poder
				&& tipoDeCarta == c2.tipoDeCarta)
			return true;
		return false;
	}

	public String toString() {
		String dados = new String();
		dados += ("Nome: " + nome + "\n");
		dados += ("Tipo: " + tipoDeCarta.toString() + "\n");
		dados += ("Descricao: " + descricao + "\n");
		dados += ("Caracteristica: " + caracteristicaEspecial + "\n");
		dados += ("Poder: " + poder + "\n");
		return dados;
	}
}
