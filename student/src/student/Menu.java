package student;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class Menu {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner menu = new Scanner(System.in);
		Student[] tablicaStudentow = null;
		petla: while (true) {
			System.out.println("1.Odczyt listy studentów");
			System.out.println("2.Zapis listy studentów");
			System.out.println("3.Dodaj studenta");
			System.out.println("4.Usuñ studenta");
			System.out.println("5.Wypisz liste na ekran");
			System.out.println("9.Wyjœcie");

			System.out.println("podaj  liczbe:");
			int obiad = menu.nextInt();

			switch (obiad) {
			case 1:
				System.out.println("Podaj nazwê pliku");
				String nazwaPliku = menu.next();

				StudentReader odczyt = new StudentReader();
				tablicaStudentow = odczyt.odczytajStudentow(nazwaPliku);

				break;
			case 2:

				System.out.println("Podaj nazwê pliku");
				nazwaPliku = menu.next();

				StudentWriter zapis = new StudentWriter();
				zapis.zapiszStudentow(tablicaStudentow, nazwaPliku);
				break;
			case 3:
				System.out.println("Podaj imiê");
				String imie = menu.next();
				System.out.println("Podaj nazwisko");
				String nazwisko = menu.next();
				System.out.println("Podaj datê urodzenia");
				String data = menu.next();
				System.out.println("podaj kierunek studiów");
				String kierunek = menu.next();
				System.out.println("podaj uczelnie");
				String uczelnia = menu.next();

				Student nowyStudent = new Student();

				nowyStudent.setImie(imie);
				nowyStudent.setNazwisko(nazwisko);
				nowyStudent.setDataUrodzin(data);
				nowyStudent.setKierunekStudiow(kierunek);
				nowyStudent.uczelnia = uczelnia;
				int liczbaZajetych = 0;
				for (Student student : tablicaStudentow) {
					if (student == null) {
						tablicaStudentow[liczbaZajetych] = nowyStudent;
						break;
					}
					if (student != null) {
						liczbaZajetych++;
					}
				}

				break;
			case 4:
				System.out.println("Funkcja jeszcze niedostêpna");

				break;
			case 5:
				for (Student student : tablicaStudentow) {
					if (student != null) {
						System.out.println(student.getImie() + " " + student.getNazwisko());
					}
				}
				break;
			case 9:
				break petla;

			}

		}
		System.out.println("Koniec programu");
		menu.close();
	}
}
