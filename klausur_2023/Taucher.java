package klausur_2023;

import java.util.Scanner;

public class Taucher {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		boolean reg = false;
		boolean abbrechen = false;

		do {
			Spielfeld sp = new Spielfeld();//wenn mann verliert muss das spiel neu initialisiert werden

			do {
				sp.spielfeldausgabe();
				System.out.println("\n" + sp.getZeit());
				sp.zugl();
				
				System.out.println("\n" + sp.getZeit());
				if (reg = sp.testeSieg()) {
					System.out.println("m�chten sie nochmal spielen j oder n ");
					int a = sc.next().charAt(0);
					if (a == 'n') {
						System.out.println("aufwiedersiehen");
						abbrechen = true;
						break;

					}

				}
				
				sp.zugR();
				
				System.out.println("\n" + sp.getZeit());
				if (reg = sp.testeSieg()) {
					System.out.println("m�chten sie nochmal spielen j oder n");
					int a = sc.next().charAt(0);
					if (a == 'n') {
						System.out.println("aufwiedersiehen");
						abbrechen = true; //spiel beenden wenn n gedr�ckt wurde
						break; // erste while beenden

					}

				}
			} while (!reg);//spiele solange keiner ist gewonnen oder verloren

		} while (!abbrechen);//spielen solange abbrechen false ist
	}

}
