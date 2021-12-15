package graph;

import java.io.IOException;
import java.util.*;

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
	public static final String SEPARATOR = ";";
	public static final String COMMAS = ",";

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
	public static void menu() {
		Scanner reader = new Scanner(System.in);
		boolean exit = false;
		int option; // Guardaremos la opción del usuario
		Objectives objectives = new Objectives();
		//String startNode, endNode; 
		String nx = null;
		DecoratedElement<Character> node = null;
		int size;
		boolean bool1 = true, bool2 = true;
		Vertex<DecoratedElement<Character>> aux, t = null, s = null;
		Stack<DecoratedElement> sp = new Stack<DecoratedElement>();
		Iterator<Vertex<DecoratedElement<Character>>> it;
		Graph<DecoratedElement<Character>, DecoratedElement<Integer>> gr = new TreeMapGraph<DecoratedElement<Character>, DecoratedElement<Integer>>();

		try {
			while (!exit) {
				System.out.println(
						"-----------------------------\nWELCOME TO OUR STAR WARS PROGRAM\n-----------------------------\n[1]. Statistics of the file\n[2]. Characters that are not related to each other\n[3]. Holo-message secretly through trusted intermediaries\n[4]. Exit\n\nChoose an option:");
				option = reader.nextInt();
				switch (option) {

				case 1:
					System.out.println("Write the direction of the characters file");
					Scanner read = new Scanner(System.in);
					String pathCh = read.nextLine();
					System.out.println("Write the direction of the links file");
					String pathLk = read.nextLine();
					ReadFile readFile = new ReadFile(pathCh, pathLk);
					gr = readFile.readCharacters();
					gr = readFile.readLinks(gr);
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
					// We write the names of the characters that will send and receive the message
					System.out.println("Write the name of the character that will send the message");
					Scanner viewer = new Scanner(System.in);
					String startNode = viewer.next();
					System.out.println("Write the name of the character that will receive the message");
					String endNode = viewer.next();
					// We get the vertices that our graph includes
					it = gr.getVertices();
					// We go all over the graph comparing the name we wrote and the name of each of
					// the vertices
					while (it.hasNext() && (bool1 || bool2)) {
						aux = it.next();
						nx = aux.getID();
						if (nx == startNode) {
							s = aux;
							bool1 = false;
						}
						if (nx == endNode) {
							t = aux;
							bool2 = false;
						}
					}
					// When the condition gets verified, we can proceed sending or not the message
					if (!(bool1 || bool2)) {
						node = ShortestPath.findshortestconnection(gr, s, t);
						if (node.getParent() == null) {
							System.out.println(
									"\nThe message can't be sent. The intermediaries haven't a good relationship.");
						} else {
							System.out.println("\nThe message will be sent through: ");
							while (node.getParent() != null) {
								sp.push(node);
								node = node.getParent();
							}
							sp.push(node);
							size = sp.size();
							for (int i = 0; i < size - 1; i++) {
								node = sp.pop();
								System.out.print(node.getElement().toString() + "(" + node.getDistance() + ")" + "-");
							}
							node = sp.pop();
							System.out.print(node.getElement().toString() + "(" + node.getDistance() + ")");
						}
					} else {
						System.out.println("\nTry again to correctly read the info of the file by selecting option 1.");
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
