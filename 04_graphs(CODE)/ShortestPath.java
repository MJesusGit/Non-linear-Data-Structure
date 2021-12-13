package graph;


import java.util.*;
import graphsDSESIUCLM.*;

public class ShortestPath {

	// BFS to find the shortest connection between two characters
	public static DecoratedElement findshortestconnection(Graph g, Vertex<DecoratedElement<Character>> s, Vertex<DecoratedElement<Character>> t) {

		Queue<Vertex<DecoratedElement<Character>>> q = new LinkedList();
		boolean noEnd = true;
		Vertex<DecoratedElement<Character>> u, v = null;
		Edge e;
		Iterator<Edge> it;
		s.getElement().setVisited(true);
		q.offer(s);

		while (!q.isEmpty() && noEnd) {
			u = q.poll();
			it = g.incidentEdges(u);
			while (it.hasNext() && noEnd) {
				e = it.next();
				v = g.opposite(u, e);
				if (!(v.getElement()).isVisited() && checktrust(g, v)) {
					(v.getElement()).setVisited(true);
					(v.getElement()).setParent(u.getElement());
					(v.getElement()).setDistance(((u.getElement()).getDistance()) + 1);
					q.offer(v);
					noEnd = !(v.getElement().equals(t.getElement()));
				} else {
					return null;
				}
			}
		}
		if (noEnd)
			v.getElement().setParent(null);
		return v.getElement();
	}

	//method to check if a character is a trusted person by reviewing the degree of that vertex
	public static boolean checktrust(Graph g, Vertex<DecoratedElement<Character>> v) {
		boolean checktrust;
		Iterator it = g.incidentEdges(v);
		int degree = 0;
		do {
			degree++;
		} while (it.hasNext());

		if (degree >= 8) {
			checktrust = true;
		} else {
			checktrust = false;
		}
		return checktrust;
	}
}