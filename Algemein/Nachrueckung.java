
public class Nachrueckung {
	// zweidimensionalen Array
	public void nachrueckenVonObenNachUnten() {
	    for (int i = feld.length - 1; i > 0; i--) {
	        for (int j = 0; j < feld[0].length; j++) {
	            if (feld[i][j] == ' ') {
	                // Suche das oberste nicht leere Element in dieser Spalte
	                int k = i - 1;
	                while (k >= 0 && feld[k][j] == ' ') {
	                    k--;
	                }
	                // Wenn ein nicht leeres Element gefunden wurde, tausche es mit dem leeren Element
	                if (k >= 0) {
	                    feld[i][j] = feld[k][j];
	                    feld[k][j] = ' ';
	                }
	            }
	        }
	    }
	}



	// zweidimensionalen Array
	public void nachrueckenVonUntenNachOben() {
	    for (int i = 0; i < feld.length - 1; i++) {
	        for (int j = 0; j < feld[0].length; j++) {
	            if (feld[i][j] == ' ') {
	                // Suche das unterste nicht leere Element in dieser Spalte
	                int k = i + 1;
	                while (k < feld.length && feld[k][j] == ' ') {
	                    k++;
	                }
	                // Wenn ein nicht leeres Element gefunden wurde, tausche es mit dem leeren Element
	                if (k < feld.length) {
	                    feld[i][j] = feld[k][j];
	                    feld[k][j] = ' ';
	                }
	            }
	        }
	    }
	}


	// zweidimensionalen Array

	public void nachrueckenVonRechtsNachLinks() {
	    // Iteriere über alle Zeilen des Felds
	    for (int i = 0; i < feld.length; i++) {
	        // Iteriere über alle Spalten des Felds von rechts nach links
	        for (int j = feld[0].length - 1; j > 0; j--) {
	            // Wenn das aktuelle Element leer ist
	            if (feld[i][j] == ' ') {
	                // Suche das rechteste nicht leere Element in dieser Zeile
	                int k = j - 1;
	                while (k >= 0 && feld[i][k] == ' ') {
	                    k--;
	                }
	                // Wenn ein nicht leeres Element gefunden wurde, tausche es mit dem leeren Element
	                if (k >= 0) {
	                    feld[i][j] = feld[i][k];
	                    feld[i][k] = ' ';
	                }
	            }
	        }
	    }
	}


	// zweidimensionalen Array

	public void nachrueckenVonLinksNachRechts() {
	    for (int i = 0; i < feld.length; i++) {
	        for (int j = 0; j < feld[0].length - 1; j++) {
	            if (feld[i][j] == ' ') {
	                // Suche das nächste nicht leere Element in dieser Zeile
	                int k = j + 1;
	                while (k < feld[0].length && feld[i][k] == ' ') {
	                    k++;
	                }
	                // Wenn ein nicht leeres Element gefunden wurde, tausche es mit dem leeren Element
	                if (k < feld[0].length) {
	                    feld[i][j] = feld[i][k];
	                    feld[i][k] = ' ';
	                }
	            }
	        }
	    }
	}


	// Ein dimensionalen Array
	public void nachrueckenVonRechtsNachLinks() {
	    for (int i = 0; i < array.length; i++) { // Iteriere durch jedes Element des Arrays
	        if (array[i] == ' ') { // Wenn das Element leer ist
	            int j = i + 1; // Beginne mit der Suche nach dem nächsten nicht leeren Element
	            while (j < array.length && array[j] == ' ') { // Solange das Ende des Arrays nicht erreicht ist und das aktuelle Element leer ist
	                j++; // Gehe zum nächsten Element
	            }
	            if (j < array.length) { // Wenn ein nicht leeres Element gefunden wurde
	                array[i] = array[j]; // Bewege das Element nach links
	                array[j] = ' '; // Setze das gefundene Element zurück
	            }
	        }
	    }
	}


	// Ein dimensionalen Array
	public void nachrueckenVonLinksNachRechts(char[] array) {
	    for (int i = array.length - 1; i > 0; i--) { // Iteriere von rechts nach links durch das Array
	        if (array[i] == ' ') { // Wenn das Element leer ist
	            int j = i - 1; // Beginne mit der Suche nach dem nächsten nicht leeren Element
	            while (j >= 0 && array[j] == ' ') { // Solange der Anfang des Arrays nicht erreicht ist und das aktuelle Element leer ist
	                j--; // Gehe zum vorherigen Element
	            }
	            if (j >= 0) { // Wenn ein nicht leeres Element gefunden wurde
	                array[i] = array[j]; // Bewege das Element nach rechts
	                array[j] = ' '; // Setze das gefundene Element zurück
	            }
	        }
	    }
	}



}
