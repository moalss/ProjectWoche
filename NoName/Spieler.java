package NoName;

public class Spieler {
	
	private int punkte;
	private String name;
	private static int id=0;
	private int co;
	
	
	public Spieler(String name) {
		this.name=name;
		addPunkte(0);
		co=++id;
	}


	public int getPunkte() {
		return punkte;
	}


	public void addPunkte(int punkte) {
		this.punkte += punkte;
	}


	public String getName() {
		return name;
	}


	public int getId() {
		return co;
	}
	
	public void resetId() {
		punkte=0;;
	}
	

}
