import java.util.Scanner;

public class Spielfeld {
char[][] spielfeld=new char[5][5];
Scanner sc = new Scanner(System.in);
int spalte;
int zeile;
public void initialization() {
	for (int i = 0; i < spielfeld.length; i++) {
		for (int j = 0; j < spielfeld.length; j++) {
			spielfeld[i][j]='#';
		}
	}
	spielfeld[3][2]='-';
}
public void ausgabe() {
	System.out.println("  0 1 2 3 4 \n  ----------");
	for (int i = 0; i < spielfeld.length; i++) {
		System.out.print(i+"|");
		for (int j = 0; j < spielfeld[0].length; j++) {
			System.out.print(spielfeld[i][j]+" ");
		}
		System.out.println();
	}
}
public void starteSpiel() {
	initialization();
	ausgabe();
}
public boolean zug() {
	System.out.println("geben Sie die zeile von pin sie bewegen möchten");
	zeile=sc.nextInt();
	System.out.println("geben Sie die spalte von pin sie bewegen möchten");
	spalte=sc.nextInt();
	if(zeile>-1 && zeile<5 && spalte>-1 && spalte<5) {
		if(spielfeld[zeile][spalte]=='#') {
			int erg=testpos();
			switch(erg) {
			case 1:
			spielfeld[zeile][spalte]=spielfeld[zeile][spalte+1]='-';
			spielfeld[zeile][spalte+2]='#';
			ausgabe();
			return true;
			case 2:
				spielfeld[zeile][spalte]=spielfeld[zeile][spalte-1]='-';
				spielfeld[zeile][spalte-2]='#';
				ausgabe();
				return true;
			case 3:
				spielfeld[zeile][spalte]=spielfeld[zeile-1][spalte]='-';
				spielfeld[zeile-2][spalte]='#';
				ausgabe();
				return true;
			case 4:
				spielfeld[zeile][spalte]=spielfeld[zeile+1][spalte]='-';
				spielfeld[zeile+2][spalte]='#';
				ausgabe();
				return true;
			default:
				System.out.println("diese Zug ist unmöglich");
				ausgabe();
				break;
			}
		}
		else {
			System.out.println("ihre Eingabe soll pin sein");
		}
	}
	else {
		System.out.println("Ihre Eingabe soll zwichen 0 und 4 sein");
	}
	return false;
}
public int testpos() {
	//Link bewegen 
if(spalte<3 && spielfeld[zeile][spalte+1]=='#' && spielfeld[zeile][spalte+2]=='-' )
	return 1;
//rechtbewegen
if(spalte>1 && spielfeld[zeile][spalte-1]=='#' && spielfeld[zeile][spalte-2]=='-' )
	return 2;
//oben bewegen
if(zeile>1 && spielfeld[zeile-1][spalte]=='#' && spielfeld[zeile-2][spalte]=='-' )
	return 3;
//Unten Bewegen
if(zeile<3 && spielfeld[zeile+1][spalte]=='#' && spielfeld[zeile+2][spalte]=='-' )
	return 4;
	return -1;
}
}
