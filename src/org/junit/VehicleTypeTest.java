package org.junit;

import org.junit.Test;

import project.VehicleType;

import static org.junit.Assert.*;

public class VehicleTypeTest {

    @Test
    public void testCreateVehicle() {
        // Arrange
        VehicleType vehicle = new VehicleType("1", "Modelo X", "ABC-1234", "Caminhonete");

        // Act
        String plate = vehicle.getPlate();
        String type = vehicle.getType();

        // Assert
        assertEquals("ABC-1234", plate);
        assertEquals("Caminhonete", type);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidPlate() {
        VehicleType.createVehicle(null, "2", "Modelo Y", "INVALID", "Furgão");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testDuplicatePlate() {
        List<VehicleType> vehicles = new ArrayList<>();
        VehicleType.createVehicle(vehicles, "1", "Modelo Z", "XYZ-5678", "Caminhão");
        VehicleType.createVehicle(vehicles, "2", "Modelo W", "XYZ-5678", "Furgão");
    }
}
