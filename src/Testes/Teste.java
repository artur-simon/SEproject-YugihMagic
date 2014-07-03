package Testes;

import javax.swing.JOptionPane;

import modelo.Acervo;
import modelo.AcervoGenerico;
import modelo.Jogador;
import modelo.JogadorDeCarta;
import modelo.Tipo;
import Aplicacao.LeitorDeConfiguracao;

public class Teste extends Thread{


	public static void main(String[] args){
	
		System.out.println("###Teste de leitura do configurador e criacao do JOGADOR (uuuuuu!)####\n");
		AcervoGenerico acervo = Acervo.instancia();
		LeitorDeConfiguracao.readFile(acervo);
		Jogador jogadorBoladao = new JogadorDeCarta("boladaum",acervo);
		System.out.print(jogadorBoladao.visualisarDeck());
		//Codigo abaixo é so pra teste do buscador
		String nome = JOptionPane.showInputDialog("Digite o nome da carta a ser buscada:");
		String tipo = JOptionPane.showInputDialog("Digite o tipo da carta a ser buscada:");
		Tipo a = LeitorDeConfiguracao.selectTipo(tipo);
		JOptionPane.showMessageDialog(null, acervo.retornaCarta(nome, a));
		//Talvez seja melhor retornar uma lista de possibilidades da busca
		
	}

}

//LeitorDeConfiguracao leitor = new LeitorDeConfiguracao();
//leitor.readFile("cardsBase.cfg");
//leitor.testeTodasCartas();
