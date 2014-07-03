package Testes;

import modelo.Acervo;
import modelo.AcervoGenerico;
import modelo.Jogador;
import modelo.JogadorDeCarta;
import modelo.SistemaDoJogo;
import modelo.Usuario;
import modelo.cartas.Carta;
import Aplicacao.LeitorDeConfiguracao;

public class TesteUsuario {

	public static void main(String[] args) {
		AcervoGenerico acervo = Acervo.instancia();
		LeitorDeConfiguracao.readFile(acervo);

		verificarLogin(acervo);
	}

	public static void verificarLogin(AcervoGenerico acervo) {
		SistemaDoJogo sistema = new SistemaDoJogo();
		String nome = "jogador boladao", senha = "password";
		sistema.criarUsuario("Nathan", "fdp", acervo);
		sistema.criarUsuario("valdemir", "macaco", acervo);
		sistema.criarUsuario(nome, senha, acervo);
		sistema.criarUsuario("Patricia", "villain", acervo);
		sistema.criarUsuario("Tomas", "Turbando", acervo);
		sistema.criarUsuario("admin", "password", acervo);

		Usuario logado = sistema.verificarLogin(nome, senha);
		Usuario notLogado = sistema.verificarLogin("Nahtan", "pdf");

		System.out.println(logado);
		System.out.println(logado.getJogador());

		for (Carta carta : acervo.mostrarTodasAsCartas()) {
			logado.getJogador().adicionaCartaAoDeck(carta.retornarNome(),
					carta.retornarTipo());
			logado.getJogador().adicionaCartaAoDeck(carta.retornarNome(),
					carta.retornarTipo());
		}
		System.out.println(logado.getJogador().visualisarDeck().size());
	}
}