package Studenti;

public class Student {
	private String imeIPrezime= null;
	private int godinaStudija= 0;
	private int brojESPB= 0;

	public Student(String imeIPrezime, int godinaStudija, int brojESPB) {
		super();
		this.imeIPrezime= imeIPrezime;
		this.godinaStudija= godinaStudija;
		this.brojESPB= brojESPB;
	}

	public int getGodinaStudija() {
		return godinaStudija;
	}

	public void setGodinaStudija(int godinaStudija) {
		if (godinaStudija< 0 || godinaStudija>4)
			throw new RuntimeException("Godina studija ne sme biti manja od 0 i veca od 4");
		this.godinaStudija= godinaStudija;
	}

	public int getBrojESPB() {
		return brojESPB;
	}

	public void setBrojESPB(int brojESPB) {
		if (brojESPB< 0 || brojESPB> 240)
			throw new RuntimeException("Broj ESPB mora biti veci od 0 i manji od 240");
		this.brojESPB= brojESPB;
	}

	public String getImeIPrezime() {
		return imeIPrezime;
	}

	public void setImeIPrezime(String imeIPrezime) {
		if (imeIPrezime == null)
			throw new RuntimeException("Morate uneti ime i prezime studenta");
		this.imeIPrezime= imeIPrezime;
	}

	public double prosekESPB() {
		return (this.brojESPB / this.godinaStudija);
	}

	public boolean redovniDrugaGod() {
		if (this.brojESPB > 48 && this. brojESPB <= 120)
			return true;
		else
			return false;
	}

	@Override
	public String toString() {
		return "Student [ime i prezime=" + imeIPrezime+ ", godina studija =" + godinaStudija + ", broj ESPB =" + brojESPB+ "]";
	}

}
