package modelo;

import java.io.InputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class Conector implements Hoster{
	private InputStream in;
	private Socket soc;
	private ObjectOutputStream out;
	
	public Conector()
	{
		
	}
	
	public void tentarConexao(String ip, int porta)
	{
		
	}
	
	public void enviarUsuarioParaServidor(Usuario usuario)
	{
		
	}
	public void atualizarDados()
	{
		
	}
	
	@Override
	public Partida criarPartida(String ip, int porta) {
		return null;
	}
}
