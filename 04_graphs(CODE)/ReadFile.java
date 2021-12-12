package graph;

import java.util.*;
import java.io.*;
import graphsDSESIUCLM.*;

public class ReadFile {
	// public static final String SEPARATOR = ";";
	final static Scanner sc = new Scanner(System.in);
	private String pathCh, pathLk;

	public Graph<DecoratedElement<Character>, DecoratedElement<Integer>> readCharacters() {
		String line = "";
		String[] tokens;
		int characters = -1;
		// LinkedList<Character> list_characters = new LinkedList<Character>();
		// LinkedList<DecoratedElementCharacter<Character>> pj = new
		// LinkedList<DecoratedElementCharacter<Character>>();
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

			System.out.println("The number of characters is: " + characters);
		} catch (IOException e) {
			System.err.println("Error");
			System.err.println(e.getMessage());
		}
		return gr;
	}

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

			System.out.println("The total number of relations is: " + relations);
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