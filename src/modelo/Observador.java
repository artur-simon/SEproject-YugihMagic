package modelo;

public interface Observador {

	void atualizarCriar(String nome,String senha);
	void atualizarLogar(String nome,String senha);
	void atualizarLogin(boolean logou,String usuario);
}
