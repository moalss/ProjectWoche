package klausur_2023;

import java.util.Scanner;

public class Spielfeld {
	String[] recht;
	String[] links;
	int zeit;
	char a;
	char b;
	int zahl1;
	int zahl2;
	Scanner sc = new Scanner(System.in);

	public Spielfeld() {
		this.zeit = 0;
		recht = new String[] { " ", " ", " ", " " };
		links = new String[] { "A(5)", "B(10)", "C(35)", "D(40)" };
	}

	public void spielfeldausgabe() {
		System.out.print("Links \t\t\t Recht\n");
		for (int i = 0; i < links.length; i++) {
			System.out.print(links[i]);
		}
		System.out.print("        ");
		for (int i = 0; i < links.length; i++) {
			System.out.print(recht[i]);
		}

	}

	public int getZeit() {
		return zeit;
	}

	public void zugl() {
		System.out.println("geben sie zwei buchstabe");
		a = sc.next().charAt(0);
		b = sc.next().charAt(0);
		buchstabeL();
		for (int i = 0; i < links.length; i++) {
			if (links[i].charAt(0) == a) {
				for (int j = 0; j < recht.length; j++) {

					if (recht[j] == " ") {
						recht[j] = links[i];
						links[i] = " ";
						break;
					}
				}
			}
			if (links[i].charAt(0) == b) {
				for (int j = 0; j < recht.length; j++) {

					if (recht[j] == " ") {
						recht[j] = links[i];
						links[i] = " ";
						break;
					}
				}
			}
		}
		//nachrückung
		for (int i = 1; i < links.length; i++) {
			if (links[i - 1] == " ") {
				links[i - 1] = links[i];
				links[i] = " ";
	

			}

		}
		spielfeldausgabe();

	}

	public void zugR() {
		System.out.println("geben sie ein buchstabe");
		a = sc.next().charAt(0);
		buchstabeR();

		for (int i = 0; i < recht.length; i++) {
			if (recht[i].charAt(0) == a) {
				for (int j = 0; j < links.length; j++) {

					if (links[j] == " ") {
						links[j] = recht[i];
						recht[i] = " ";
						break;
					}
				}
			}
		}
		// nachrückung
		for (int i = 1; i < recht.length; i++) {
			if (recht[i - 1] == " ") {
				recht[i - 1] = recht[i];
				recht[i] = " ";
			}
		}
		spielfeldausgabe();

	}

	public void buchstabeL() {

		switch (a) {
		case 'A':
			zahl1 = 5;
			break;

		case 'B':
			zahl1 = 10;
			break;

		case 'C':
			zahl1 = 35;
			break;

		case 'D':
			zahl1 = 40;
			break;
		default:
			System.out.println("geben sie rechtige buchstabe von A bis D");
			break;
		}
		switch (b) {
		case 'A':
			zahl1 = 5;
			break;

		case 'B':
			zahl1 = 10;
			break;

		case 'C':
			zahl1 = 35;
			break;

		case 'D':
			zahl1 = 40;
			break;
		default:
			System.out.println("geben sie rechtige buchstabe von A bis D");
			break;
		}

		if (zahl1 > zahl2) {
			zeit += zahl1 + 5;
		} else {
			zeit += zahl2 + 5;
		}

	}

	public void buchstabeR() {

		switch (a) {
		case 'A':
			zahl1 = 5;
			break;

		case 'B':
			zahl1 = 10;
			break;

		case 'C':
			zahl1 = 30;
			break;

		case 'D':
			zahl1 = 40;
			break;
		default:
			System.out.println("geben sie rechtige buchstabe von A bis D");
			break;
		}
		zeit += zahl1 + 5;
	}

	public boolean testeSieg() {

		// gewonnen
		int j = links.length;// 3 2 1 0
		for (int i = 0; i < links.length; i++) {
			if (links[i] == " " && zeit <= 90) {

				j--;
				if (j == 0) {
					System.out.println("Glückwünsche du bist gewonnen");
					return true;
				}

			} else if (zeit > 90) {
				System.out.println("Leider du bist verloren");

				return true;
			}
		}

		return false;
	}

}
