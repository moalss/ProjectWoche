package xo;

import java.util.Scanner;

public class Test {

		public static void main(String[] args) {
			Spieler[] spielerArray = new Spieler[2];
			for (int i = 0; i < 2; i++) {
			spielerArray[i] = new Spieler("x");
				
				spielerArray[i].vorratAusgabe();
				spielerArray[i].loescheStein("x1");
				spielerArray[i].vorratAusgabe();
			}

	}

}
