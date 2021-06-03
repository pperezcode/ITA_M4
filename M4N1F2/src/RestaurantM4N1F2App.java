import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class RestaurantM4N1F2App {

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
		
		Scanner stringConsola = new Scanner(System.in);  // Create a Scanner object
		Scanner intConsola = new Scanner(System.in);  // Create a Scanner object
				
		// Mitjançant un bucle do/while mostrem els plats per consola i preguntem què volen demanar
		
		int comanda = 1; 	// Iniciem la comanda a 1
		
			
		do {
			
			String menu = "\n";		// Variable de tipus String per mostrar el menú per pantalla
			
			for (int i = 0; i < plats.length; i++) {		// Mostra menú: plats i preus
				
				menu = menu + (plats[i] + " (" + preus[i] + " euros)\n");
				
			}
			
			System.out.println("\nQuè voldràs per menjar?\n" + menu);
			
		    String platEscollit = stringConsola.nextLine();	// Emmagatzema el text introduït per consola a la variable
		    
		    llistaPlats.add(platEscollit);		// Afegim el plat introduït a la llista de plats
		    
		    // Preguntem si vol continuar demanant plats (1: Sí / 0: No) perquè es repeteixi el bucle while
		    
		    System.out.println("\nVols seguir demanant menjar?\n1: Sí / 0: No");
		    
		    comanda = intConsola.nextInt();
		    
		} while (comanda == 1);
		
		
		// Tanquem els objectes creats de la classe Scanner
		
		stringConsola.close();
		intConsola.close();
		
	}

}
