package application;

import java.util.ArrayList;
import java.util.List;

import project.Freight;
import project.PostageShipping;
import project.User;
import project.VehicleType;

public class Program {
	
	@SuppressWarnings("unused")
	public static void main(String[] args) {
        List<Freight> Freights = new ArrayList<>();

        // Criar Frete
        @SuppressWarnings("unused")
		Freight frete1 = Freight.createShipping(Freights, "1", 10, 50, "Caminhonete");
        Freight frete2 = Freight.createShipping(Freights, "2", 20, 150, "Furg�o");

        // Ler Frete
        Freight foundFreight = Freight.readShipping(Freights, "1");
        System.out.println("Frete encontrado: " + foundFreight.getValueShipping());

        // Atualizar Frete
        Freight updatedFreight = Freight.updateShipping(Freights, "2", 25, 180, "Caminh�o");
        System.out.println("Frete atualizado: " + updatedFreight.getValueShipping() + ", Valor Entregador: " + updatedFreight.getValueDelivery());

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
        
        List<User> users = new ArrayList<>();

        // Criar um novo usu�rio
        User usuario1 = User.createUser(users, "1", "Jo�o", "joao@example.com", "senha123");

        // Ler um usu�rio
        User foundUser = User.readUser(users, "1");
        System.out.println("Usu�rio encontrado: " + foundUser.getName());

        // Atualizar um usu�rio
        User updatedUser = User.updateUser(users, "1", "Jo�o da Silva", "joao.silva@example.com", "novaSenha123");
        System.out.println("Usu�rio atualizado: " + updatedUser.getName());

        // Deletar um usu�rio
        User.deleteUser(users, "1");
        System.out.println("Usu�rio com id '1' deletado.");
        
        
        PostageShipping frete3 = new PostageShipping("1", "Entrega de m�veis", "Caminhonete", 150, 5);

        // Exibe os detalhes do frete
        System.out.println(frete3.toString());

        // Alterando a dist�ncia e recalculando os valores
        frete3.setDistanceKm(300);
        System.out.println("Ap�s mudan�a de dist�ncia:");
        System.out.println(frete3.toString());
    }
}
