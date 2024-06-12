
//Pelinsu
package containers;

public class Container {
	//private attributes
	private double length;
	private double width;
	private double height;
	private boolean small;
	
	//constructor
	public Container(double length, double width, double height, boolean small) {
		this.length=length;
		this.width=width;
		this.height=height;
		this.small=small; //true if the container is small
			
	}
	//generated getters and setters

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

	public double getheight() {
		return height;
	}

	public void setheight(double height) {
		this.height = height;
	}
	
	public boolean isSmall() {
		return small;
	}

	public void setSmall(boolean small) {
		this.small = small;
	}

	//calculates container volume
	public double getVolume() {
		double volume;
		volume= this.length * this.width * this.height;
		return volume;
		
	}
	
	//prints container info
	public void printContainerInfo() {
		String str;
		str= "Container length: "+ this.length+"cm"+"\nWidth: "+ this.width+"cm" +"\nheight: "+ this.height+"cm" +
		"\nVolume: "+this.getVolume()+"cm3"; 
		System.out.println(str);
		
	}
		

}
