package NoName;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		do {
			System.out.println("Geben Sie Anzahl Zeile und Spalte des Arrays ein");
			System.out.print("Zeile: ");
			int z = sc.nextInt();
			System.out.print("Spalte: ");
			int s = sc.nextInt();
			Spielfeld spie = new Spielfeld(z, s);
			Spieler sp1 = new Spieler("A");
			Spieler sp2 = new Spieler("B");
			spie.initial();
			
			boolean t1 = true;
			int zsp1, ssp1;
			int zsp2, ssp2;
			char rec1, rec2;

			
				do {
					
				
				do {
					spie.druckeSpielfeld(sp1);
					System.out.println("Spieler " + sp1.getName() + " " + sp1.getPunkte() + " ist dran");
					System.out.print("Zeile: ");
					zsp1 = sc.nextInt();
					System.out.println();
					System.out.print("Spalte: ");
					ssp1 = sc.nextInt();
					System.out.print("Rechtung 'r' nach recht oder 'o' nach oben: ");
					rec1 = sc.next().charAt(0);

				} while (!spie.führeZugAus(zsp1, ssp1, rec1, sp1));

				

				do {
					spie.druckeSpielfeld(sp2);
					System.out.println("Spieler " + sp2.getName() + " " + sp2.getPunkte() + " ist dran");
					System.out.print("Zeile: ");
					zsp2 = sc.nextInt();
					System.out.print("Spalte: ");
					ssp2 = sc.nextInt();
					System.out.print("Rechtung 'r' nach recht oder 'o' nach oben: ");
					rec2 = sc.next().charAt(0);
					
				} while (!spie.führeZugAus(zsp2, ssp2, rec2, sp2));
				
				}while(true);
		} while (true);
	}

}
