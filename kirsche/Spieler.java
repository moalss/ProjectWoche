package kirsche;

public class Spieler {
	
	private String name;
	private static int id=0;
	private int num;
	private int punkte;
	
	public Spieler(String name) {
		this.setName(name);	
		num=++id;
		punkte=0;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return num;
	}

	public int getPunkte() {
		return punkte;
	}

	public void setPunkte(int punkte) {
		this.punkte += punkte;
	}
	
	

}
