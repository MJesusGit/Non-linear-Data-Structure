package graph;

import java.util.*;
import java.io.*;
import graphsDSESIUCLM.*;

public class ReadFile {
	
	final static Scanner sc = new Scanner(System.in);
	private String pathCh, pathLk;

	public Graph readCharacters() {
		String line = "";
		String[] tokens;
		LinkedList<Character> list_characters = new LinkedList<Character>();
		LinkedList<DecoratedElementCharacter<Character>> pj = new LinkedList<DecoratedElementCharacter<Character>>();
		TreeMapGraph<Object, Object> gr = new TreeMapGraph<>();
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
				for (int i = 0; i < list_characters.size(); i++) {
					DecoratedElementCharacter<Character> character = new DecoratedElementCharacter<Character>(
							list_characters.get(i).getID(), list_characters.get(i));
					pj.add(character);
				}
				for (int i = 0; i < list_characters.size(); i++) {
					gr.insertVertex(pj.get(i).getElement().getID());
				}
		} catch (IOException e) {
			System.err.println("Error");
			System.err.println(e.getMessage());
		}
		return gr;
	}
	public  Graph readLinks(Graph gr) {
		LinkedList<Links> link_list = new LinkedList<Links>();
		String line = "";
		String[] tokens;
		try {
			FileReader file = new FileReader(pathLk);
			Scanner reader = new Scanner(file);
			reader.nextLine();
			int id=0;
			while (reader.hasNextLine()) {
				line = reader.nextLine();
				tokens = line.split(";");
				String sourceID = tokens[0];
				String targetID = tokens[1];
				int weight = Integer.parseInt(tokens[2]);
				Links link = new Links(sourceID, targetID, weight);
				DecoratedElementLinks<Links> edges = new DecoratedElementLinks<Links>(Integer.toString(id),weight,link);
				gr.insertEdge(gr.getVertex(sourceID),gr.getVertex(targetID),edges);
				id++;
			}
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