
//Pelinsu
package methods;

import containers.Container;

public class BestShipment extends Calculations{

	
	@Override
	public void bestShipping() {
		double totalVolume = totalVolume(); // inherited from superclass Calculations
	    double totalWeight = totalWeight(); // inherited from superclass Calculations

	    Container smallContainer = new Container(6.06, 2.43, 2.59, true); 
	    Container bigContainer = new Container(12.01, 2.43, 2.59, false);
	    
	    double smallVolume = smallContainer.getVolume();
	    double bigVolume = bigContainer.getVolume();

	    // Constants for the container costs and maximum weights
	    double maxSmallWeight = 500; // Max weight for small container in kg
	    double bigCost = 1800; // Cost for big container
	    double smallCostUnder500 = 1000; // Cost for small container if weight <= 500kg
	    double smallCostOver500 = 1200; // Cost for small container if weight > 500kg

	    double minCost = Double.MAX_VALUE; // this is the maximum double value in java, used when calculating minimums to make comparisons.(but program works the same without it)
	    int bestSmallContainers = 0;
	    int bestBigContainers = 0;

	    // Try only small containers
	    int smallContainersNeeded = (int) Math.ceil(totalVolume / smallVolume);
	    double smallContainersCost = smallContainersNeeded * (totalWeight <= maxSmallWeight ? smallCostUnder500 : smallCostOver500);
	    minCost = smallContainersCost;
	    bestSmallContainers = smallContainersNeeded;

	    // Try only big containers
	    int bigContainersNeeded = (int) Math.ceil(totalVolume / bigVolume);
	    double bigContainersCost = bigContainersNeeded * bigCost;
	    if (bigContainersCost < minCost) {
	        minCost = bigContainersCost;
	        bestBigContainers = bigContainersNeeded;
	        bestSmallContainers = 0;
	    }

	    // Try a combination of big and small containers
	    for (int bigContainers = 0; bigContainers <= Math.ceil(totalVolume / bigVolume); bigContainers++) {
	        double remainingVolume = totalVolume - bigContainers * bigVolume;
	        int smallContainers = Math.max(0, (int) Math.ceil(remainingVolume / smallVolume));

	        double totalCost = bigContainers * bigCost + smallContainers * (totalWeight <= maxSmallWeight ? smallCostUnder500 : smallCostOver500);

	        if (totalCost < minCost) {
	            minCost = totalCost;
	            bestSmallContainers = smallContainers;
	            bestBigContainers = bigContainers;
	        }
	    }

	    // Set the best configuration and print the results
	    setBestNumSmallBoxes(bestSmallContainers);
	    setBestNumBigBoxes(bestBigContainers);
	    setTotalCost(minCost);
	    
	   
	}
	
}