package graph;

import graphsDSESIUCLM.*;
public  class DecoratedElementLinks<T>  implements Element {
	private String id;
	private int weight;
	private DecoratedElementLinks<T> parent;
	private T element;
	public DecoratedElementLinks(String key, int weight,  T element) {
		super();
		this.id = key;
		this.weight = weight;
		this.parent = null;
		this.element = element;
	}
	public T getElement() {
		return element;
	}
	public void setElement(T element) {
		this.element = element;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getWeight() {
		return weight;
	}
	public void setWeight(int weight) {
		this.weight = weight;
	}
	public DecoratedElementLinks<T> getParent() {
		return parent;
	}
	public void setParent(DecoratedElementLinks<T> parent) {
		this.parent = parent;
	}
	@Override
	public String getID() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
}