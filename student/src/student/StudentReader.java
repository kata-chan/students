package student;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class StudentReader {
	public static void main(String[] args) throws FileNotFoundException {
		StudentReader nowyObiekt = new StudentReader();
		nowyObiekt.odczytajStudentow("src/studenci.txt");
	}

	public Student[] odczytajStudentow(String nazwaPliku) throws FileNotFoundException {

		File file = new File(nazwaPliku);
		Scanner scanner = new Scanner(file);
		scanner.nextLine();
		while (scanner.hasNextLine()) {
			String linia = scanner.nextLine();
			String[] tablica = linia.split(";");
			Student record = new Student();
			record.setImie(tablica[0]);
			record.setNazwisko(tablica[1]);
			System.out.println(record);

		}
		return null;

	}
}
