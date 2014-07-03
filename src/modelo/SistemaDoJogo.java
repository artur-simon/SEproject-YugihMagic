package modelo;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public class SistemaDoJogo implements Observador,Observado {
	private List<Usuario> usuarios;
	private List<Observador> observadores;
	private boolean logado;
	private String nomeUsuarioLogado;
	public SistemaDoJogo() {
		usuarios = new ArrayList<Usuario>();
		observadores = new ArrayList<Observador>();
		logado = false;
		nomeUsuarioLogado = null;
	}

	public void criarUsuario(String nome, String senha, AcervoGenerico acervo) {
		Usuario aInserir = MapeadorUsuario.get(nome);
		
		if (aInserir == null && nome.length()>0) {
			UsuarioFinal novo = new UsuarioFinal(nome, senha);
			novo.setJogador(new JogadorDeCarta(nome, acervo));
			//usuarios.add(novo);
			MapeadorUsuario.putTeste(novo);
			JOptionPane.showMessageDialog(null, "Usuario criado!");
		}
		else
			JOptionPane.showMessageDialog(null, "Usuario Nao criado");
	}

	public Usuario verificarLogin(String nome, String senha) {
		for (Usuario usuario : usuarios) {
			if (usuario.verificarLogin(nome, senha))
				return usuario;
		}
		return null;
	}
	/*
	private Usuario verificarDuplicidadeUsuario(String nome) {
		for (Usuario usuario : usuarios) {
			if (usuario.nome != nome)
				return usuario;
		}
		return null;
	}
	*/
	@Override
	public void atualizarCriar(String nome, String senha) {
		criarUsuario(nome, senha, Acervo.instancia());
		
	}

	@Override
	public void atualizarLogar(String nome, String senha) {
		
		Usuario a = MapeadorUsuario.get(nome); //verificalogin(nome,senha);
		
		if (a != null && a.senha.equalsIgnoreCase(senha)) {
			logado = true;
			nomeUsuarioLogado = nome;
			notificarObservador();
		} else {
			notificarObservador();
		}

	}

	@Override
	public void registrarObservador(Observador o) {
		observadores.add(o);

	}

	@Override
	public void removerObservador(Observador o) {
		int i = observadores.indexOf(o);
		if (i >= 0) {
			observadores.remove(i);
		}
	}

	@Override
	public void notificarObservador() {
		for(int i=0;i<observadores.size();i++){
			Observador observador = (Observador)observadores.get(i);
			observador.atualizarLogin(this.logado,nomeUsuarioLogado);
		}
	}

	@Override
	public void atualizarLogin(boolean logou, String usuario) {
		// TODO Auto-generated method stub
		
	}

}
