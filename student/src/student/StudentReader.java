package student;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class StudentReader {
	public static void main(String[] args) throws FileNotFoundException {
		StudentReader odczyt = new StudentReader();
		ArrayList<Student> tablicaStudentow = odczyt.odczytajStudentow("src/studenci.txt");

		StudentWriter zapis = new StudentWriter();
		zapis.zapiszStudentow(tablicaStudentow, "src/studenci-zapis.txt");
	}

	public ArrayList<Student> odczytajStudentow(String nazwaPliku) throws FileNotFoundException {

		File file = new File(nazwaPliku);
		ArrayList<Student> studenci = new ArrayList<Student>();
		if (file.exists()) {

			Scanner scanner = new Scanner(file);
			scanner.nextLine();

			while (scanner.hasNextLine()) {
				String linia = scanner.nextLine();
				String[] tablica = linia.split(";");
				Student record = new Student();
				record.setImie(tablica[0]);
				record.setNazwisko(tablica[1]);
				record.setDataUrodzin(tablica[2]);
				record.setKierunekStudiow(tablica[3]);
				record.uczelnia = tablica[4];
				studenci.add(record);

			}
			scanner.close();
		}
		return studenci;

	}
}
