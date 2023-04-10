package solitär;

import java.util.Scanner;

public class Spielfeld {
	char pin = '#';
	char da = '-';

	private char[][] feld;
	Scanner sc = new Scanner(System.in);

	public Spielfeld() {
		this.feld = new char[5][5];
	}

	public void startSpiel() {
		for (int i = 0; i < feld.length; i++) {
			for (int j = 0; j < feld[0].length; j++) {
				feld[i][j] = '#';
			}
		}
		feld[3][2] = '-';
	}

	public void ausgabeSpielfeld() {
		System.out.println("  0 1 2 3 4\n -----------");
		for (int i = 0; i < feld.length; i++) {
			System.out.print(i + "|");
			for (int j = 0; j < feld[0].length; j++) {
				System.out.print(feld[i][j] + " ");
			}
			System.out.println();
		}
	}

	public boolean test(int z, int s) {
		return z >= 0 && z <= 4 && s >= 0 && s <= 4;
	}

	public boolean zug() {
		
		System.out.println("geben sie zeile von # ");
		int zeile= sc.nextInt();
		System.out.println("geben sie spalte von # ");
		int spalte= sc.nextInt();
		
		/*System.out.println("geben sie zeile von Zielpunkt");
		int zeiled= sc.nextInt();
		System.out.println("geben sie Spalte von Zielpunkt");
		int spalted= sc.nextInt();
		*/
		if(test(zeile, spalte)) {
			
			//recht spalte
			if(spalte+2<feld[0].length) {
				if(feld[zeile][spalte]==pin&& feld[zeile][spalte+1]==pin&&feld[zeile][spalte+2]==da) {
					feld[zeile][spalte]=da;
					feld[zeile][spalte+1]=da;
					feld[zeile][spalte+2]=pin;
					ausgabeSpielfeld();
					return true;
				}
			}
			 
			
			// links spalte
			 if(spalte-2>=0) {
				
				 if(feld[zeile][spalte]==pin&& feld[zeile][spalte-1]==pin&&feld[zeile][spalte-2]==da) {
					feld[zeile][spalte]=da;
					feld[zeile][spalte-1]=da;
					feld[zeile][spalte-2]=pin;
					ausgabeSpielfeld();
					return true;
				}	
			}
			
			
			//oben zeile
			// if(zeile+2<feld.length) { //4 +2 = 6 > 4 false 
				 if(zeile+2<feld.length&&feld[zeile][spalte]==pin&& feld[zeile+1][spalte]==pin&&feld[zeile+2][spalte]==da) {
					feld[zeile][spalte]=da;
					feld[zeile+1][spalte]=da;
					feld[zeile+2][spalte]=pin;
					ausgabeSpielfeld();
					return true;
				}
			//}
			//unten zeile
			
			 if(zeile-2>=0) {
				
				if(feld[zeile][spalte]==pin&& feld[zeile-1][spalte]==pin&&feld[zeile-2][spalte]==da) {
					feld[zeile][spalte]=da;
					feld[zeile-1][spalte]=da;
					feld[zeile-2][spalte]=pin;
					ausgabeSpielfeld();
					return true;
				}
			}
			
			
			
		}else {
			System.out.println("geben sie nummer zwischen 0 und 4");
			ausgabeSpielfeld();
			zug();
		}
		ausgabeSpielfeld();
		return false;
		
	}

}
