package graph;

import java.io.*;
import java.util.*;

import graph.Character;
import graphsDSESIUCLM.*;

/**
 * @className Objectives
 * @author Andrés González Varela, Maria Jesús Dueñas Recuero
 * @version 1.0
 * @description This class is where we will be executing all the methods to fullfil the requirements
 * @date 12-12-21
 */
public class Objectives {

	/**
	 * @MethodName moreRelations
	 * @author Andrés González Varela, Maria Jesús Dueñas Recuero
	 * @description In this method the idea is to go vertex by vertex until we complete all the vertex of the graph. We get
	 *  			all the incident edges of each vertex and count them with the nInteractions variable. We check every time if 
	 * 				this variable is equal to the actual maxInteractions. Then if the nInteractions is higher we change the value of 
	 * 				maxInteractions and we store the Vertex in a Stack to print it after the execution. If the nInteractions is lower 
	 * 				we will do nothing. Then we print the Name of the Character and the maxInteractions.
	 * @param Graph<DecoratedElement<Character>, DecoratedElement<Integer>> gr.
	 */
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
		System.out.print("c) The character with mos interactions is: "+" ");

		while (!largestVertex.isEmpty()) {
			System.out.print(largestVertex.pop().getElement().getElement().getName());
		}
		System.out.print(" with an amount of interactions with different characters: " + maxInteractions+"\n");
	}
	
	/**
	 * @MethodName moreInteractions
	 * @author Andrés González Varela, Maria Jesús Dueñas Recuero
	 * @description The idea here is similar to the moreRelation method. But we will be checking the weight of the Edge 
	 * 				We check each vertex edges and the check weight by weight until we end travel the graph. If the weight
	 * 				is higher we pop the pair of previopus characters and then we push the new ones. After all the vertex 
	 * 				are checked we print the characters information and the higherInteraction.
	 * @param Graph<DecoratedElement<Character>, DecoratedElement<Integer>> gr.
	 */
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
		System.out.println("d) The characters that has the highest level of interaction are: ");
		while (!pairOfCharacters.isEmpty()) {
			System.out.println("\t" + pairOfCharacters.pop().getElement().getElement().getName());
		}
		System.out.println("With " + highestInteraction + " points");
	}
	public static void DFS(Graph gr, Vertex<DecoratedElement<String>> aux) {
		Iterator <Edge> it =null;
		Vertex<DecoratedElement<String>> w=null;
		Edge e= null;
		aux.getElement().setVisited(true);
		it=gr.incidentEdges(aux);
		while(it.hasNext()) {
			e=it.next();
			w=gr.opposite(aux,e);
			if(!w.getElement().isVisited()) {
				DFS(gr,w);
			}
		}
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static boolean subsets(Graph gr) {
		boolean subset = true;
		Vertex<DecoratedElement<String>> aux = null;
		Iterator<Vertex<DecoratedElement<String>>> it= null;
		it = gr.getVertices();
		if (it.hasNext()) {
			aux = it.next();
			DFS(gr, aux);
		}
		it = gr.getVertices();
		while (it.hasNext() && subset) {
			aux = it.next();
			subset = aux.getElement().isVisited();
		}
		return subset;
	}
}
