package xo;

public class Spielfeld {
	private String feld[][];

	public Spielfeld(int zeile, int spalte) {
		if (zeile % 2 == 1 && spalte % 2 == 1) {
			this.feld = new String[zeile][spalte];
		} else
			System.out.println("Bitte gultige Eingabe machen.");
	}

	public void spielfeldausgeben() {
		System.out.println();
		System.out.print("  ");
		for (int j = 0; j < feld[0].length; j++) {
			System.out.print("|" + "  " + (j + 1) + " ");
		}
		System.out.print("|");

		System.out.println();
		System.out.print("--");

		for (int i = 0; i < feld.length; i++) {
			System.out.print("+----");
		}
		System.out.print("+");
		System.out.println();
		for (int i = 0; i < feld.length; i++) {
			System.out.print((i + 1) + " | ");
			for (int j = 0; j < feld[i].length; j++) {
				System.out.print(feld[i][j] + "  | ");

			}
			System.out.println();
			System.out.print("--+");
			for (int x = 0; x < feld.length; x++) {
				System.out.print("----+");
			}
			System.out.println();
		}
	}

	public void instalisieren() {
		for (int i = 0; i < feld.length; i++) {
			for (int j = 0; j < feld[i].length; j++) {
				feld[i][j] = " ";
			}
		}
	}

	public boolean setzespielstein(int zeile, int spalte, String wert) {

		if (zeile < 1 || zeile > feld.length || spalte < 1 || spalte > feld[0].length) {
			System.out.println("Sie sind ausserhalb ihre Spielfeld");
			return false;
		}
		if (feld[zeile - 1][spalte - 1] == " ") {

			feld[zeile - 1][spalte - 1] = wert;
			return true;

		}

		if (feld[zeile - 1][spalte - 1] != " ") {

			String a = feld[zeile - 1][spalte - 1];
			String b = wert;

			if (b.charAt(1) > a.charAt(1)) {
				feld[zeile - 1][spalte - 1] = b;
				System.out.println("Stein wurde eingesetzt");
				return true;
			} else if (b.charAt(1) < a.charAt(1)) {
				System.out.println("Zug nicht moeglich");
				return false;
			} else if (b.charAt(1) == a.charAt(1)) {

				System.out.println("Die werte stimmen ueberein!");
				return false;

			}

		}
		return false;

	}

	public boolean testeSieg(String stein) {

		for (int i = 0; i < feld.length; i++) {
			for (int j = 0; j < feld[0].length; j++) {
				// Horizontal
				if (j + 2 < feld[i].length && feld[i][j].charAt(0) == stein.charAt(0)
						&& feld[i][j + 1].charAt(0) == stein.charAt(0) && feld[i][j + 2].charAt(0) == stein.charAt(0)) {

					return true;
				}
				// Vertical
				else if (i + 2 < feld.length && stein.charAt(0) == feld[i][j].charAt(0)
						&& stein.charAt(0) == feld[i + 1][j].charAt(0) && stein.charAt(0) == feld[i + 2][j].charAt(0)) {

					return true;
				}
				// Diagonal nach unten recht
				else if (i + 2 < feld.length && j + 2 < feld[i].length && feld[i][j].charAt(0) == stein.charAt(0)
						&& stein.charAt(0) == feld[i + 1][j + 1].charAt(0)
						&& stein.charAt(0) == feld[i + 2][j + 2].charAt(0)) {

					return true;
				}
				// Diagonal nach unten links
				else if (i - 2 >= 0 && j - 2 >= 0 && feld[i][j].charAt(0) == stein.charAt(0)
						&& stein.charAt(0) == feld[i - 1][j - 1].charAt(0)
						&& stein.charAt(0) == feld[i - 2][j - 2].charAt(0)) {

					return true;
				}
			}
		}
		return false;

	}

}