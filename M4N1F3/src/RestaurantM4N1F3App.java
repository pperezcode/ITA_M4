import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class RestaurantM4N1F3App {

	public static void main(String[] args) {

		// Creem variables int per cada denominació de bitllets i pel preu total del menjar
		
		int bitllet500 = 0, bitllet200 = 0, bitllet100 = 0, bitllet50 = 0, bitllet20 = 0, bitllet10 = 0, bitllet5 = 0;
		int preuMenjar = 0;
		
		// Creem un array String pels plats del menú i un array int pel preu de cada plat
		
		String plats[] = new String[10];
		int preus[] = new int[10];
		

		// Creem un diccionari de dades Java HashMap per assignar un preu a cada plat
		
		HashMap<String, Integer> preuPlat = new HashMap<String, Integer>();

		preuPlat.put("Bufalina", 12);
		preuPlat.put("4 Formaggi", 12);
		preuPlat.put("Pino Daniele", 18);
		preuPlat.put("Margherita", 9);
		preuPlat.put("Prosciutto", 10);
		preuPlat.put("Parmiggiana", 11);
		preuPlat.put("Al Tonno", 13);
		preuPlat.put("Carbonara", 11);
		preuPlat.put("Massimo Troise", 17);
		preuPlat.put("Ortolana", 12);
		
		
		// Omplim els arrays de plats i preu amb un bucle For
		
		int c = 0; 		// Comptador
		
		for (HashMap.Entry<String, Integer> entry : preuPlat.entrySet()) {
			
			plats[c] = entry.getKey();
			preus[c] = entry.getValue();
			c++;
		
		}
		

		// Creem una List on anirem guardant els plats que es van demanant
		
		ArrayList<String> llistaPlats = new ArrayList<String>();	
		
		// Creem una variable per introduir la comanda per teclat
		
		Scanner stringConsola = new Scanner(System.in);  // Objecte Scanner per introduir plats
		Scanner intConsola = new Scanner(System.in);  // Objecte Scanner per introduir si volem demanar més plats
				
			
		// Mitjançant un bucle do/while mostrem els plats per consola i preguntem què volen demanar
		
		int comanda = 1; 	// Iniciem la comanda a 1
		
		String opcio = "";		// Per dir si volem demanar més menjar
		
		do {
			
			String menu = "\n";		// Variable de tipus String per mostrar el menú per pantalla
			
			for (int i = 0; i < plats.length; i++) {		// Mostra menú: plats i preus
				
				menu = menu + (plats[i] + " (" + preus[i] + " euros)\n");
				
			}
			
			System.out.println("\nQuè voldràs per menjar?\n" + menu);
			
		    String platEscollit = stringConsola.nextLine();	// Emmagatzema el text introduït per consola a la variable
		    
		    llistaPlats.add(platEscollit);		// Afegim el plat escollit a la List llistaPlats
		    
		    // Preguntem si vol continuar demanant plats (1: Sí / 0: No) perquè es repeteixi el bucle while  
		    
		    do {
	    		
		    	System.out.println("\nVols seguir demanant menjar?\n1: Sí / 0: No");
		    	
		    	try {
					
		    		opcio = intConsola.next();
					comanda = Integer.parseInt(opcio);				
		    	
		    	}
				
				catch (NumberFormatException e) {
			    	
					comanda = -1;
			    
				} 
								
				if (comanda != 0 && comanda !=1) {
					
					System.out.println("Has introduït un valor erroni!");
				}
	    	
		    } while (comanda != 0 && comanda !=1);
		    	  
		} while (comanda == 1);
		
		
		// Tanquem els objectes creats de la classe Scanner
		
		stringConsola.close();
		intConsola.close();
		
	
		// Comparem la llista de plats demanats amb l'array del menú, i si existeix el plat sumem el preu al preu total
		
		int numPlats = 0;	// Comptador per saber quants plats demanen
		
		for (int i = 0; i < llistaPlats.size(); i++) {
			
			boolean existeixPlat = false;
			
			int p = 0;		// Índex per calcular el preu del plat
			
			for (int j = 0; j < plats.length; j++) {
				
				if (plats[j].toUpperCase().equals(llistaPlats.get(i).toUpperCase())) {
					
					existeixPlat = true;
					p = j;
					break;
				}
			}
			
			if (!existeixPlat) {		// Si no existeix el plat, mostrem missatge de que no està al menú
				
				System.out.println("\nEl plat '" + llistaPlats.get(i) + "' no està al menú.");
			
			} else {
				
				preuMenjar += preus[p];
				numPlats++;
			
			}
		}
	
		
		System.out.println("\nHas demanant " + numPlats + " plat/s.\nPreu total del menjar: " + preuMenjar + " €\n\nCanvi:");

		// Calculem el canvi
		
		int resta = 0;		// En aquesta variable emmagatzarem el que va quedant del canvi
		
		// Calculem els bitllets de 500

		bitllet500 = preuMenjar / 500;		// Divideix el preu entre 500 i es queda amb l'enter
		resta = preuMenjar % 500;			// Això correspon al preu del menjar que queda per calcular, un cop restat els bitllets de 500
		
		System.out.println("- " + bitllet500 + " bitllets de 500 €");
		
		// Calculem els bitllets de 200
		
		bitllet200 = resta / 200;		
		resta = resta % 200;
		
		System.out.println("- " + bitllet200 + " bitllets de 200 €");
	
		// Calculem els bitllets de 100

		bitllet100 = resta / 100;		
		resta = resta % 100;
		
		System.out.println("- " + bitllet100 + " bitllets de 100 €");
		
		// Calculem els bitllets de 50

		bitllet50 = resta / 50;		
		resta = resta % 50;
		
		System.out.println("- " + bitllet50 + " bitllets de 50 €");
		
		// Calculem els bitllets de 20

		bitllet20 = resta / 20;		
		resta = resta % 20;
		
		System.out.println("- " + bitllet20 + " bitllets de 20 €");
		
		// Calculem els bitllets de 10

		bitllet10 = resta / 10;		
		resta = resta % 10;
		
		System.out.println("- " + bitllet10 + " bitllets de 10 €");
		
		// Calculem els bitllets de 5

		bitllet5 = resta / 5;		
		resta = resta % 5;
		
		System.out.println("- " + bitllet5 + " bitllets de 5 €");
		
		// La resta del canvi serà en monedes

		System.out.println("- " + resta + " € en monedes");
			
	}			
		
}
