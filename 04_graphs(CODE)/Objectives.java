package graph;

import java.io.*;
import java.util.*;

import graph.Character;
import graphsDSESIUCLM.*;

public class Objectives {

	public void moreRelations(Graph<DecoratedElement<Character>, DecoratedElement<Integer>> gr) {
		int nInteractions = 0;
		int maxInteractions = 0;
		Stack<Vertex<DecoratedElement<Character>>> largestVertex = new Stack();
		Vertex<DecoratedElement<Character>> actualVertex = null;
		Iterator<Vertex<DecoratedElement<Character>>> verIterator;
		Iterator<Edge<DecoratedElement<Integer>>> edgeIterator;

		verIterator = gr.getVertices();
		while (verIterator.hasNext()) {
			actualVertex = verIterator.next();
			edgeIterator = gr.incidentEdges(actualVertex);

			while (edgeIterator.hasNext()) {
				edgeIterator.next();
				nInteractions++;
			}
			if (nInteractions == maxInteractions) {
				largestVertex.push(actualVertex);
			} else if (nInteractions > maxInteractions) {
				while (!largestVertex.isEmpty()) {
					largestVertex.pop();
				}
				largestVertex.push(actualVertex);
				maxInteractions = nInteractions;
			}
			nInteractions = 0;
		}
		System.out.println("Most sociable character: ");

		while (!largestVertex.isEmpty()) {
			System.out.println("\t" + largestVertex.pop().getElement().getElement());
		}
		System.out.println("Number of interactions with different characters: " + maxInteractions);
	}
}
