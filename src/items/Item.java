package items;

public class Item {
	
	//private item attributes
	private double length; //in cm
	private double width; //in cm
	private double height; //in cm
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

	public double getheight() {
		return height;
	}

	public void setheight(double height) {
		this.height = height;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}
	
	public double getArea() {
		double surArea; // the surface of the bottom of the box
		surArea= this.length * this.width;
		return surArea;
	}
	
	public double getItemVolume() {
		double area = this.getArea();
		double volume = area* this.height;
		return volume;
		
	}	
	public void printItemInfo() {
		String str;
		str= "Item name: "+ this.name+"/nItem length: "+ this.length+"cm"+"\nItem width: "+ this.width+"cm" +"\nItem height: "+ this.height+"cm" +
		"\nItem weight: "+this.weight+"kg"; 
		System.out.println(str);
		
	}
	public static void main(String[] args) {
        // Create an object of MyClass and test its methods
        Item obj = new Item(4,5.6,6.7,4.8);
        
        obj.printItemInfo();
        
        
        // Call methods, set properties, etc.
    }
	
	
	
	
	
	
	
	
}


	
	
	

