package modelo;

import modelo.cartas.*;


public class CardsFactory implements AbstractFactory{

	public CardsFactory(){
		
	}
	public Carta gerarCarta(String nome,String descricao, Tipo tipo, String poder,
			String caracteristica) {
		switch (tipo) {
		case MONSTRO:
			return criarMonstros(nome,descricao,poder,caracteristica);
		case ATRIBUTO:
			return criarAtributos(nome,descricao,poder,caracteristica);
		case MAGIA:
			return criarMagias(nome,descricao,poder,caracteristica);
		case ENCANTAMENTO:
			return criarEncantamento(nome,descricao,poder,caracteristica);
		}
		return null;
	}

	private Carta criarEncantamento(String nome, String descricao, String poder,
			String caracteristica) {
		Carta encan = new Encantamento(nome,descricao,poder,caracteristica);
		return encan;
	}

	private Carta criarMagias(String nome, String descricao, String poder,
			String caracteristica) {
		Carta magia = new Magia(nome,descricao,poder,caracteristica);
		return magia;
	}

	private Carta criarAtributos(String nome, String descricao, String poder,
			String caracteristica) {
		Carta atributo = new Atributo(nome,descricao,poder,caracteristica);
		return atributo;
	}

	private Carta criarMonstros(String nome, String descricao, String poder,
			String caracteristica) {
		Carta monstro = new Monstro(nome,descricao,poder,caracteristica);
		return monstro;
	}

	
}
