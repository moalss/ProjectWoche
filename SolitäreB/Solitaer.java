import java.util.Scanner;

public class Solitaer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
Scanner sc = new Scanner(System.in);
Spielfeld sp = new Spielfeld();
boolean neu=true;
do {
boolean zug;
sp.starteSpiel();
do {
zug=sp.zug();
if(!zug) {
	System.out.println("Wenn Sie andere Zug haben drucken Sie bitte 1\n für neue Spiel drucken Sie bitte 2\n für abbrechen drucken Sie 3");
	int ein = sc.nextInt();
	switch(ein) {
	case 1:
		zug=true;
		break;
	case 2:
		break;
	case 3:
		neu=false;
		break;
	}
}
}while(zug);
}while(neu);
System.out.println("Aufwiedersehen");
	}

}
