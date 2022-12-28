package stan;

import java.util.LinkedList;

public class AgencijaProdajeStanova {
	public static LinkedList<Stan> lista = new LinkedList<Stan>();

	public static void dodajStan(Stan a) {
		if (a == null)
			throw new NullPointerException("Stan ne sme biti null");
		if (lista.contains(a))
			throw new RuntimeException("Stan vec postoji");
		lista.add(a);
	}

	public static LinkedList<Stan> pronadjiStan(String adresa) {
		if(adresa == null)
			return null;
		LinkedList<Stan> novaLista = new LinkedList<Stan>();
		for (int i = 0; i < lista.size(); i++)
			if (lista.get(i).getAdresa().equals(adresa))
				novaLista.add(lista.get(i));
		return novaLista;
		}
}
