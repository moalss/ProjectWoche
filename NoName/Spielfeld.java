package NoName;

import java.util.Random;

public class Spielfeld {

	private char[][] feld;

	Random rand = new Random();

	public Spielfeld(int z, int s) {
		feld = new char[z][s];
	}

	public void initial() {
		for (int i = 0; i < feld.length; i++) {
			for (int j = 0; j < feld[i].length; j++) {
				feld[i][j] = (char) (rand.nextInt(26) + 'A');
			}
		}
	}

	public void druckeSpielfeld(Spieler sp) {
		System.out.println();
		System.out.print("   ");
		for (int i = 0; i < feld.length; i++) {
			System.out.print(i + "   ");
		}
		System.out.println();
		for (int i = 0; i < feld.length; i++) {
			System.out.print(i + "| ");
			for (int j = 0; j < feld[i].length; j++) {
				System.out.print(feld[i][j] + " | ");
			}
			System.out.println();
		}
		System.out.println();
		System.out.println(sp.getPunkte());
	}

	public boolean testeZug(int z, int s, char rec) {
		if (z < 0 || z > feld.length || s < 0 || s > feld[0].length) {
			return false;
		}

		if (rec == 'r'
				&& ((feld[z][s] == ' ' && feld[z][s + 1] == ' ') || (feld[z][s] != ' ' && feld[z][s + 1] == ' '))) {
			return false;
		} else if (rec == 'o'
				&& ((feld[z][s] == ' ' && feld[z - 1][s] == ' ') || (feld[z][s] != ' ' && feld[z - 1][s] == ' '))) {
			return false;
		}

		return true;
	}

	public void nachruekungOToU() {

		for (int i = feld.length - 1; i > 0; i--) {
			for (int j = 0; j < feld[i].length; j++) {

				if (feld[i][j] == ' ') {

					int k = i - 1;
					while (k >= 0 && feld[k][j] == ' ') {
						k--;
					}

					if (k >= 0) {
						feld[i][j] = feld[k][j];
						feld[k][j] = ' ';
					}

				}
			}
		}

	}

	public boolean führeZugAus(int z, int s, char rec, Spieler sp) {
		int erg;
		if (testeZug(z, s, rec)) {

			char zw;
			// recht
			if (rec == 'r') {
				// tauO
				zw = feld[z][s];
				feld[z][s] = feld[z][s + 1];
				feld[z][s + 1] = zw;

				if (s + 1 < feld[0].length && feld[z][s] == feld[z][s + 1]) {
					erg = (int) (2 * (feld[z][s] - 64));
					sp.addPunkte(erg);
					feld[z][s] = ' ';
					feld[z][s + 1] = ' ';
					nachruekungOToU();
					druckeSpielfeld(sp);
					
					
					return true;
				}

				int spa = s + 2;
				while (spa < feld[0].length && feld[z][s + 1] == feld[z][spa]) {
					erg = (int) (feld[z][spa] - 64);
					sp.addPunkte(erg);
					feld[z][spa] = ' ';
					spa++;
				}
				nachruekungOToU();
				druckeSpielfeld(sp);
				
				return true;

			}
			// oben
			else if (rec == 'o') {
				// tauO
				zw = feld[z][s];
				feld[z][s] = feld[z - 1][s];
				feld[z - 1][s] = zw;

				if (feld[z][s] == feld[z - 1][s]) {
					erg = (int) (2 * (feld[z - 1][s] - 64));
					sp.addPunkte(erg);
					feld[z][s] = ' ';
					feld[z - 1][s] = ' ';
					nachruekungOToU();
					druckeSpielfeld(sp);
					
					return true;
				}

				int zei = z + 1;
				while (zei < feld.length && feld[z][s] == feld[zei][s]) {
					erg = (int) (feld[zei][s] - 64);
					feld[zei][s] = ' ';
					zei++;
				}
				nachruekungOToU();
				druckeSpielfeld(sp);
				
				return true;
			}
		}

		return false;
	}
	
	
	public boolean StesteSieg() {
		for (int i = 0; i < feld.length; i++) {
			for (int j = 0; j < feld[i].length; j++) {
				if(feld[i][j]==' ') {
					
				}
			}
		}
		return false;
		
	}

}
