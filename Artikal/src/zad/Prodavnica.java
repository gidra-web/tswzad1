package zad;

import java.util.LinkedList;

public class Prodavnica {

	public static LinkedList<Artikal> lista = new LinkedList<Artikal>();

	public static void dodajArtikal(Artikal a) {
		if (a == null)
			throw new NullPointerException("Artikal ne sme biti null");
		if (lista.contains(a))
			throw new RuntimeException("Artikal vec postoji");
		lista.add(a);
	}

	public static LinkedList<Artikal> pronadjiArtikle(Artikal a) {
		if (a.getCena() == 0)
			return null;
		LinkedList<Artikal> novaLista = new LinkedList<Artikal>();
		for (int i = 0; i < lista.size(); i++)
			if (lista.get(i).viseOdJedan()==true)
				novaLista.add(lista.get(i));
		return novaLista;
	}
	
}
