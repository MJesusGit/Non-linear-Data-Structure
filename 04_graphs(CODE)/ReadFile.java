package graph;

import java.util.*;
import java.io.*;
import graphsDSESIUCLM.*;

public class ReadFile {

	final static Scanner sc = new Scanner(System.in);
	private String pathCh, pathLk;

	public LinkedList<Character> readCharacters() {
		String line = "";
		String[] tokens;
		LinkedList<Character> list_characters = new LinkedList();
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
				list_characters.add(ch);
			}
		} catch (IOException e) {
			System.err.println("Error");
			System.err.println(e.getMessage());
		}
		return list_characters;
	}

	public Graph<DecoratedElement<Character>, DecoratedElement<Integer>> readLinks(LinkedList<Character> list_characters) {
		Graph<DecoratedElement<Character>, DecoratedElement<Integer>> gr = new TreeMapGraph<DecoratedElement<Character>, DecoratedElement<Integer>>();
		LinkedList<Links> link_list = new LinkedList<Links>();
		LinkedList<DecoratedElement<Character>> pj = new LinkedList<DecoratedElement<Character>>();
		String line = "";
		String[] tokens;
		
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
				Links link = new Links(sourceID, targetID, weight);
				link_list.add(link);
			}

			for (int i = 0; i < list_characters.size(); i++) {
				DecoratedElement<Character> character = new DecoratedElement<Character>(list_characters.get(i).getID(), list_characters.get(i));
				System.out.println(character);
				pj.add(character);
				gr.insertVertex(character); 
			}
			
			for (int i = 0; i < link_list.size(); i++) {
				DecoratedElement<Integer> weight = new DecoratedElement<Integer>(link_list.get(i).getSourceID(), link_list.get(i).getWeight());
				gr.insertEdge(pj.get(Integer.parseInt(link_list.get(i).getSourceID())), pj.get(Integer.parseInt(link_list.get(i).getTargetID())), weight);
			}

		} catch (IOException e) {
			System.err.println("Error");
			System.err.println(e.getMessage());
		}
		return gr;
	}

	public ReadFile(String pathCh, String pathLk) {
		super();
		this.pathCh = pathCh;
		this.pathLk = pathLk;
	}
}