package zad;

public class Film {
	
	private String naslov = null;
	private int trajanje = 0;
	private int brGledalaca = 0;

	public Film(String naslov, int trajanje, int brGledalaca) {
		super();
		this.naslov = naslov;
		this.trajanje = trajanje;
		this.brGledalaca = brGledalaca;
	}

	public int getTrajanje() {
		return trajanje;
	}

	public void setTrajanje(int trajanje) {
		if (trajanje < 0)
			throw new RuntimeException("Trajanjene sme biti manja od 0");
		this.trajanje = trajanje;
	}

	public int getBrGledalaca() {
		return brGledalaca;
	}

	public void setBrGledalaca(int brGledalaca) {
		if (brGledalaca < 0)
			throw new RuntimeException("Broj gledalaca mora biti veca od 0 ");
		this.brGledalaca = brGledalaca;
	}

	public String getNaslov() {
		return naslov;
	}

	public void setNaslov(String naslov) {
		if (naslov == null)
			throw new RuntimeException("Morate uneti naslov ");
		this.naslov = naslov;
	}

	public double izracunajHonorar() {
		return (this.brGledalaca * 200);
	}

	public boolean neuspesanFilm() {
		if (this.izracunajHonorar() <= 100.000)
			return true;
		else
			return false;
	}

	@Override
	public String toString() {
		return "Film [naslov=" + naslov + ", trajanje =" + trajanje + ", broj gledalaca=" + brGledalaca + "]";
	}
@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (getClass() != obj.getClass())
			return false;
		Film other = (Film) obj;
		if (naslov == null) {
			if (other.naslov != null)
				return false;
		} 
else if (!naslov.equals(other.naslov))
			return false;
		if (trajanje != other.trajanje)
			return false;
		if (brGledalaca != other.brGledalaca)
			return false;
		return true;
	}


}
