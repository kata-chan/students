package edukacja;

public class Petle {

	public static void main(String[] args) {
		System.out.println("petla for");
		petlaFor();
		System.out.println("petla while");
		petlaWhile();
		System.out.println("petla do while");
		petlaDoWhile();
	}

	public static void petlaFor() {
		for (int liczba = 1; liczba <= 10; liczba++) {
			System.out.println(liczba);
		}
	}

	private static void petlaDoWhile() {
		int liczba = 1;
		do {
			System.out.println(liczba);
			liczba++;
		} while (liczba <= 10);
	}

	private static void petlaWhile() {
		int liczba = 1;
		while (liczba <= 10) {
			System.out.println(liczba);
			liczba++;
		}
	}
}
