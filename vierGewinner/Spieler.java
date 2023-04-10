package vierGewinner;

public class Spieler {
	private  int spielstein;
	private String name;
	
	public Spieler(String name, int spielstein ) {
		this.spielstein=spielstein;
		this.name=name;
			
	}

	public  int getSpielstein() {
		return spielstein;
	}

	public String getName() {
		return name;
	}
	
	
	
	

}
