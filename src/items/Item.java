package items;

public class Item {
	
	//private item attributes
	private double length;
	private double width;
	private double depth;
	private double weight;
	
	//constructor
	public Item(double length, double width, double depth, double weight) {
		this.length = length;
		this.width= width;
		this.depth= depth;
		this.weight= weight;
	}
	// getters and setters
	public double getLength() {
		return length;
	}

	public void setLength(double length) {
		this.length = length;
	}

	public double getWidth() {
		return width;
	}

	public void setWidth(double width) {
		this.width = width;
	}

	public double getDepth() {
		return depth;
	}

	public void setDepth(double depth) {
		this.depth = depth;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}
	
	public double getItemVolume() {
		double volume;
		volume= this.length * this.weight * this.depth;
		return volume;
	}
	
	
	
	
	
	
}
