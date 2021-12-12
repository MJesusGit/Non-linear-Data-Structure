package graph;

import java.util.*;
import graphsDSESIUCLM.*;

public class ShortestPath {

	public static DecoratedElement findshortestconection(Graph g, Vertex<DecoratedElement> s, Vertex<DecoratedElement> t) {
		Queue<Vertex<DecoratedElement>> q = new LinkedList();
		boolean noEnd = true;
		Vertex<DecoratedElement> u, v = null;
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
				if (!(v.getElement()).isVisited()) {
					(v.getElement()).setVisited(true);
					(v.getElement()).setParent(u.getElement());
					(v.getElement()).setDistance(((u.getElement()).getDistance()) + 1);
					q.offer(v);
					noEnd = !(v.getElement().equals(t.getElement()));
				}
			}
		}
		if (noEnd)
			v.getElement().setParent(null);
		return v.getElement();
	}
}