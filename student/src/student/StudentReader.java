package student;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class StudentReader {
	public static void main(String[] args) throws FileNotFoundException {
		StudentReader odczyt = new StudentReader();
		Student[] tablicaStudentow = odczyt.odczytajStudentow("src/studenci.txt");

		StudentWriter zapis = new StudentWriter();
		zapis.zapiszStudentow(tablicaStudentow, "src/studenci-zapis.txt");
	}

	public Student[] odczytajStudentow(String nazwaPliku) throws FileNotFoundException {

		File file = new File(nazwaPliku);
		Student[] studenci = new Student[20];
		if (file.exists()) {

			Scanner scanner = new Scanner(file);
			scanner.nextLine();
			int liczbaStudentow = 0;
			while (scanner.hasNextLine()) {
				String linia = scanner.nextLine();
				String[] tablica = linia.split(";");
				Student record = new Student();
				record.setImie(tablica[0]);
				record.setNazwisko(tablica[1]);
				record.setDataUrodzin(tablica[2]);
				record.setKierunekStudiow(tablica[3]);
				record.uczelnia = tablica[4];
				studenci[liczbaStudentow] = record;
				// System.out.println(record);
				liczbaStudentow++;
			}
		}
		return studenci;

	}
}
