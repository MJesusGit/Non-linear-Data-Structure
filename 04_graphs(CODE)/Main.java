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
	       System.out.println("-----------------------------\nWELCOME TO OUR STAR WARS PROGRAM\n-----------------------------\n[1]. Statistics of the file\n[2]. characters that are not related to each other\n[3]. Holo-message secretly through trusted intermediaries\n[4]. Exit\n\nChoose an option:");
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


//C:\Users\Usuario\eclipse-workspace\data-structure\src\graph\starwars-pers.csv


	public static void prueba1() {
		System.out.println("Write the direction of the File:");
		Scanner read = new Scanner(System.in);
		String path = read.nextLine();
		String line = "";
		String[] tokens;
		LinkedList<Character> list_characters = new LinkedList();
		try {
			FileReader file = new FileReader(path);
			Scanner reader = new Scanner(file);
			reader.nextLine();
			while (reader.hasNextLine()) {
				line=reader.nextLine();
				tokens = line.split(";");
				String id = tokens[0];
				String name = tokens[1];
				int value = Integer.parseInt(tokens[2]);
				Character ch = new Character(id,name,value);
				list_characters.add(ch);
			}
			
			for(int i=0; i<list_characters.size();i++) {
			System.out.println(list_characters.get(i));
			}
			
		} catch (IOException e) {
			System.err.println("Error");
			System.err.println(e.getMessage());
		}
	}
}
