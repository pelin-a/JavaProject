package methods;
import containers.Container;
public class BestShipping extends Calculations{
	
	
	private int bestNumSmallBoxes;
	private int bestNumBigBoxes;
	private double maxSmallWeight=500;
	private int smallCost=1000;
	private int bigCost=1800;
	private double totalCost;
	private Calculations calc;
	
	
	
	public double getTotalCost() {
		return totalCost;
	}



	public void setTotalCost(double totalCost) {
		this.totalCost = totalCost;
	}



	public int getBestNumSmallBoxes() {
		return bestNumSmallBoxes;
	}



	public void setBestNumSmallBoxes(int bestNumSmallBoxes) {
		this.bestNumSmallBoxes = bestNumSmallBoxes;
	}



	public int getBestNumBigBoxes() {
		return bestNumBigBoxes;
	}



	public void setBestNumBigBoxes(int bestNumBigBoxes) {
		this.bestNumBigBoxes = bestNumBigBoxes;
	}



	public double getMaxSmallWeight() {
		return maxSmallWeight;
	}



	public void setMaxSmallWeight(double maxSmallWeight) {
		this.maxSmallWeight = maxSmallWeight;
	}



	public int getSmallCost() {
		return smallCost;
	}



	public void setSmallCost(int smallCost) {
		this.smallCost = smallCost;
	}



	public int getBigCost() {
		return bigCost;
	}


	public void setBigCost(int bigCost) {
		this.bigCost=bigCost;
	}
	

	calc =new Calculations() {
		
		@Override
		public void bestShipping() {double totalVolume=totalVolume();
		double totalWeight=totalWeight();
		Container smallContainer= new Container(606,243,259,true); 
		Container bigContainer= new Container(1201,243,259,false);
		
		double smallVolume=smallContainer.getVolume();
		double bigVolume=bigContainer.getVolume();
		
		for(int smallContainers=0;smallContainers<=Math.ceil(totalVolume/smallVolume);smallContainers++){
			double volumeRemaining= totalVolume - (smallContainers*smallVolume); 
			double weightRemaining =totalWeight - (smallContainers * maxSmallWeight);
			
			int bigContainers = (int) Math.ceil(volumeRemaining / bigVolume);
			
			weightRemaining -= bigContainers * (bigVolume / smallVolume) * maxSmallWeight;
			
			if (volumeRemaining < 0 || weightRemaining < 0) {
                continue; // Skip invalid combinations
            }
			
			double cost = bigContainers * bigCost + smallContainers * smallCost;
			if (smallContainers > 0 && totalWeight - bigContainers * bigVolume / smallVolume * maxSmallWeight > smallContainers * maxSmallWeight) {
                cost += 200 * smallContainers;
            }
	
            
            setBestNumSmallBoxes(smallContainers);
            setBestNumBigBoxes(bigContainers);
            setTotalCost(cost);
    		
        	
		}
		
			// TODO Auto-generated method stub
			
		} }
	
	public void bestShipping() {
		double totalVolume=totalVolume();
		double totalWeight=totalWeight();
		Container smallContainer= new Container(606,243,259,true); 
		Container bigContainer= new Container(1201,243,259,false);
		
		double smallVolume=smallContainer.getVolume();
		double bigVolume=bigContainer.getVolume();
		
		for(int smallContainers=0;smallContainers<=Math.ceil(totalVolume/smallVolume);smallContainers++){
			double volumeRemaining= totalVolume - (smallContainers*smallVolume); 
			double weightRemaining =totalWeight - (smallContainers * maxSmallWeight);
			
			int bigContainers = (int) Math.ceil(volumeRemaining / bigVolume);
			
			weightRemaining -= bigContainers * (bigVolume / smallVolume) * maxSmallWeight;
			
			if (volumeRemaining < 0 || weightRemaining < 0) {
                continue; // Skip invalid combinations
            }
			
			double cost = bigContainers * bigCost + smallContainers * smallCost;
			if (smallContainers > 0 && totalWeight - bigContainers * bigVolume / smallVolume * maxSmallWeight > smallContainers * maxSmallWeight) {
                cost += 200 * smallContainers;
            }
	
            
            setBestNumSmallBoxes(smallContainers);
            setBestNumBigBoxes(bigContainers);
            setTotalCost(cost);
    		
        	
		}
		
		
	}
	
	public double shippingPrice() {
		return getTotalCost();
	}



}
