package student;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class StudentWriter {
	// File plik = new File("studenci.txt");

	public void zapiszStudentow(Student[] studenci, String nazwaPlikuKoncowego) throws FileNotFoundException {
		PrintWriter zapis = new PrintWriter(nazwaPlikuKoncowego);
		zapis.println("Wersja=1:Imiê;Nazwisko;Data urodzin;Kierunek Studiów;Uczelnia");

		for (Student student : studenci) {
			if (student != null) {

				zapis.print(student.getImie());
				zapis.print(";");
				zapis.print(student.getNazwisko());
				zapis.print(";");
				zapis.print(student.getDataUrodzin());
				zapis.print(";");
				zapis.print(student.getKierunekStudiow());
				zapis.print(";");
				zapis.println(student.uczelnia);

			}
		}

		zapis.close();
	}

}
