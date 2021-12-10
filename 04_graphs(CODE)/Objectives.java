package graph;

import java.util.Iterator;
import java.util.Stack;

import graphsDSESIUCLM.Edge;
import graphsDSESIUCLM.Graph;

public class Objectives {

	// metodos aparatdo a

	// metodo dfs apartado b--> grafo conexo
	
	
	
	//queda el metodo DFS
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
	
	// metodo bfs aparatdo c
		// Debo comprobar que el nombre que entra en el metodo esta en el grafo y
		// pasarlo directamente como vertice, asi es más sencillo.
		public Stack<DecoratedElement<Character>> holo_message(Graph gr, Vertex<DecoratedEelement<Character>> origin,Vertex<DecoratedElement<Character>> destino,String chOrigin,String chTarget, incident){
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

	