package graph;

public class Character {
	private String ID;
	private String name;
	private int value;

	public Character(String iD, String name, int value) {
		ID = iD;
		this.name = name;
		this.value = value;
	}

	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return "Character [ID=" + ID + ", name=" + name + ", value=" + value + "]";
	}

}