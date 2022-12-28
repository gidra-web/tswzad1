package zad;

import java.util.LinkedList;

public class ProdukcijaFilma {
	public static LinkedList<Film> film = new LinkedList<Film>();

	public static void dodajFilm(Film a) {
		if (a == null)
			throw new NullPointerException("Film ne sme biti null");
		if (film.contains(a))
			throw new RuntimeException("Film vec postoji");
		film.add(a);
	}

	public static LinkedList<Film> pronadjiFilm(String naslov) {
		if (naslov == null)
			return null;
		LinkedList<Film> novaLista = new LinkedList<Film>();
		for (int i = 0; i < film.size(); i++)
			if (film.get(i).getNaslov().equals(naslov))
				novaLista.add(film.get(i));
		return novaLista;
	}

}
