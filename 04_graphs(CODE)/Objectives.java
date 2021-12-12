package graph;

import java.io.*;
import java.util.*;

import graph.Character;
import graphsDSESIUCLM.*;

public class Objectives {

	public void moreRelations(Graph<DecoratedElement<Character>, DecoratedElement<Integer>> gr) {
		int nInteractions = 0;
		int maxInteractions = 0;
		Stack<Vertex<DecoratedElement<Character>>> largestVertex = new Stack<Vertex<DecoratedElement<Character>>>();
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
	
	public void moreInteraction(Graph<DecoratedElement<Character>, DecoratedElement<Integer>> gr) {
		int highestInteraction = 0;
		int interaction = 0;
		Stack<Vertex<DecoratedElement<Character>>> pairOfCharacters = new Stack<Vertex<DecoratedElement<Character>>>();
		Iterator<Edge<DecoratedElement<Integer>>> edgeIterator;
		Iterator<Vertex<DecoratedElement<Character>>> verIterator;
		Edge<DecoratedElement<Integer>> actualEdge = null;
		Vertex<DecoratedElement<Character>> actualVertex = null;

		verIterator = gr.getVertices();
		while (verIterator.hasNext()) {
			actualVertex = verIterator.next();
			edgeIterator = gr.incidentEdges(actualVertex);
			while (edgeIterator.hasNext()) {
				actualEdge = edgeIterator.next();
				interaction = actualEdge.getElement().getElement();
				if (interaction > highestInteraction && pairOfCharacters.isEmpty()) {
					highestInteraction = interaction;
					pairOfCharacters.push(actualVertex);
					pairOfCharacters.push(gr.opposite(actualVertex, actualEdge));
				} else if (interaction > highestInteraction && !pairOfCharacters.isEmpty()) {
					highestInteraction = interaction;
					while (!pairOfCharacters.isEmpty()) {
						pairOfCharacters.pop();
					}
					pairOfCharacters.push(gr.opposite(actualVertex, actualEdge));
					pairOfCharacters.push(actualVertex);
				}
			}
		}
		System.out.println("The characters that has the highest level of interaction are: ");
		while (!pairOfCharacters.isEmpty()) {
			System.out.println("\t" + pairOfCharacters.pop().getElement().getElement());
		}
		System.out.println("With " + highestInteraction + " points");
	}
	
	public static void DFS(Graph gr , Vertex<DecoratedElement> v) {
		Iterator <Edge> it =null;
		Vertex<DecoratedElement> w =null;
		Edge e =null;
		v.getElement().setVisited(true);
		it=gr.incidentEdges(v);
		while(it.hasNext()) {
			e=it.next();
			w=gr.opposite(v, e);
			if(!w.getElement().getVisited()) {
				DFS(gr,w);
			}
		}
	}
	public static boolean subsets(Graph gr) {
		boolean subset=true;
		Vertex<DecoratedElement> it= null;
		it=gr.getVertex();
		if(it.hasNext()) {
			aux=it.next();
			DFS(gr,aux);			
		}
		it=gr.getVertices();
		while(it.hasNext() && subset) {
			aux=it.next();
			subset=aux.getElement().getVisited();			
		}
		return subset;
	}
	
}
