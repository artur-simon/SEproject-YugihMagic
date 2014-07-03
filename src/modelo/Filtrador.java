package modelo;

import java.util.ArrayList;
import java.util.List;

import modelo.cartas.Carta;

public class Filtrador {
	
	public static List<Carta> selecionarFiltro(ElementoDeBusca elemento)
	{
		int id = elemento.getID();
		Tipo tipo = elemento.getTipo();
		String nome = elemento.getNome();
		List<Carta> listaDeCarta = new ArrayList<Carta>();
				
		if (id != 0)
		{
			Carta e = MapeadorCartaAcervo.getCarta(id);
			if(e != null)
			listaDeCarta.add(e);
		}
		else
		{
			List<Carta> e = MapeadorCartaAcervo.getCartas(tipo, nome);
			if(e != null)
				for(int i = 0; i<e.size(); i++)
					listaDeCarta.add(e.get(i));
		}
		return listaDeCarta;	
	}
}
