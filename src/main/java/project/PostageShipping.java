package project;

import project.Freight;

public class PostageShipping {
	private Freight freight;
	private String id;
    private String description;
    private String typeVehicle;
    private double weightCalculation;
    private double valueFinalDelivery;
	

    public PostageShipping(String id, String description, String typeVehicle, double distanceKm, double weightCalculation) {
        this.id = id;
        this.description = description;
        this.typeVehicle = typeVehicle;
        this.weightCalculation = weightCalculation;
        this.freight = new Freight(typeVehicle,distanceKm, weightCalculation, description);
        this.valueFinalDelivery = calculateFinalValueDelivery();
    }
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTypeVehicle() {
        return typeVehicle;
    }

    public void setTypeVehicle(String typeVehicle) {
        this.typeVehicle = typeVehicle;
    }

    public double getWeightCalculation() {
        return weightCalculation;
    }

    public double getValueFinalDelivery() {
        return valueFinalDelivery;
    }
    
    public void setWeightCalculation(double weightCalculation) {
        this.weightCalculation = weightCalculation;
        this.freight.setWeight(weightCalculation);
        this.freight.setTypeVehicles(typeVehicle);
        this.valueFinalDelivery = calculateFinalValueDelivery();
    }
    
    public void setDistanceKm(double distanceKm) {
        this.freight.setDistanceKm(distanceKm);
        this.valueFinalDelivery = calculateFinalValueDelivery();
    }
    
    private double calculateFinalValueDelivery() {
        double rate = freight.calculateRate();
        return freight.getValueShipping() - rate;
    }
    
    public String toString() {
        return "PostageShipping{" +
                "id='" + id + '\'' +
                ", description='" + description + '\'' +
                ", typeVehicle='" + typeVehicle + '\'' +
                ", weightCalculation=" + weightCalculation +
                ", valueFinalDelivery=" + valueFinalDelivery +
                '}';
    }
}