package vierGewinner;

public class Spielfeld {

	String[][] spielfeld;
	int zeile;
	int spalte;
	Spieler spieler;

	public Spielfeld(int zeile, int spalte) {
		this.spalte = spalte;
		this.zeile = zeile;
		spielfeld = new String[this.zeile][this.spalte];
	}

	public void initialisiereSpielfeld() {
		for (int i = 0; i < spielfeld.length; i++) {
			for (int j = 0; j < spielfeld[0].length; j++) {
				spielfeld[i][j] = "0";

			}
		}
	}

	public void druckeSpielfeld() {
		System.out.println();
		for (int i = 0; i < spielfeld.length; i++) {

			System.out.print(i + 1 + "| ");
			for (int j = 0; j < spielfeld[0].length; j++) {
				System.out.print(spielfeld[i][j] + " " + "| ");
			}
			System.out.println();
		}
		for (int i = 0; i < spielfeld.length; i++) {
			System.out.print("-----");

		}
		System.out.println();
		for (int i = 1; i <= spielfeld.length + 1; i++) {
			System.out.print("   " + i);
		}
		System.out.println();

	}

	int neuZeile = 0;
	int siegSpalte = 0;

	public boolean setzeSpielstein(Spieler sp, int spalte) {
		// spalte>=1&&spalte<=spielfeld[0].length
		this.neuZeile = zeile - 1;
		this.siegSpalte = spalte - 1;
		if (neuZeile > 0 && siegSpalte >= 0 && siegSpalte < spielfeld[0].length) {// wichtig
			while (neuZeile > 0 && siegSpalte >= 0 && (spielfeld[neuZeile][siegSpalte] != "0")) {
				neuZeile--;
			}

			if (spielfeld[neuZeile][siegSpalte] == "0") {

				spielfeld[neuZeile][siegSpalte] = sp.getSpielstein() + "";
				druckeSpielfeld();
				return true;
			}
		}

		druckeSpielfeld();
		return false;

	}

	public boolean testeSieg(Spieler sp) {

		// horizontal recht
		if (siegSpalte >= 0 && siegSpalte + 3 < spielfeld.length
				&& spielfeld[neuZeile][siegSpalte].equals(sp.getSpielstein() + "")
				&& spielfeld[neuZeile][siegSpalte + 1].equals(sp.getSpielstein() + "")
				&& spielfeld[neuZeile][siegSpalte + 2].equals(sp.getSpielstein() + "")
				&& spielfeld[neuZeile][siegSpalte + 3].equals(sp.getSpielstein() + "")) {
			System.out.printf("Spieler %s ist gewonnen", sp.getName());

			return true;

		} // horizontal links
		else if (siegSpalte < spielfeld[0].length && siegSpalte - 3 >= 0
				&& spielfeld[neuZeile][siegSpalte].equals(sp.getSpielstein() + "") // siegSpalte -
				// 3 >= 0 index
				// von
				// siegSpalte
				// ist 3 3-3 =0
				// deswegen =
				// ist wichtig
				&& spielfeld[neuZeile][siegSpalte - 1].equals(sp.getSpielstein() + "")
				&& spielfeld[neuZeile][siegSpalte - 2].equals(sp.getSpielstein() + "")
				&& spielfeld[neuZeile][siegSpalte - 3].equals(sp.getSpielstein() + "")) {
			System.out.printf("Spieler %s ist gewonnen", sp.getName());

			return true;

		}
		// vertikal oben
		else if (siegSpalte >= 0 && siegSpalte < spielfeld[0].length && neuZeile - 3 >= 0
				&& spielfeld[neuZeile][siegSpalte].equals(sp.getSpielstein() + "")
				&& spielfeld[neuZeile - 1][siegSpalte].equals(sp.getSpielstein() + "")
				&& spielfeld[neuZeile - 2][siegSpalte].equals(sp.getSpielstein() + "")
				&& spielfeld[neuZeile - 3][siegSpalte].equals(sp.getSpielstein() + "")) {
			System.out.printf("Spieler %s ist gewonnen", sp.getName());

			return true;

		} // vertikal unten
		else if (neuZeile + 3 < spielfeld.length && spielfeld[neuZeile][siegSpalte].equals(sp.getSpielstein() + "")
				&& spielfeld[neuZeile + 1][siegSpalte].equals(sp.getSpielstein() + "")
				&& spielfeld[neuZeile + 2][siegSpalte].equals(sp.getSpielstein() + "")
				&& spielfeld[neuZeile + 3][siegSpalte].equals(sp.getSpielstein() + "")) {
			System.out.printf("Spieler %s ist gewonnen", sp.getName());

			return true;

		} // diagonal
		for (int i = 0; i < spielfeld.length; i++) {
			for (int j = 0; j < spielfeld[0].length; j++) {
				if (i + 3 < spielfeld.length && j + 3 < spielfeld[0].length
						&& spielfeld[i][j].equals(sp.getSpielstein() + "")
						&& spielfeld[i + 1][j + 1].equals(sp.getSpielstein() + "")
						&& spielfeld[i + 2][j + 2].equals(sp.getSpielstein() + "")
						&& spielfeld[i + 3][j + 3].equals(sp.getSpielstein() + "")) {
					System.out.printf("Spieler %s ist gewonnen", sp.getName());

					return true;
				} else if (i + 3 < spielfeld.length && j - 3 >= 0 && spielfeld[i][j].equals(sp.getSpielstein() + "")
						&& spielfeld[i + 1][j - 1].equals(sp.getSpielstein() + "")
						&& spielfeld[i + 2][j - 2].equals(sp.getSpielstein() + "")
						&& spielfeld[i + 3][j - 3].equals(sp.getSpielstein() + "")) {
					System.out.printf("Spieler %s ist gewonnen", sp.getName());

					return true;
				}
			}
		}

		for (int i = 0; i < spielfeld[0].length; i++) {// hier wird nur die erste zeile überprüft wenn 0 ist wird weiter
			
			if (spielfeld[0][i].equals("0")) {
				return false;// return macht auch break
			}

		}
		System.out.println("unentschieden");
		return true;

	}

}
