package graph;

import org.apache.poi.ss.formula.functions.T;

import graphsDSESIUCLM.*;
public class DecoratedElement<Character> implements Element{
	private String ID;
	private T name;
	private int value;
	private boolean visited;
	private DecoratedElement<Character> parent;
	
	public DecoratedElement(String iD, T name, int value) {
		ID = iD;
		this.name = name;
		this.value = value;
	}

	public DecoratedElement(String key, T name, int value, boolean visited, DecoratedElement<T> parent) {
		ID = key;
		this.name = name;
		this.value = value;
		this.visited = false;
		this.parent = null;
	}

	public void setID(String iD) {
		ID = iD;
	}
	public T getName() {
		return name;
	}
	public void setName(T name) {
		this.name = name;
	}
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
	public boolean isVisited() {
		return visited;
	}
	public void setVisited(boolean visited) {
		this.visited = visited;
	}
	public DecoratedElement<T> getParent() {
		return parent;
	}
	public void setParent(DecoratedElement<T> parent) {
		this.parent = parent;
	}

	@Override
	public String getID() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	

	
		
	
	

	
	
	
	
	
	
}
