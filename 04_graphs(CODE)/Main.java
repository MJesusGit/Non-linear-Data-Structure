package graphs;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

import java.util.*;

import graphs.Character;
import graphsDSESIUCLM.Graph;
import graphsDSESIUCLM.TreeMapGraph;
import graphsDSESIUCLM.Vertex;

public class Main {

	public static final String SEPARATOR = ";";
	public static final String COMMAS = ",";

	public static void main(String[] args) throws IOException {

		menu();

	}

	public static void menu() {
		Scanner reader = new Scanner(System.in);
		boolean exit = false;
		int option; // Guardaremos la opción del usuario
		Objectives objectives = new Objectives();
		DecoratedElement startNode, endNode, nx = null;
		DecoratedElement<Character> node = null;
		int size;
		boolean bool1 = true, bool2 = true;
		Vertex<DecoratedElement<Character>> aux, t, s = null;
		Stack<DecoratedElement> sp = new Stack<DecoratedElement>();
		Iterator<Vertex<DecoratedElement<Character>>> it;
		Graph<DecoratedElement<Character>, DecoratedElement<Integer>> gr = new TreeMapGraph<DecoratedElement<Character>, DecoratedElement<Integer>>();

		try {
			while (!exit) {
				System.out.println(
						"-----------------------------\nWELCOME TO OUR STAR WARS PROGRAM\n-----------------------------\n[1]. Statistics of the file\n[2]. characters that are not related to each other\n[3]. Holo-message secretly through trusted intermediaries\n[4]. Exit\n\nChoose an option:");
				option = reader.nextInt();
				switch (option) {
				case 1:
					System.out.println("Write the direction of the characters file");
					Scanner read = new Scanner(System.in);
					String pathCh = read.nextLine();
					System.out.println("Write the direction of the links file");
					String pathLk = read.nextLine();
					ReadFile readFile = new ReadFile(pathCh, pathLk);
					// Graph<DecoratedElement<Character>, DecoratedElement<Integer>> gr = new
					// TreeMapGraph<DecoratedElement<Character>, DecoratedElement<Integer>>();
					gr = readFile.readCharacters();
					gr = readFile.readLinks(gr);
					objectives.moreRelations(gr);
					objectives.moreInteraction(gr);
					break;
				case 2:
					System.out.println("Has seleccionado la opcion 2");
					break;
				case 3:

					// We write the names of the characters that will send and receive the message
					System.out.println("Write the character that will send the message");
					Scanner viewer = new Scanner(System.in);
					startNode = new DecoratedElement(reader.next(), viewer);
					System.out.println("Write the character that will receive the message");
					endNode = new DecoratedElement(reader.next(), viewer);
					// We get the vertices that our graph includes
					it = gr.getVertices();
					// We go all over the graph comparing the name we wrote and the name of each of
					// the vertices
					while (it.hasNext() && (bool1 || bool2)) {
						aux = it.next();
						nx = aux.getElement();
						if (nx.equals(startNode)) {
							s = aux;
							bool1 = false;
						}
						if (nx.equals(endNode)) {
							t = aux;
							bool2 = false;
						}
					}
					// When we complete the search, the need to ensure that they have good
					// relationship
					if (ShortestPath.checktrust(gr, s, t) == true) {
						// When the condition gets verified, we can proceed sending or not the message
						if (!(bool1 || bool2)) {
							node = ShortestPath.findshortestconection(gr, s, t);
							if (node.getParent() == null) {
								System.out.println("\nThere is no path");
							} else {
								System.out.println("\nPath");
								while (node.getParent() != null) {
									sp.push(node);
									node = node.getParent();
								}
								sp.push(node);
								size = sp.size();
								for (int i = 0; i < size - 1; i++) {
									node = sp.pop();
									System.out
											.print(node.getElement().toString() + "(" + node.getDistance() + ")" + "-");
								}
								node = sp.pop();
								System.out.print(node.getElement().toString() + "(" + node.getDistance() + ")");
							}
						} else {
							System.out.println("\nAt least one of the nodes is not in the graph");
						}
					} else {
						System.out.println("It can't be possible, they have no good relationship");
					}
					break;
				case 4:
					System.out.println("Thank you for watching");
					exit = true;
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

}
