package student;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Menu {
	public static void main(String[] args) throws FileNotFoundException {
		Menu menu = new Menu();

		menu.glownaPetla();
	}

	private final Scanner menu = new Scanner(System.in); // służy do odczytywania z klawiatury

	private ArrayList<Student> tablicaStudentow = new ArrayList<Student>();

	public void glownaPetla() throws FileNotFoundException {
		petla: while (true) {
			wypiszMenu();

			int obiad = menu.nextInt();

			switch (obiad) {
			case 1:
				odczytListyStudentow();
				break;
			case 2:
				zapisListyStudentow();
				break;
			case 3:
				dodajStudenta();
				break;
			case 4:
				usunStudenta();
				break;
			case 5:
				wypiszListeNaEkran();
				break;
			case 6:
				szukajStudenta();
				break;
			case 7:
				edytuj();
				break;
			case 9:

				break petla;

			}

		}
		System.out.println("Koniec programu");
		menu.close();
	}

	private boolean czyListaPusta() {
		for (Student student : tablicaStudentow) {
			if (student != null) {
				return false;
			}
		}
		return true;
	}

	private void dodajStudenta()

	{
		System.out.println("Podaj imię");
		String imie = menu.next();
		System.out.println("Podaj nazwisko");
		String nazwisko = menu.next();
		System.out.println("Podaj datę urodzenia");
		String data = menu.next();
		System.out.println("podaj kierunek studiów");
		String kierunek = menu.next();
		System.out.println("podaj uczelnię");
		String uczelnia = menu.next();

		Student nowyStudent = new Student();

		nowyStudent.setImie(imie);
		nowyStudent.setNazwisko(nazwisko);
		nowyStudent.setDataUrodzin(data);
		nowyStudent.setKierunekStudiow(kierunek);
		nowyStudent.uczelnia = uczelnia;
		tablicaStudentow.add(nowyStudent);

	}

	private void edytuj() {
		int indexStudentEdytowany;
		if (czyListaPusta()) {
			System.out.println("lista jest pusta");
			return;
		}
		do {
			wypiszListeNaEkran();
			System.out.println("Podaj numer studenta do edytowania");

			indexStudentEdytowany = menu.nextInt() - 1;

		} while (indexStudentEdytowany < 0 || indexStudentEdytowany > tablicaStudentow.size() - 1);

		Student studentEdytowany = tablicaStudentow.get(indexStudentEdytowany);
		int nazwa;
		do {
			System.out.println("1.imię");
			System.out.println("2.nazwisko");
			System.out.println("3.data urodzenia");
			System.out.println("4.kierunek studiów");
			System.out.println("5.uczelnia");
			System.out.println("Podaj co chcesz edytować");
			nazwa = menu.nextInt();
		} while (nazwa < 1 || nazwa > 5);

		System.out.println("podaj nową wartość");
		String nowaWartosc = menu.next();
		switch (nazwa) {
		case 1:
			studentEdytowany.setImie(nowaWartosc);
			break;
		case 2:
			studentEdytowany.setNazwisko(nowaWartosc);
			break;
		case 3:
			studentEdytowany.setDataUrodzin(nowaWartosc);
		case 4:
			studentEdytowany.setKierunekStudiow(nowaWartosc);
			break;
		case 5:
			studentEdytowany.uczelnia = nowaWartosc;
			break;

		}

	}

	private void odczytListyStudentow() throws FileNotFoundException

	{
		System.out.println("Podaj nazwę pliku");
		String nazwaPliku = menu.next();

		StudentReader odczyt = new StudentReader();
		tablicaStudentow = odczyt.odczytajStudentow(nazwaPliku);
	}

	private void szukajStudenta() {
		System.out.println("Podaj szukan� fraze");

		String szukana = menu.next().toLowerCase();
		for (Student wyszukiwany : tablicaStudentow) {
			if (wyszukiwany != null) {
				if (wyszukiwany.getImie().toLowerCase().contains(szukana)
						|| wyszukiwany.getNazwisko().toLowerCase().contains(szukana)
						|| wyszukiwany.getKierunekStudiow().toLowerCase().contains(szukana)
						|| wyszukiwany.uczelnia.toLowerCase().contains(szukana)) {
					System.out.println(wyszukiwany.getImie() + " " + wyszukiwany.getNazwisko() + " "
							+ wyszukiwany.getKierunekStudiow() + " " + wyszukiwany.uczelnia);
				}
			}
		}
	}

	private void usunStudenta() {
		// wypiszListeNaEkran();
		// System.out.println("Podaj numer studenta do usuni�cia");
		// int indeks = menu.nextInt();
		int indexStudentUsuwany;
		if (czyListaPusta()) {
			System.out.println("lista jest pusta");
			return;
		}
		do {
			wypiszListeNaEkran();
			System.out.println("Podaj numer studenta do usuniecia");

			indexStudentUsuwany = menu.nextInt();

		} while (indexStudentUsuwany < 1 || indexStudentUsuwany > tablicaStudentow.size());
		tablicaStudentow.remove(indexStudentUsuwany - 1);

	}

	private void wypiszListeNaEkran() {

		int indeks = 1;
		for (Student student : tablicaStudentow) {
			if (student != null) {

				System.out.println(indeks + ". " + student.getImie() + " " + student.getNazwisko() + " "
						+ student.getDataUrodzin() + " " + student.getKierunekStudiow() + " " + student.uczelnia);
				indeks++;
			}

		}
	}

	private void wypiszMenu() {
		System.out.println("1.Odczyt listy studentów");
		System.out.println("2.Zapis listy studentów");
		System.out.println("3.Dodaj studenta");
		System.out.println("4.Usuń studenta");
		System.out.println("5.Wypisz liste na ekran");
		System.out.println("6.Szukaj Studenta");
		System.out.println("7.Edytuj");
		System.out.println("9.Wyjście");
		System.out.println("podaj  liczbe:");
	}

	private void zapisListyStudentow() throws FileNotFoundException {
		System.out.println("Podaj nazwę pliku");
		String nazwaPliku = menu.next();

		StudentWriter zapis = new StudentWriter();
		zapis.zapiszStudentow(tablicaStudentow, nazwaPliku);
	}

}