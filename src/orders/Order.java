package orders;
import containers.Container;

public class Order extends Container {
	private double weight;// in kg
	private double cost;//in EUR
	// putting these values here instead of inside the code just in case they change by time
	private double maxWeight=500;
	private int smallCost1=1000;
	private int smallCost2=1200;
	private int bigCost=1800;
	//constructor
	public Order(double length, double width, double height, boolean small,double weight) {
		super(length,width,height,small);
		this.weight=weight;
		// determining the cost according to the attributes of the order
		if(!small) {
			this.cost=bigCost;
		}else {
			if(this.weight<=maxWeight) {
				this.cost=smallCost1;
			}else {
				this.cost=smallCost2;
			}
		}	
	}
	public double getWeight() {
		return weight;
	}
	public void setWeight(double weight) {
		this.weight = weight;
	}
	public double getCost() {
		return cost;
	}
	public void setCost(double cost) {
		this.cost = cost;
	}
	
	
	}
	
	


