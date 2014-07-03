package modelo;

public class Dano implements DanoGenerico {

	private int danoDefault;
	private int danoAlterado;

	public Dano(int valor) {
		danoDefault = valor;
		danoAlterado = valor;
	}

	public int retornaDanoAtual() {
		return danoAlterado;
	}

	public void aumentaDano(int quantidade) {
		danoAlterado += quantidade;
	}

	public void resetarDano() {
		danoAlterado = danoDefault;
	}

}
