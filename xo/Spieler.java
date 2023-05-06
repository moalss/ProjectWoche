package xo;

public class Spieler {
	private String name;
	private String vorrat[];
	private int count = 0;

	public Spieler(String name) {
		this.vorrat = new String[6];
		this.name = name;
		for (int i = 0; i < 6; i = i + 2) {
			vorrat[i] = name + count;
			vorrat[i + 1] = name + count;
			count++;
		}
	}

	public void vorratAusgabe() {

		for (int i = 0; i < vorrat.length; i++) {
			System.out.print(vorrat[i] + " ");

		}
		System.out.println();

	}

	public void loescheStein(String stein) {
		String speicher = " ";
		for (int i = 0; i < vorrat.length; i++) {
			if (vorrat[i].equals(stein)) { // immer equals benutzen besser als ==
				speicher = vorrat[i];
				vorrat[i] = " ";
				break;
			}
		}
		System.out.println("Der Stein" + speicher + " wurde geloeschet");

	}

	public String getName() {
		return this.name;
	}

}
