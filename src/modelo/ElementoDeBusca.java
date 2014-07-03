package modelo;

public class ElementoDeBusca {
	private int id;
	private Tipo tipo;
	private String nome;
	public ElementoDeBusca(int id, Tipo tipo, String nome)
	{
		this.id = id;
		this.nome = nome;
		this.tipo = tipo;
	}
	
	public int getID()
	{
		return this.id;
	}
	public Tipo getTipo()
	{
		return this.tipo;
	}
	public String getNome()
	{
		return this.nome;
	}
}
