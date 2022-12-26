package Studenti;

import java.util.LinkedList;

public class ListaStudenata {
	public LinkedList<Student> lista = new LinkedList<Student>();

	public void dodajStudent(Student a) {
		if (a == null)
			throw new NullPointerException("Student ne sme biti null");
		if (lista.contains(a))
			throw new RuntimeException("Student vec postoji");
		lista.add(a);
	}

	public LinkedList<Student> studentiZadateGodine(int godinaStudija) {
		if (godinaStudija == 0)
			return null;
		LinkedList<Student> novaLista = new LinkedList<Student>();
		for (int i = 0; i < lista.size(); i++)
			if (lista.get(i).getGodinaStudija()== godinaStudija)
				novaLista.add(lista.get(i));
		return novaLista;
	}

}
