package student;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class StudentReader {
	public static void main(String[] args) throws FileNotFoundException {
		StudentReader nowyObiekt = new StudentReader();
		Student[] tablicaStudentow = nowyObiekt.odczytajStudentow("src/studenci.txt");

		for (Student student : tablicaStudentow) {
			if (student != null) {
				System.out.println(student);
			}
		}
	}

	public Student[] odczytajStudentow(String nazwaPliku) throws FileNotFoundException {

		File file = new File(nazwaPliku);
		Scanner scanner = new Scanner(file);
		scanner.nextLine();
		Student[] studenci = new Student[20];
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

		return studenci;

	}
}
