package graph;

import java.util.*;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Scanner;
import graphsDSESIUCLM.*;

public class ReadFile {

	public List<Character> readCharacters() {
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
		return list_characters;
	}

	public static Graph createGraph(List<Character> list_characters, Graph gr) {
		ArrayList<DecoratedElement<Character>> pj = new ArrayList<DecoratedElement<Character>>();
		
		for (int i = 0; i < list_characters.size(); i++) {
			DecoratedElement<Character> character = new DecoratedElement<Character>(list_characters.get(i));
			pj.add(character);
		}
		for (int i = 0; i < list_characters.size(); i++) {
			gr.insertVertex(pj.get(i));
		}
		return gr;
	}
}