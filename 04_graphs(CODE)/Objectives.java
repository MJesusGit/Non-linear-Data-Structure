package graph;

import java.util.Iterator;
import java.util.Stack;

import graphsDSESIUCLM.Edge;
import graphsDSESIUCLM.Graph;

public class Objectives {

	// metodos aparatdo a

	// metodo dfs apartado b

	// metodo bfs aparatdo c
	// Debo comprobar que el nombre que entra en el metodo esta en el grafo y
	// pasarlo directamente como vertice, asi es más sencillo.
	public Stack<DecoratedElement<Character>> holo_message(Graph<V, E> g, Vertex<DecoratedEelement<Character>> origin,Vertex<DecoratedElement<Character>> destino,String chOrigin,String chTarget){
		boolean find=false;
		Queue<Vertex<DecoratedElement<Character>>> q = new LinkedBlockingQueue();
		Vertex<DecoratedElement<Character>> u,v=null;
		DecoratedElement<Character> z;
		Edge e;
		Iterator <Edge> it= null;
			while(!q.isEmpty() && !find) {
				u=q.remove();
				it=g.incidentEdges(u);
				while(it.hasNext()&& !find) {
					e=it.next();
					v=g.opposite(u, e);
					if(!(v.getElement().getVisited())&& (condiciondel ejer)) {
						v.getElement().setVisited(true);
						v.getElement().setAntecessor(u.getElement());
						q.offer(v);
						if(v.getElement().equals(chtatger)) {
							find=true;
						}
					}
					
				}
				
			}
			if(find) {
				z=v.getElement().getAntecesor();
				while(z!=null) {
					if(z.element().getName==chorigin && !z.equals(origin.getElement())) {
						//añado el vertice a la pila que quiero devolver, voy a atner que darle la vuelta para que salga en el orden
					}
				}
			}
			
			return path;		
	}

}
