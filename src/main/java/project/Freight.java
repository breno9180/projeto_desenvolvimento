package project;

import java.util.List;

public class Freight {
	private String id;
	private double distanceKm;
    private double weight;
    private String typeVehicle;
    private double baseValue;
    private double rate;
    private double valueShipping;
    private double valueDelivery;
    private FreightStatus status;
    
    public Freight(String id,double distanceKm, double weight, String typeVehicle) {
        this.id = id;
    	this.distanceKm = distanceKm;
        this.weight = weight;
        this.typeVehicle = typeVehicle;
        this.baseValue = calculateBaseValue(weight, distanceKm, typeVehicle);
        this.rate = calculateRate();
        this.valueShipping = baseValue + rate;
        this.valueDelivery = valueShipping - rate;
        this.status = FreightStatus.ACEITO;
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
    
    public double getDistanceKm() {
    	return distanceKm;
    }
    
    public void setDistanceKm(double distanceKm) {
    	this.distanceKm = distanceKm;
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
    
    public FreightStatus getStatus() {
        return status;
    }
    
    public void setStatus(FreightStatus status) {
        this.status = status;
    }
    
	private double calculateBaseValue(double weight, double distanceKm, String typeVehicle) {
		double weightVehicle = getWeightByVehicleType(typeVehicle);
		return distanceKm * weightVehicle;
	}
	
	public double calculateRate() {
        if (distanceKm <= 100) {
            return valueShipping * 0.20;
        } else if (distanceKm <= 200) {
            return valueShipping * 0.15;
        } else if (distanceKm <= 500) {
            return valueShipping * 0.10;
        } else {
            return valueShipping * 0.075;
        }
    }
	
	private double getWeightByVehicleType(String typeVehicle) {
		switch(typeVehicle.toLowerCase()) {
		case "caminhonete":
			return 5.0;
		case "furg�o":
			return 4.0;
		case "caminh�o":
			return 10.0;
		default:
			throw new IllegalArgumentException("Invalid vehicle type!");
		}
	}
	
	private void updateValues() {
		this.baseValue = calculateBaseValue(weight, distanceKm, typeVehicle);
		this.rate = calculateRate();
		this.valueShipping = baseValue + rate;
		this.valueDelivery = valueShipping - rate;
	}
	
	public static Freight createShipping(List<Freight> freights, String id, double weight, double distance, String typeVehicle) {
		if (shippingExisting(freights, id)) {
			throw new IllegalArgumentException("Shipping already registered!");
		}
		validateShippingData(weight, distance, typeVehicle);
		
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
		freight.setDistanceKm(newDistance);
		freight.setTypeVehicles(newTypeVehicle);
		return freight;
	}
	
	public static Freight deleteShipping(List<Freight> freights, String id) {
		Freight freight = readShipping(freights, id);
		freights.remove(freight);
		return freight;
	}
	
	public void updateStatus(FreightStatus newStatus) {
        this.status = newStatus;
    }
	
	private static void validateShippingData(double weight, double distance, String typeVehicle) {
	    if (weight <= 0) {
	        throw new IllegalArgumentException("Weight must be a positive value.");
	    }
	    if (distance <= 0) {
	        throw new IllegalArgumentException("Distance must be a positive value.");
	    }
	    if (typeVehicle == null || typeVehicle.isEmpty()) {
	        throw new IllegalArgumentException("Vehicle type must be provided.");
	    }
	}
	
	private static boolean shippingExisting(List<Freight> freights, String id) {
        return freights.stream().anyMatch(freight -> freight.getId().equals(id));
    }
}    