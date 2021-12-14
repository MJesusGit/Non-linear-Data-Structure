package graph;

import java.util.*;
import java.io.*;
import graphsDSESIUCLM.*;

/**
 * @className ReadFile
 * @author Andrés González Varela, Maria Jesús Dueñas Recuero
 * @version 1.0
 * @date 12-12-21
 */

public class ReadFile {

	final static Scanner sc = new Scanner(System.in);
	private String pathCh, pathLk;
	
	/**
	 * @MethodName readCharacters
	 * @author Andrés González Varela, Maria Jesús Dueñas Recuero
	 * @description In this method the main idea is to read the excel where contains the information of the characters in
	 *				this way as we are reading the file storing the information in an array called tokens[], in such a way that
	 *				inside the while we read the line and separating them the information by ”;”. As we get the character object 
	 *				we create the character decorator element and add it to the graph.
	 * 
	 */
	public Graph<DecoratedElement<Character>, DecoratedElement<Integer>> readCharacters() {
		String line = "";
		String[] tokens;
		int characters = -1;
		Graph<DecoratedElement<Character>, DecoratedElement<Integer>> gr = new TreeMapGraph<DecoratedElement<Character>, DecoratedElement<Integer>>();
		try {
			FileReader file = new FileReader(pathCh);
			Scanner reader = new Scanner(file);
			reader.nextLine();
			while (reader.hasNextLine()) {
				line = reader.nextLine();
				tokens = line.split(";");
				String id = tokens[0];
				String name = tokens[1];
				int value = Integer.parseInt(tokens[2]);
				Character ch = new Character(id, name, value);
				DecoratedElement<Character> character = new DecoratedElement<Character>(id, ch);
				gr.insertVertex(character);
				characters++;
			}

			System.out.println("a) The number of characters is: " + characters + "\n");
		} catch (IOException e) {
			System.err.println("Error");
			System.err.println(e.getMessage());
		}
		return gr;
	}

	
	/**
	 * @MethodName readLinks
	 * @author Andrés González Varela, Maria Jesús Dueñas Recuero
	 * @description In this method the main idea is to read the excel where contains the information of the links in
	 *				this way as we are reading the file storing the information in an array called tokens[], in such a way that
	 *				inside the while we read the line and separating them the information by ”;”. As we get the links object 
	 *				we create a integer decorator element and add it to the graph.
	 * @param Graph<DecoratedElement<Character>, DecoratedElement<Integer>> gr.
	 */
	public Graph<DecoratedElement<Character>, DecoratedElement<Integer>> readLinks(Graph<DecoratedElement<Character>, DecoratedElement<Integer>> gr) {
		String line = "";
		String[] tokens;
		int relations = 0;

		try {
			FileReader file = new FileReader(pathLk);
			Scanner reader = new Scanner(file);
			reader.nextLine();

			while (reader.hasNextLine()) {
				line = reader.nextLine();
				tokens = line.split(";");
				String sourceID = tokens[0];
				String targetID = tokens[1];
				int weight = Integer.parseInt(tokens[2]);
				DecoratedElement<Integer> relationWeight = new DecoratedElement<Integer>(sourceID, weight);
				gr.insertEdge(gr.getVertex(sourceID), gr.getVertex(targetID), relationWeight);
				relations++;
			}

			System.out.println("b) The total number of relations is: " + relations + "\n");
		} catch (IOException e) {
			System.err.println("Error");
			System.err.println(e.getMessage());
		}
		return gr;
	}

	public ReadFile(String pathCh, String pathLk) {
		this.pathCh = pathCh;
		this.pathLk = pathLk;
	}

}