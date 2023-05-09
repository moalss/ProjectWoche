package kirsche;

import java.util.Random;
import java.util.Scanner;

public class Spielfeld {
	Scanner sc = new Scanner(System.in);
	private char[][] verdeckt;
	private char[][] zeigen;
	private char rote = 'R';
	private char gruen = 'G';
	private int a;
	private int b;

	public Spielfeld(int a, int b) {
		this.a = a;
		this.b = b;
		verdeckt = new char[a][b];
		zeigen = new char[a][b];
	}

	public void intial() {
		// verdeckt
		for (int i = 0; i < verdeckt.length; i++) {
			for (int j = 0; j < verdeckt[0].length; j++) {
				verdeckt[i][j] = ' ';
			}
		}
		// zeigen
		for (int i = 0; i < zeigen.length; i++) {
			for (int j = 0; j < zeigen[0].length; j++) {
				zeigen[i][j] = ' ';
			}
		}
	}

	// Ausgabe zeigen Feld
	public void spielfeldAusgabeZ() {
		System.out.print(" ");
		for (int i = 0; i < zeigen[0].length; i++) {
			System.out.print(" " + i);

		}
		System.out.println();
		for (int i = 0; i < zeigen.length; i++) {
			System.out.print(i + " ");
			for (int j = 0; j < zeigen[i].length; j++) {
				System.out.print(zeigen[i][j] + " ");
			}
			System.out.println();
		}
	}

	// Ausgabe verdeckt Feld "Optional nur zum testen"
	public void spielfeldAusgabeV() {
		System.out.print(" ");
		for (int i = 0; i < verdeckt[0].length; i++) {
			System.out.print(" " + i);

		}
		System.out.println();
		for (int i = 0; i < verdeckt.length; i++) {
			System.out.print(i + " ");
			for (int j = 0; j < verdeckt[i].length; j++) {
				System.out.print(verdeckt[i][j] + " ");
			}
			System.out.println();
		}
	}

	// kirsche verteilen in verdeckte Feld
	public void kirscheVerteilung(int anzrote, int anzgruen) {
		Random rand = new Random();
		int zR = 0;
		int sR = 0;
		int zG = 0;
		int sG = 0;
		while (anzrote > 0) {
			zR = rand.nextInt(a);
			sR = rand.nextInt(b);
			if (verdeckt[zR][sR] == ' ' && verdeckt[zR][sR] != gruen) {
				verdeckt[zR][sR] = rote;
				anzrote--;
			}

		}

		while (anzgruen > 0) {
			zG = rand.nextInt(a);
			sG = rand.nextInt(b);
			if (verdeckt[zG][sG] == ' ' && verdeckt[zG][sG] != rote) {
				verdeckt[zG][sG] = gruen;
				anzgruen--;
			}
		}

	}

	// teste bereich

	public boolean testeBereich(int z, int s) {
		if (z < 0 || z > verdeckt.length || s < 0 || s > verdeckt[0].length) {
			return false;
		}
		return true;

	}

	// zug

	public boolean zug(int z, int s, Spieler sp) {
		if (testeBereich(z, s)) {
			if (verdeckt[z][s] == rote) {
				verdeckt[z][s] = ' ';
				System.out.println("Das ist eine rote Kirsche: Sie haben 1 Punkt gewonnen");
				sp.setPunkte(1);
				spielfeldAusgabeZ();
				spielfeldAusgabeV();
				return true;
			} else if (verdeckt[z][s] == gruen) {
				verdeckt[z][s] = ' ';
				zeigen[z][s] = gruen;
				System.out.println("Das ist eine grüne Kirsche: 3 Punkte werden abgezogen");
				sp.setPunkte(-3);
				spielfeldAusgabeZ();
				return true;
			}

			else {
				System.out.println("Es wurde keine Punkte gefunden ");
				System.out.print("geben Sie bitte den Abstand ein, in dem nach Kirschen gesucht werden soll: ");
				int n = sc.nextInt();
				zeigen[z][s] = (char) (abstand(n, z, s) + '0');
				spielfeldAusgabeZ();
				spielfeldAusgabeV();
				return true;
			}

		}

		return false;
	}

	// abstand
	public int abstand(int n, int z, int s) {
		int arg1 = 0;
		int arg2 = 0;
		int max = 0;
		int count = 0;
		for (int i = 0; i < verdeckt.length; i++) {
			for (int j = 0; j < verdeckt.length; j++) {
				if (verdeckt[i][j] == gruen) {

					arg1 = z - i;
					if (arg1 < 0) {
						arg1 *= -1;
					}
					arg2 = s - j;
					if (arg2 < 0) {
						arg2 *= -1;
					}

					if (arg1 > arg2) {
						max = arg1;

					} else {
						max = arg2;

					}
				}
			}
		}
		if (max <= n) {
			count++;
		}

		return count;
	}

	// testesieg
	public boolean testeSieg(Spieler sp1, Spieler sp2) {

		for (int i = 0; i < verdeckt.length; i++) {
			for (int j = 0; j < verdeckt.length; j++) {
				if (verdeckt[i][j] == rote || verdeckt[i][j] == gruen) {
					return false;
				}
			}
		}
		System.out.println("Es sind keine Kirsche mehr vorhanden. Das Endergebnis lautet");
		System.out.println("Spieler " + sp1.getName() + ": " + sp1.getPunkte() + " punkte " + " Spieler " + sp2.getName()
				+ ": " + sp2.getPunkte() + " punkte");
		if (sp1.getPunkte() > sp2.getPunkte()) {
			System.out.println("Spieler A hat gewonnen");
			return true;
		} else if(sp2.getPunkte() > sp1.getPunkte()) {
			System.out.println("Spieler B hat gewonnen");
			return true;
		}
		else {
			System.out.println("Werte sind gleich keiner hat gewonnen");
			return true;
		}

	}
}