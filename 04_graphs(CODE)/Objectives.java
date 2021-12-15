package graph;

import java.io.*;
import java.util.*;

import graph.Character;
import graphsDSESIUCLM.*;

/**
 * @className Objectives
 * @author Andrés González Varela, Maria Jesús Dueñas Recuero
 * @version 1.0
 * @description This class is where we will be executing all the methods to
 *              fullfil the requirements
 * @date 12-12-21
 */
public class Objectives {

	/**
	 * @MethodName numberCharacters
	 * @author Andrés González Varela, Maria Jesús Dueñas Recuero
	 * @description This method will iterate the vertex of the graph and print the
	 *              number of vertex/characters.
	 * @param Graph<DecoratedElement<Character>, DecoratedElement<Integer>> gr.
	 */
	public void numberCharacter(Graph<DecoratedElement<Character>, DecoratedElement<Integer>> gr) {
		Iterator<Vertex<DecoratedElement<Character>>> verIterator;
		int characters = 0;

		verIterator = gr.getVertices();
		while (verIterator.hasNext()) {
			characters++;
			verIterator.next();
		}
		System.out.println("The number of character is: " + characters);
	}

	/**
	 * @MethodName numberRelations
	 * @author Andrés González Varela, Maria Jesús Dueñas Recuero
	 * @description This method will iterate the edges of the graph and print the
	 *              number of edges/relations.
	 * @param Graph<DecoratedElement<Character>, DecoratedElement<Integer>> gr.
	 */
	public void numberRelations(Graph<DecoratedElement<Character>, DecoratedElement<Integer>> gr) {
		Iterator<Edge<DecoratedElement<Integer>>> EdgeIterator;
		int relations = 0;

		EdgeIterator = gr.getEdges();
		while (EdgeIterator.hasNext()) {
			relations++;
			EdgeIterator.next();
		}
		System.out.println("The number of relations is: " + relations);
	}

	/**
	 * @MethodName moreRelations
	 * @author Andrés González Varela, Maria Jesús Dueñas Recuero
	 * @description In this method the idea is to go vertex by vertex until we
	 *              complete all the vertex of the graph. We get all the incident
	 *              edges of each vertex and count them with the nInteractions
	 *              variable. We check every time if this variable is equal to the
	 *              actual maxInteractions. Then if the nInteractions is higher we
	 *              change the value of maxInteractions and we store the Vertex in a
	 *              Stack to print it after the execution. If the nInteractions is
	 *              lower we will do nothing. Then we print the Name of the
	 *              Character and the maxInteractions.
	 * @param Graph<DecoratedElement<Character>, DecoratedElement<Integer>> gr.
	 */
	public void moreRelations(Graph<DecoratedElement<Character>, DecoratedElement<Integer>> gr) {
		int maxInteractions = 0;
		int nInteractions = 0;
		Vertex<DecoratedElement<Character>> actualVertex = null;
		Vertex<DecoratedElement<Character>> moreRelationsVertex = null;
		Edge<DecoratedElement<Integer>> actualEdge = null;
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
			if (nInteractions > maxInteractions) {
				moreRelationsVertex = actualVertex;
				maxInteractions = nInteractions;
			}
			nInteractions = 0;
		}

		System.out.println("Most sociable character: ");
		System.out.println("\t" + moreRelationsVertex.getElement().getElement().getName() + " with a total of "
				+ maxInteractions + " interactions.\n");
	}

	/**
	 * @MethodName moreInteractions
	 * @author Andrés González Varela, Maria Jesús Dueñas Recuero
	 * @description The idea here is similar to the moreRelation method. But we will
	 *              be checking the weight of the Edge We check each vertex edges
	 *              and the check weight by weight until we end travel the graph. If
	 *              the weight is higher we pop the pair of previopus characters and
	 *              then we push the new ones. After all the vertex are checked we
	 *              print the characters information and the higherInteraction.
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
		System.out.println("The characters that has the highest level of interaction are: ");
		while (!pairOfCharacters.isEmpty()) {
			System.out.println("\t" + pairOfCharacters.pop().getElement().getElement().getName());
		}
		System.out.println("\tWith " + highestInteraction + " points");
	}

	/**
	 * @MethodName DFS
	 * @author Andrés González Varela, Maria Jesús Dueñas Recuero
	 * @description This is a DFS strategy it come from parents to the child nodes
	 *              one by one looking for the deap of the tree.
	 * @param Graph<DecoratedElement<Character>, DecoratedElement<Integer>> gr,
	 *                                           Vertex<DecoratedElement<String>>
	 *                                           aux.
	 */
	public static void DFS(Graph gr, Vertex<DecoratedElement<String>> aux) {
		Iterator<Edge> it = null;
		Vertex<DecoratedElement<String>> w = null;
		Edge e = null;
		aux.getElement().setVisited(true);
		it = gr.incidentEdges(aux);
		while (it.hasNext()) {
			e = it.next();
			w = gr.opposite(aux, e);
			if (!w.getElement().isVisited()) {
				DFS(gr, w);
			}
		}
	}

	/**
	 * @MethodName subsets
	 * @author Andrés González Varela, Maria Jesús Dueñas Recuero
	 * @description This method will check if all the graph is connected. It will
	 *              return false in case that a character is not connected with at
	 *              least three characters, before or after.
	 * @param Graph<DecoratedElement<Character>, DecoratedElement<Integer>> gr.
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static boolean subsets(Graph gr) {
		boolean subset = true;
		Vertex<DecoratedElement<String>> aux = null;
		Iterator<Vertex<DecoratedElement<String>>> it = null;
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
