package modelo;

import java.io.ObjectInputStream.GetField;

public abstract class Usuario {

	protected String nome;
	protected String senha;
	protected int ipAtual;
	protected Jogador jogador;

	public void conectar(int IP, int Porta) {
		// TODO INTERA��O DOX
	}

	public boolean verificarLogin(String login, String senha) {
		return (this.senha.compareTo(senha) == 0);
	}

	public void trocarSenha(String senha) {
		this.senha = senha;
	}

	public void desconectar() {
		// TODO INTERA��O DOX
	};

	public abstract void setJogador(Jogador jogador);
	public abstract Jogador getJogador();

	public String toString() {
		return "login = " + nome + "\n" + "senha = " + senha + "\n";
	}
	public String getLogin() {
		return nome;
	}
	public String getSenha(){
		return senha;
	}
}
