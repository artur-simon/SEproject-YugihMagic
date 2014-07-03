package modelo;

public class UsuarioFinal extends Usuario {

	private Historico historico;
	public UsuarioFinal(String nome,String senha){
		this.nome = nome;
		this.senha = senha;
	}

	public void setJogador(Jogador jogador) {
		this.jogador = jogador;
	}

	@Override
	public Jogador getJogador() {
		return this.jogador;
	}
	
}
