import java.util.Scanner;

public class vierTaucher {
	static int vergangeneZeit = 0;
	 static Taucher[] link = new Taucher[4];
	 static Taucher[]recht = new Taucher[4];
	public static void main(String[] args) {
		// TODO Auto-generated method stub
boolean brechen=false;
Scanner sc = new Scanner(System.in);
do {
initial();
ausgabe();
//Scanner sc = new Scanner(System.in);
Taucher t1=null;
Taucher t2=null;
String taucher1="";
String taucher2="";
do {
	System.out.println("geben Sie zwei Taucher von der linkenseite\nerste Taucher: ");
	taucher1=sc.next();
	System.out.println("zweite Taucher :");
	taucher2=sc.next();
	for (int i = 0; i < link.length; i++) {
		if(link[i]!=null) {
			if(link[i].getName().equals(taucher1))
				t1=link[i];
			if(link[i].getName().equals(taucher2))
				t2=link[i];
		}
	}
	tauchNachRecht(t1,t2);
	if(testeSieg())
		break;
	System.out.println("geben Sie ein Taucher von der Richtenseite\n Taucher: ");
	taucher1=sc.next();
	for (int i = 0; i < link.length; i++) {
		if(link[i]!=null) {
			if(recht[i].getName().equals(taucher1))
				t1=recht[i];
		}
	}
	tauchNachLink(t1);
	if(testeSieg())
		break;
}while(true);
System.out.println("möchten Sie weiter spielen j oder n ");
if(sc.next().equals("n")){
	System.out.println("Aufwiedersehen");
	brechen=true;
}
vergangeneZeit = 0;
}while(!brechen);
	}
	public static void addLink(Taucher t) {
		for(int i=0;i<4;i++) {
			if(link[i]==null) {
				link[i]=t;
				break;
			}
		}
	}
	public static void addRecht(Taucher t) {
		for(int i=0;i<4;i++) {
			if(recht[i]==null) {
				recht[i]=t;
				break;
			}
		}
	}
	public static void einruckung(Taucher[] list) {
		for(int i =1;i<list.length;i++) {
			if(list[i]!=null) {
				int j = i;
				do {
					j--;
				}
				while(j>=0 && list[j]==null);
				Taucher x =list[i];
				list[i]=list[j+1];
				list[j+1]=x;
			}
		}
	}
	public static void initial() {
		 Taucher A = new Taucher("A",5);
		 link[0]=A;
		 Taucher B = new Taucher("B",10);
		 link[1]=B;
		 Taucher C = new Taucher("C",35);
		 link[2]=C;
		 Taucher D = new Taucher("D",40);
		 link[3]=D;
		 for (int i = 0; i < link.length; i++) {
			recht[i]=null;
		}
	}
	public static void ausgabe() {
		System.out.println("die vergangenezeit ist : "+vergangeneZeit);
		System.out.println("Auf der Linke Seite : ");
		for (int i = 0; i < link.length; i++) {
			if(link[i]!=null)
			System.out.print(link[i].getName()+" : "+link[i].getZeit()+"  ");
			
		}
		System.out.println();
		System.out.println("Auf der Rechte Seite : ");
		for (int i = 0; i < link.length; i++) {
			if(recht[i]!=null)
			System.out.print(recht[i].getName()+" : "+recht[i].getZeit()+"  ");
			
		}
		System.out.println();
	}
	public static void tauchNachRecht(Taucher t1,Taucher t2) {
		if(t1.getZeit()>t2.getZeit()) {
			vergangeneZeit+=t1.getZeit();
			vergangeneZeit+=5;
		}
		else {
			vergangeneZeit+=t2.getZeit();
			vergangeneZeit+=5;
		}
		addRecht(t1);
		addRecht(t2);
		for (int i = 0; i <4; i++) {
			if(link[i]==null) {}
			else{
				if(link[i].getName().equals(t1.getName()))
				link[i]=null;
			else if(link[i].getName().equals(t2.getName()))
				link[i]=null;
			}
		}
		einruckung(link);
		ausgabe();
	}
	public static void tauchNachLink(Taucher t1) {
			vergangeneZeit+=t1.getZeit();
		addLink(t1);
		for (int i = 0; i < link.length; i++) {
			if(recht[i]==t1)
				recht[i]=null;
		}
		einruckung(recht);
		ausgabe();
	}
	public static boolean testeSieg() {
if(link[0]==null && vergangeneZeit <=90) {
	System.out.println("Glückwunsch Sie haben gewonnen");
	return true;
}
else if(vergangeneZeit>90) {
	System.out.println("Leider haben Sie verloren");
	return true;
}
		return false;
	}

}
