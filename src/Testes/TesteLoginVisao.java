package Testes;

import visao.MenuPrincipal;
import modelo.Acervo;
import modelo.AcervoGenerico;
import modelo.Observado;
import modelo.Observador;
import modelo.SistemaDoJogo;
import Aplicacao.LeitorDeConfiguracao;

public class TesteLoginVisao {

	public static void main(String[] args) {
		AcervoGenerico acervo = Acervo.instancia();
		LeitorDeConfiguracao.readFile(acervo);
		SistemaDoJogo sistema = new SistemaDoJogo();
		MenuPrincipal menu = new MenuPrincipal();
		menu.setVisible(true);
		Observado criarLogin =  menu.getCriarLogin();
		Observado logar = menu.getLogar();
		criarLogin.registrarObservador(sistema);
		logar.registrarObservador(sistema);
		sistema.registrarObservador((Observador) logar);
	}

}
