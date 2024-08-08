package project;

import java.util.List;

public class VehicleType {
	private String id;
    private String model;
    private String plate;
    private String type;
    
    public VehicleType(String id, String model, String plate, String type) {
        this.id = id;
        this.model = model;
        this.plate = plate;
        this.type = type;
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String modelo) {
        this.model = modelo;
    }

    public String getPlate() {
        return plate;
    }

    public void setPlate(String placa) {
        this.plate = placa;
    }

    public String getType() {
        return type;
    }

    public void setType(String tipo) {
        this.type = tipo;
    }
    
    private static boolean validatePlate(String plate) {
    	return plate != null && plate.matches("[A-Z]{3}-[0-9]{4}");
    }
    
    private static boolean validateExistingVehicle(List<VehicleType> vehicles, String plate) {
    	return vehicles.stream().anyMatch(VehicleType -> VehicleType.getPlate().equals(plate));
    }
    
    public static VehicleType createVehicle(List<VehicleType> vehicles, String id, String model, String plate, String type) {
    	if (!validatePlate(plate)) {
    		throw new IllegalArgumentException("Invalid Plate! Try again.");
    	}
    	if (validateExistingVehicle(vehicles, plate)) {
    		throw new IllegalArgumentException("Vehicle already registered!");
    	}
    	
    	VehicleType newVehicle = new VehicleType(id, model, plate, type);
    	vehicles.add(newVehicle);
    	return newVehicle;
    }
    
    public static VehicleType readVehicle(List<VehicleType> vehicles, String id) {
    	return vehicles.stream()
    			.filter(vehicle -> vehicle.getId().equals(id))
    			.findFirst()
    			.orElseThrow(() -> new IllegalArgumentException("Vehicle not found!"));
    }
    
    public static VehicleType updateVehicle(List<VehicleType> vehicles, String id, String newModel, String newPlate, String newType) {
    	VehicleType vehicle = readVehicle(vehicles, id);
    	
    
    	if (!vehicle.getPlate().equals(newPlate) && validateExistingVehicle(vehicles, newPlate)) {
    		throw new IllegalArgumentException("There is already a vehicle with this plate!");
    	}
    
    	if (!validatePlate(newPlate)) {
    		throw new IllegalArgumentException("Invalid plate!");
    	}
    
    	vehicle.setModel(newModel);
    	vehicle.setPlate(newPlate);
    	vehicle.setType(newType);
    	return vehicle;
	}
    
    public static VehicleType deleteVehicle(List<VehicleType> vehicles, String id) {
		VehicleType vehicle = readVehicle(vehicles, id);
    	vehicles.remove(vehicle);
		return vehicle;
    }   
}









