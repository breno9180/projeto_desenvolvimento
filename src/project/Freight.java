package project;

import java.util.List;

public class Freight {
	private String id;
	private double distance;
    private double weight;
    private String typeVehicle;
    private double baseValue;
    private double rate;
    private double valueShipping;
    private double valueDelivery;
    
    public Freight(String id,double distance, double weight, String typeVehicle) {
        this.id = id;
    	this.distance = distance;
        this.weight = weight;
        this.typeVehicle = typeVehicle;
        this.baseValue = calculateBaseValue(weight, distance, typeVehicle);
        this.rate = calculateRate(distance);
        this.valueShipping = baseValue + rate;
        this.valueDelivery = valueShipping - rate;
    }
    
    public String getId() {
    	return id;
    }
    
    public void setId(String id) {
    	this.id = id;
    }
    
    public double getWeight() {
    	return weight;
    }
    
    public void setWeight(double weight) {
    	this.weight = weight;
    	updateValues();
    }
    
    public double getDistance() {
    	return distance;
    }
    
    public void setDistance(double distance) {
    	this.distance = distance;
    	updateValues();
    }
    
    public String getTypeVehicle() {
    	return typeVehicle;
    }
	
    public void setTypeVehicles(String typeVehicle) {
    	this.typeVehicle = typeVehicle;
    	updateValues();
    }
    
    public double getRate() {
    	return rate;
    }
    
    public double getValueShipping() {
    	return valueShipping;
    }
    
    public double getValueDelivery() {
    	return valueDelivery;
    }
    
	private double calculateBaseValue(double weight, double distance, String typeVehicle) {
		double weightVehicle = getWeightByVehicleType(typeVehicle);
		return distance * weightVehicle;
	}
	
	private double calculateRate(double distance) {
    	if (distance <= 100) {
    			return baseValue * 0.20;
    		} else if(distance <= 200){
    			return baseValue * 0.15;
    		} else if(distance <= 500){
    			return baseValue * 0.10;
    		} else{
    			return baseValue * 0.075;
    		}
    }
	
	private void updateValues() {
		this.baseValue = calculateBaseValue(weight, distance, typeVehicle);
		this.rate = calculateRate(distance);
		this.valueShipping = baseValue + rate;
		this.valueShipping = valueShipping - rate;
	}
	
	private double getWeightByVehicleType(String typeVehicle) {
		switch(typeVehicle.toLowerCase()) {
		case "caminhonete":
			return 5.0;
		case "furgão":
			return 4.0;
		case "caminhão":
			return 10.0;
		default:
			throw new IllegalArgumentException("Invalid vehicle type!");
		}
	}
    
	public static Freight createShipping(List<Freight> freights, String id, double weight, double distance, String typeVehicle) {
		if (shippingExisting(freights, id)) {
			throw new IllegalArgumentException("Shipping already registered!");
		}
		Freight newFreight = new Freight(id, weight, distance, typeVehicle);
		freights.add(newFreight);
		return newFreight;
	}
	
	public static Freight readShipping(List<Freight> freights, String id) {
		return freights.stream()
		.filter(freight -> freight.getId().equals(id))
		.findFirst()
		.orElseThrow(() -> new IllegalArgumentException("Freight not found!"));
	}
	
	public static Freight updateShipping(List<Freight> freights, String id, double newWeight, double newDistance, String newTypeVehicle) {
		Freight freight = readShipping(freights, id);
		freight.setWeight(newWeight);
		freight.setDistance(newDistance);
		freight.setTypeVehicles(newTypeVehicle);
		return freight;
	}
	
	public static Freight deleteShipping(List<Freight> freights, String id) {
		Freight freight = readShipping(freights, id);
		freights.remove(freight);
		return freight;
	}
	
	private static boolean shippingExisting(List<Freight> freights, String id) {
        return freights.stream().anyMatch(freight -> freight.getId().equals(id));
    }
    
}    
