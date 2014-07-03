package modelo;

public interface Estado {
		public void comprarCarta(JogadorDeCarta jogador);
		public void adicionarCartaAMesa(JogadorDeCarta jogador);
		public void atacar(JogadorDeCarta jogador);
		public void defender(JogadorDeCarta jogador);
}
