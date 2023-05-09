package kirsche;

import java.util.Scanner;

public class Kirsche {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		do {
			Spieler sp1 = new Spieler("A");
			Spieler sp2 = new Spieler("B");

			System.out.println("Geben Sie bitte die Anzahl der Zeile des Spielfeldes an: ");
			int zf = sc.nextInt();
			System.out.println("Geben Sie bitte die Anzahl der Spalte des Spielfeldes an: ");
			int sf = sc.nextInt();
			System.out.println("Geben Sie bitte die Anzahl der roten Kirschen an: ");
			int rot = sc.nextInt();
			System.out.println("Geben Sie bitte die Anzahl der grünen an: ");
			int gruen = sc.nextInt();
			Spielfeld spiel = new Spielfeld(zf, sf);
			spiel.intial();
			spiel.kirscheVerteilung(rot, gruen);
			spiel.spielfeldAusgabeZ();
			int za;
			int sa;

			do {

				do {// zug Spieler A
					System.out.println("Spieler " + sp1.getName()+ " "+sp1.getPunkte());
					System.out.print("Geben Sie bitte die aufzudeckende Zeile an: ");
					za = sc.nextInt();
					System.out.print("Geben Sie bitte die aufzudeckende Spalte an: ");
					sa = sc.nextInt();
					spiel.spielfeldAusgabeZ();
					spiel.spielfeldAusgabeV();
				} while (!spiel.zug(za, sa, sp1));
				
				//testeSieg Spieler A
				if (spiel.testeSieg(sp1, sp2)) {
						break;
				}

				do { // zug Spieler B
					System.out.println("Spieler " + sp2.getName() + " " + sp2.getPunkte());
					System.out.print("Geben Sie bitte die aufzudeckende Zeile an: ");
					za = sc.nextInt();
					System.out.print("Geben Sie bitte die aufzudeckende Spalte an: ");
					sa = sc.nextInt();
					} while (!spiel.zug(za, sa, sp2));
				
				//testeSieg Spieler B
				if (spiel.testeSieg(sp1, sp2)) {
					break;
				}
			} while (true);
			System.out.println("Möchten Sie wiederspielen j oder n");
			char s = sc.next().charAt(0);
			if (s == 'n') {
				break;
			}
		} while (true);
		System.out.println("Aufwiedersehen");
	}

}
