package student;

public class Student {
	private String imie;
	private String nazwisko;
	private String dataUrodzin;
	private String kierunekStudiow;

	public String uczelnia;

	public Student() {

	}

	public Student(String imie, String nazwisko) {
		this.imie = imie;
		this.nazwisko = nazwisko;
	}

	public String getDataUrodzin() {
		return dataUrodzin;
	}

	public String getImie() { // zwraca imie
		return imie;
	}

	public String getKierunekStudiow() {
		return kierunekStudiow;
	}

	public String getNazwisko() {
		return nazwisko;
	}

	public void setDataUrodzin(String dataUrodzin) {
		this.dataUrodzin = dataUrodzin;
	}

	public void setImie(String imie) {// ustawia imie
		this.imie = imie;
	}

	public void setKierunekStudiow(String kierunekStudiow) {
		this.kierunekStudiow = kierunekStudiow;
	}

	public void setNazwisko(String nazwisko) {
		this.nazwisko = nazwisko;
	}

	@Override
	public String toString() {
		return imie + " " + nazwisko;
	}
}
