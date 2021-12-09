package graph;

public class Links {

	private String sourceID;
	private String targetID;
	private int weight;
	
	public Links(String sourceID, String targetID, int weight) {
		this.sourceID = sourceID;
		this.targetID = targetID;
		this.weight = weight;
	}
	public String getSourceID() {
		return sourceID;
	}
	public void setSourceID(String source) {
		this.sourceID = source;
	}
	public String getTargetID() {
		return targetID;
	}
	public void setTargetID(String target) {
		this.targetID = target;
	}
	public int getWeight() {
		return weight;
	}
	public void setWeight(int weight) {
		this.weight = weight;
	}
	
	
}
