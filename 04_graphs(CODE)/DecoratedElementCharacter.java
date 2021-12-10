package graph;

import graphsDSESIUCLM.*;

public class DecoratedElementCharacter<Character> implements Element{
	private String ID;
	private Character element;
	private boolean visited;
	private DecoratedElementCharacter<Character> parent;
	private int distance;
	
	public DecoratedElementCharacter(String key, Character element) {
		this.element = element;
		ID = key;
		visited = false;
		parent = null;
		distance = 0;
	}
	public void setID(String iD) {
		ID = iD;
	}
	@Override
	public String getID() {
		return null;
	}
	public Character getElement() {
		return element;
	}
	public void setElement(Character element) {
		this.element = element;
	}
	public boolean isVisited() {
		return visited;
	}
	public void setVisited(boolean visited) {
		this.visited = visited;
	}
	public DecoratedElementCharacter<Character> getParent() {
		return parent;
	}
	public void setParent(DecoratedElementCharacter<Character> parent) {
		this.parent = parent;
	}
	public int getDistance() {
		return distance;
	}
	public void setDistance(int distance) {
		this.distance = distance;
	}
}