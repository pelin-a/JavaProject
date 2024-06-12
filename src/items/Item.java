
//Pelinsu
package items;

public class Item {
	
	//private item attributes
	private double length; //in m
	private double width; //in m
	private double height; //in m
	private double weight;// in kg
	private String name;
	
	//constructor
	public Item(String name,double length, double width, double height, double weight) {
		this.name= name;
		this.length = length;
		this.width= width;
		this.height= height;
		this.weight= weight;
	}
	// getters and setters
	
	public double getLength() {
		return length;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}
	
	// calculates the volume of item's package
	public double getItemVolume() {
		double volume = this.getLength()*this.getWidth()* this.getHeight();
		return volume;
		
	}
	// prints specific item's information
	public void printItemInfo() {
		String str;
		str= "Item name: "+ this.name+"/nItem length: "+ this.length+"cm"+"\nItem width: "+ this.width+"cm" +"\nItem height: "+ this.height+"cm" +
		"\nItem weight: "+this.weight+"kg"; 
		System.out.println(str);
		
	}
	
	
}


	
	
	

