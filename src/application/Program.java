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
        Freight frete2 = Freight.createShipping(Freights, "2", 20, 150, "Furg�o");

        // Ler Frete
        Freight found = Freight.readShipping(Freights, "1");
        System.out.println("Frete encontrado: " + found.getValueShipping());

        // Atualizar Frete
        Freight updated = Freight.updateShipping(Freights, "2", 25, 180, "Caminh�o");
        System.out.println("Frete atualizado: " + updated.getValueShipping() + ", Valor Entregador: " + updated.getValueDelivery());

        // Deletar Frete
        Freight.deleteShipping(Freights, "1");
        System.out.println("Frete com id '1' deletado.");

        // Tentativa de leitura de frete deletado
        try {
        	Freight.readShipping(Freights, "1");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());  // Frete n�o encontrado!
        }
        
        List<VehicleType> vehicles = new ArrayList<>();
        
        VehicleType vehicle = VehicleType.createVehicle(vehicles, "1", "Caminhonete", "ABC-1234", "Caminhonete");
        VehicleType vehicle1 = VehicleType.createVehicle(vehicles, "2", "Furg�o", "XYZ-5678", "Furg�o");
        
        VehicleType encontrado = VehicleType.readVehicle(vehicles, "1");
        System.out.println("Ve�culo encontrado: " + encontrado.getModel());
        
        VehicleType atualizado = VehicleType.updateVehicle(vehicles, "2", "Furg�o Atualizado", "XYZ-5679", "Furg�o");
        System.out.println("Ve�culo atualizado: " + atualizado.getModel() + ", Nova Placa: " + atualizado.getPlate());
        
        VehicleType.deleteVehicle(vehicles, "1");
        System.out.println("Ve�culo com id '1' deletado.");
        
        try {
        	VehicleType.readVehicle(vehicles, "1");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());  // Ve�culo n�o encontrado!
        }
        
    }
}
