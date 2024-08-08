package application;

import java.util.ArrayList;
import java.util.List;

import project.Freight;
import project.VehicleType;

public class Program {
	
	public static void main(String[] args) {
        List<Freight> Freights = new ArrayList<>();

        // Criar Frete
        Freight frete1 = Freight.createShipping(Freights, "1", 10, 50, "Caminhonete");
        Freight frete2 = Freight.createShipping(Freights, "2", 20, 150, "Furgão");

        // Ler Frete
        Freight found = Freight.readShipping(Freights, "1");
        System.out.println("Frete encontrado: " + found.getValueShipping());

        // Atualizar Frete
        Freight updated = Freight.updateShipping(Freights, "2", 25, 180, "Caminhão");
        System.out.println("Frete atualizado: " + updated.getValueShipping() + ", Valor Entregador: " + updated.getValueDelivery());

        // Deletar Frete
        Freight.deleteShipping(Freights, "1");
        System.out.println("Frete com id '1' deletado.");

        // Tentativa de leitura de frete deletado
        try {
        	Freight.readShipping(Freights, "1");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());  // Frete não encontrado!
        }
        
        List<VehicleType> vehicles = new ArrayList<>();
        
        VehicleType vehicle = VehicleType.createVehicle(vehicles, "1", "Caminhonete", "ABC-1234", "Caminhonete");
        VehicleType vehicle1 = VehicleType.createVehicle(vehicles, "2", "Furgão", "XYZ-5678", "Furgão");
        
        VehicleType encontrado = VehicleType.readVehicle(vehicles, "1");
        System.out.println("Veículo encontrado: " + encontrado.getModel());
        
        VehicleType atualizado = VehicleType.updateVehicle(vehicles, "2", "Furgão Atualizado", "XYZ-5679", "Furgão");
        System.out.println("Veículo atualizado: " + atualizado.getModel() + ", Nova Placa: " + atualizado.getPlate());
        
        VehicleType.deleteVehicle(vehicles, "1");
        System.out.println("Veículo com id '1' deletado.");
        
        try {
        	VehicleType.readVehicle(vehicles, "1");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());  // Veículo não encontrado!
        }
        
    }
}
