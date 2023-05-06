package xo;

import java.util.Scanner;

public class Hauptklasse {

	public static void main(String[] args) {

		do {// ganze spiel weiterspielen ja oder nein
			Spielfeld s = new Spielfeld(5, 5);
			int zeile;
			int spalte;
			String stein;
			s.instalisieren();
			Spieler[] spielerArray;
			Scanner sc = new Scanner(System.in);
			System.out.print("Spieler Anzahl: ");
			int n = sc.nextInt();
			spielerArray = new Spieler[n];
			for (int i = 0; i < n; i++) {
				System.out.print("Zeichen der " + (i + 1) + " Spieler: ");
				String name = sc.next();
				spielerArray[i] = new Spieler(name);
			}

			for (int i = 0; i < spielerArray.length; i++) { // Spieler durchlaufen kann auch while benutzen

				do {// setztestein true oder false optional 
					s.spielfeldausgeben();
					spielerArray[i].vorratAusgabe();
					System.out.println("Geben sie den wert zeile und spalte und Stein ");
					System.out.print("Zeile: ");
					zeile = sc.nextInt();
					System.out.print("Spalte: ");
					spalte = sc.nextInt();
					System.out.print("Stein: ");
					stein = sc.next();

				} while (!s.setzespielstein(zeile, spalte, stein));
				spielerArray[i].loescheStein(stein);
				s.spielfeldausgeben();
				spielerArray[i].vorratAusgabe();
				System.out.println();

				if (s.testeSieg(stein)) {
					System.out.println(spielerArray[i].getName() + " ist gewonnen");
					break;

				} else {
					if (i == spielerArray.length - 1) {// i=anzahl von Spieler aber keiner ist gewonnen dann muss vom
														// Anfang anfangen z.B wenn anzahl von Spieler ist 2 fängt von 0 an endent bei 1 i==1
						i = -1;// wenn i=0 ist dann wird die spielerArray[0] 'erste Stelle' übersprungen das
								// wird geschehen wegen i++

					}

				}
			}

			System.out.println("möchten sie wieder spielen j oder n");
			char m = sc.next().charAt(0);
			if (m == 'n')
				break;

		} while (true);
		System.out.println("Aufwiedersehen");

	}

}
