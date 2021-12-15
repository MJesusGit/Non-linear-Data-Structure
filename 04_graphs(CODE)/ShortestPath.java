package graph;

import java.util.*;
import graphsDSESIUCLM.*;
/**
 * @className Shortest Path
 * @author Andrés González Varela, Maria Jesús Dueñas Recuero
 * @version 1.0
 * @description This class is where we will be executing the methods to fullfil the third assessment
 * @date 13-12-21
 */
public class ShortestPath {

	private Vertex<DecoratedElement<Character>> source;
	private Vertex<DecoratedElement<Character>> target;

	/**
	 * @MethodName BFS
	 * @author Andrés González Varela, Maria Jesús Dueñas Recuero
	 * @description This method will be used to obtain path using a BFS strategy.
	 *              First we introduce the first vertex in a queue. After this we
	 *              will check all the vertex and in case the relation between the
	 *              vertex in the queue and the one we are checking is greater than
	 *              8 we introduce it in the queue and we change the vertex variable
	 *              Visited to "True" and set its father as the first vertex. When
	 *              we reach the end of the queue we have done this with all the
	 *              vertex.
	 * @param Graph<DecoratedElement<Character>, DecoratedElement<Integer>> gr,
	 *                                           Vertex<DecoratedElement<Character>>
	 *                                           Source,
	 *                                           Vertex<DecoratedElement<Character>>
	 *                                           Target.
	 * @return DecoratedElement<Character>
	 */
	public DecoratedElement<Character> BFS(Graph<DecoratedElement<Character>, DecoratedElement<Integer>> gr,
			Vertex<DecoratedElement<Character>> Source, Vertex<DecoratedElement<Character>> Target) {
		Queue<Vertex<DecoratedElement<Character>>> queue = new LinkedList<Vertex<DecoratedElement<Character>>>();
		boolean end = true;
		int value = 0;
		Vertex<DecoratedElement<Character>> p1, p2 = null;
		Edge<DecoratedElement<Integer>> l1;
		Iterator<Edge<DecoratedElement<Integer>>> edgeIterator;

		Source.getElement().setVisited(true);
		queue.offer(Source);

		while (!queue.isEmpty() && end) {
			p1 = queue.poll();
			edgeIterator = gr.incidentEdges(p1);
			while (edgeIterator.hasNext() && end) {
				l1 = edgeIterator.next();
				value = l1.getElement().getDistance();
				p2 = gr.opposite(p1, l1);
				if (!(p2.getElement()).isVisited()) {
					if (value >= 8) {
						(p2.getElement()).setParent(p1.getElement());
						(p2.getElement()).setVisited(true);
						queue.offer(p2);
						end = !(p2.getElement().equals(Target.getElement()));
					}
				}
			}
		}
		
		if (end) 
		p2.getElement().setParent(null);
		return p2.getElement();
	}

	/**
	 * @MethodName holo
	 * @author Andrés González Varela, Maria Jesús Dueñas Recuero
	 * @description In this method the user will give us two characters he want to
	 *              tries to try his path with the BFS method. First you check both
	 *              vertex are in the graph. Then if they are valid vertexs we call
	 *              the BFS method. If there is a usable path we receive the final
	 *              vertex with it parent. Then you start coming back parent by
	 *              parent and like that we obtain the path to send the message.
	 * @param Graph<DecoratedElement<Character>, DecoratedElement<Integer>> gr.
	 */
	public void holo(Graph<DecoratedElement<Character>, DecoratedElement<Integer>> gr) {
		DecoratedElement<Character> sender, receiver, nexus, node = null;
		boolean firstCond = true;
		boolean secondCond = true;
		int sizeOfPath;
		String firstID = null, secondID = null;
		String Sender, Recipient;
		Vertex<DecoratedElement<Character>> Target = null, Source = null, actualVertex, firstIDVertex, secondIDVertex;
		Edge<DecoratedElement<Integer>> edge;
		Edge<DecoratedElement<Integer>> edge2;
		Stack<DecoratedElement<Character>> stack = new Stack<DecoratedElement<Character>>();
		Iterator<Vertex<DecoratedElement<Character>>> characterIterator;
		Iterator<Vertex<DecoratedElement<Character>>> characterIterator2;
		Iterator<Edge<DecoratedElement<Integer>>> edgeIterator;
		Scanner read = new Scanner(System.in);

		System.out.println("Who is the source of the message?");
		Sender = read.nextLine();
		Sender = Sender.toUpperCase();
		System.out.println("Who recipients the message?");
		Recipient = read.nextLine();
		Recipient = Recipient.toUpperCase();

		characterIterator = gr.getVertices();
		while (characterIterator.hasNext()) {
			actualVertex = characterIterator.next();
			if (actualVertex.getElement().getElement().getName().equals(Sender)) {
				firstID = actualVertex.getID();
			}
			if (actualVertex.getElement().getElement().getName().equals(Recipient)) {
				secondID = actualVertex.getID();
			}
		}
		firstIDVertex = gr.getVertex(firstID);
		secondIDVertex = gr.getVertex(secondID);
		sender = firstIDVertex.getElement();
		receiver = secondIDVertex.getElement();

		characterIterator2 = gr.getVertices();
		while (characterIterator2.hasNext() && (firstCond || secondCond)) {
			actualVertex = characterIterator2.next();

			nexus = actualVertex.getElement();
			if (nexus.equals(sender)) {
				Source = actualVertex;
				firstCond = false;
			}
			if (nexus.equals(receiver)) {
				Target = actualVertex;
				secondCond = false;
			}
		}

		if (!firstCond || secondCond) {
			node = BFS(gr, Source, Target);
			if (node.getParent() == null) {
				System.out.println("There isn's a safe path to send the message");
				characterIterator = gr.getVertices();
				while (characterIterator.hasNext()) {
					actualVertex = characterIterator.next();
					actualVertex.getElement().setVisited(false);
					actualVertex.getElement().setParent(null);
				}
			} else {
				while (node.getParent() != null) {
					stack.push(node);
					node = node.getParent();
				}
				characterIterator = gr.getVertices();
				while (characterIterator.hasNext()) {
					actualVertex = characterIterator.next();
					actualVertex.getElement().setVisited(false);
					actualVertex.getElement().setParent(null);
				}
				stack.push(node);
				sizeOfPath = stack.size();
				System.out.println("The secure path to reach form " + Sender + " to " + Recipient + "is:");
				for (int i = 0; i < sizeOfPath - 1; i++) {
					node = stack.pop();
					System.out.print(node.getElement().getName() + "->");
				}
				node = stack.pop();
				System.out.println(node.getElement().getName());
			}
		} else
			System.out.println("Some node is not in the graph");
	}
}