package solitär;

import java.util.Scanner;

public class Solitaer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Spielfeld sp= new Spielfeld();
		Scanner sc= new Scanner(System.in);
		sp.startSpiel();
		sp.ausgabeSpielfeld();
		
		boolean b;
		do{
			b=sp.zug();
			if(!b) {
				System.out.println("möchte sie weiter spielen j oder n");
				char c= sc.next().charAt(0);
				if(c=='j') {
					sp.ausgabeSpielfeld();
					b=true; 
										
				}
				else {
					System.out.println("auf wiedersehen");
					//break;
				}
			}
			
		}while(b);
		

	}

}
