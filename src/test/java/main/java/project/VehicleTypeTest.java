package main.java.project;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import project.VehicleType;

public class VehicleTypeTest {

    @Test
    public void testCreateVehicle() {
        // Arrange
        List<VehicleType> vehicles = new ArrayList<>();
        VehicleType vehicle = VehicleType.createVehicle(vehicles, "1", "Modelo X", "ABC-1234", "Caminhonete");

        // Act
        String plate = vehicle.getPlate();
        String type = vehicle.getType();

        // Assert
        assertEquals("ABC-1234", plate);
        assertEquals("Caminhonete", type);
    }

    @Test
    public void testInvalidPlate() {
        // Arrange
        List<VehicleType> vehicles = new ArrayList<>();

        // Act & Assert
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> {
            VehicleType.createVehicle(vehicles, "1", "Modelo Y", "", "Furg�o");
        });
        assertEquals("Invalid Plate! Try again.", thrown.getMessage());
    }

    @Test
    public void testDuplicatePlate() {
        // Arrange
        List<VehicleType> vehicles = new ArrayList<>();
        VehicleType.createVehicle(vehicles, "1", "Modelo Z", "XYZ-5678", "Caminh�o");

        // Act & Assert
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> {
            VehicleType.createVehicle(vehicles, "2", "Modelo W", "XYZ-5678", "Furg�o");
        });
        assertEquals("Vehicle already registered!", thrown.getMessage());
    }
}
