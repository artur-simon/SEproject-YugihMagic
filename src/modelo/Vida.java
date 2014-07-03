package modelo;

public class Vida implements VidaGenerica {

	private int quantidade;

	public Vida(int valor) {
		quantidade = valor;
	}

	public Vida() { //Construtor com valor default
		quantidade = 30;
	}

	public int retornaQuantidade() {
		return quantidade;
	}

	public void retiraVida(DanoGenerico dano) {
		quantidade = (quantidade - dano.retornaDanoAtual());
	}

	public boolean estaMorto() {
		if (quantidade <=0)
			return true;
		return false;
	}

}
