package graph;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

import java.util.*;

import graph.Character;
import graphsDSESIUCLM.Edge;
import graphsDSESIUCLM.Graph;
import graphsDSESIUCLM.TreeMapGraph;
import graphsDSESIUCLM.Vertex;

/**
 * @className Main
 * @author Andrés González Varela, Maria Jesús Dueñas Recuero
 * @version 1.0
 * @description This class is the entry point of our java program,It is where
 *              the project will be execute.
 * @date 12-12-21
 */
public class Main {

	/**
	 * @className main
	 * @author Andrés González Varela, Maria Jesús Dueñas Recuero
	 * @version 1.0
	 * @description We call here the method menu to execute and choose the options
	 *              of the program
	 * @throws IOException
	 * @date 12-12-21
	 */
	public static void main(String[] args) throws IOException {
		menu();
	}

	/**
	 * @className menu
	 * @author Andrés González Varela, Maria Jesús Dueñas Recuero
	 * @version 1.0
	 * @description This method contains a menu with all the options of the
	 *              requirements. We will ask for the location of the files and
	 * @date 12-12-21
	 */
	public static void menu() throws FileNotFoundException {

		Scanner reader = new Scanner(System.in);
		boolean exit = false;
		int option; // Guardaremos la opción del usuario
		Objectives objectives = new Objectives();
		ShortestPath shortestPath = new ShortestPath();
		DecoratedElement startNode, endNode, nx = null;
		DecoratedElement<Character> node = null;
		int size;
		boolean bool1 = true, bool2 = true;
		Vertex<DecoratedElement<Character>> aux, t = null, s = null;
		Stack<DecoratedElement> sp = new Stack<DecoratedElement>();
		Iterator<Vertex<DecoratedElement<Character>>> it;
		Graph<DecoratedElement<Character>, DecoratedElement<Integer>> gr = new TreeMapGraph<DecoratedElement<Character>, DecoratedElement<Integer>>();
		System.out.println(
				"-----------------------------\nWELCOME TO OUR STAR WARS PROGRAM\n-----------------------------\n");
		System.out.println("Write the direction of the characters file");
		Scanner read = new Scanner(System.in);
		String pathCh = read.nextLine();
		System.out.println("Write the direction of the links file");
		String pathLk = read.nextLine();
		ReadFile readFile = new ReadFile(pathCh, pathLk);
		gr = readFile.readCharacters();
		gr = readFile.readLinks(gr);

		try {
			while (!exit) {
				System.out.println(
						"[1]. Statistics of the file\n[2]. Characters that are not related to each other\n[3]. Holo-message secretly through trusted intermediaries\n[4]. Exit\n\nChoose an option:");
				option = reader.nextInt();
				switch (option) {
				case 1:
					objectives.numberCharacter(gr);
					objectives.numberRelations(gr);
					objectives.moreRelations(gr);
					objectives.moreInteraction(gr);
					break;
				case 2:
					boolean find = Objectives.subsets(gr);

					if (!find) {
						System.out.print("There is not subsets\n");

					} else {
						System.out.print("There is  subsets\n");
					}
					break;
				case 3:
					try {
						shortestPath.holo(gr);
					} catch (NullPointerException ex) {
						System.out.println("ERROR:" + ex.getMessage() + "\tintroduce the name of a character");

					}
					break;
				case 4:
					System.out.println("Thank you for watching");
					exit = true;
					break;
				default:
					System.out.println("Introduce only number amount 1 and 4");
				}

			}

		} catch (InputMismatchException e) {
			System.out.println("ERROR :Insert only number please.Try again:");
			menu();

		}
	}

}
