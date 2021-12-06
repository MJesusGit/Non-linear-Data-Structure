package graph;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

import java.util.*;

public class Main {

	public static final String SEPARATOR = ";";
	public static final String COMMAS = ",";

	public static void main(String[] args) throws IOException {
		
		menu();

	}
public static void menu() {
	Scanner reader = new Scanner(System.in);
    boolean exit = false;
    int option; //Guardaremos la opcion del usuario
     
    try {
	    while(!exit){
	       System.out.println("-----------------------------\nWELCOME TO US STAR WARS PROGRAM\n-----------------------------\n[1]. Statistics of the file\n[2]. characters that are not related to each other\n[3]. Holo-message secretly through trusted intermediaries\n[4]. Exit\n\nChoose an option:");
	       option = reader.nextInt();
	       switch(option){
           case 1:
        	   prueba1();
               break;
           case 2:
               System.out.println("Has seleccionado la opcion 2");
               break;
            case 3:
               System.out.println("Has seleccionado la opcion 3");
               break;
            case 4:
            	System.out.println("Thank you for watching");
               exit=true;
               break;
            default:
               System.out.println("Only number amount 1 and 4");
   }
	
    }

    } catch (InputMismatchException e) {
        System.out.println("Insert only number please.Try again:");
        menu();
        
    }
}





	public static void prueba1() {
		System.out.println("Write the direction of the File:");

		Scanner read = new Scanner(System.in);
		String path = read.nextLine();
		read.useDelimiter("[,\n]");
		String line = "";
		String str = null;
		String[] tokens;
		try {
			FileReader leer_archivo = new FileReader(path);
			BufferedReader bufferdefault = new BufferedReader(leer_archivo);
			boolean esPrimeraLinea = true;
			while ((line = bufferdefault.readLine()) != null) {
				// Si es la primera línea, continuamos con la siguiente
				if (esPrimeraLinea) {
					esPrimeraLinea = false;
					continue;
				}
				// Ahora necesito deshacerme de la primera linea
				tokens = line.split(",");
				for (int i = 0; i < tokens.length; i++) {
					String id = tokens[i];
					String name = tokens[i+1];
					int value = Integer.parseInt(tokens[i+2]);
					DecoratedElement<String> pers = new DecoratedElement<String>(id, name,(int)value);
					System.err.println(pers + "\n");
				}

			}
		} catch (IOException e) {
			System.err.println("Error");
			System.err.println(e.getMessage());
		}
	}

}
