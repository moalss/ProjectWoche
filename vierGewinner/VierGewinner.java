package vierGewinner;

import java.util.Scanner;

public class VierGewinner {

	public static void main(String[] args) {
		Spielfeld sp = new Spielfeld(6, 7);

		sp.initialisiereSpielfeld();
		sp.druckeSpielfeld();
		Spieler sp1 = new Spieler("Yahya", 5);
		Spieler sp2 = new Spieler("Bayan", 2);
		boolean b;
		boolean a;
		int spalte1;
		int spalte2;
		Scanner sc = new Scanner(System.in);
		do {

			do {
				System.out.printf("gebe spalte %s ein ", sp1.getName());
				spalte1 = sc.nextInt();
				b = sp.setzeSpielstein(sp1, spalte1);

			} while (!b);
			if (sp.testeSieg(sp1)) {
				break;
			}
			do {
				System.out.printf("gebe spalte %s ein ", sp2.getName());
				spalte2 = sc.nextInt();
				b = sp.setzeSpielstein(sp2, spalte2);
			} while (!b);

			if (sp.testeSieg(sp2)) {
				break;
			}
		} while (true);

	}

}
