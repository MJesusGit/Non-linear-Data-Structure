package graph;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

import java.util.*;

import graph.Character;
import graphsDSESIUCLM.Graph;
import graphsDSESIUCLM.TreeMapGraph;

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
        	   System.out.println("Write the direction of the characters file");
        	   Scanner read = new Scanner(System.in);
        	   String pathCh = read.nextLine();
        	   System.out.println("Write the direction of the links file");
        	   String pathLk = read.nextLine();
        	   ReadFile readFile = new ReadFile(pathCh, pathLk);
        	   Graph gr = new TreeMapGraph<>();
        	   gr = readFile.readCharacters();
        	   readFile.readLinks(gr);
        	   //Graph<DecoratedElementCharacter<Character>, DecoratedElementCharacter<Integer>> gr = new TreeMapGraph<DecoratedElementCharacter<Character>, DecoratedElementCharacter<Integer>>();
        	   //gr = readFile.readLinks(list_characters);
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


	
}
