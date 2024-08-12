package application;

import java.util.List;

import project.Freight;
import project.FreightStatus;
import project.User;
import project.UserProfile;
import project.UserProfileType;

public class Program {
	
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		
		repository.UserRepository userRepository = new repository.UserRepository();
		
		// Crie um perfil de usu�rio, se necess�rio
        UserProfile profile = new UserProfile("1", "AdminProfile", "AdminRole");
		
        // Crie um novo usu�rio com perfil
        User newUser = new User("1", "admin", "admin_password_hash", "ADMIN", UserProfileType.ADMIN);
//		
        // Adicione o usu�rio ao reposit�rio
        userRepository.createUser(newUser);
//		
//        // Recupere e exiba todos os usu�rios
//        List<User> users = userRepository.getAllUsers();
//        users.forEach(user -> System.out.println(user.getName()));
        
//        Freight freight = Freight.createShipping(freights, "FRETE1", 10.0, 150.0, "caminhonete");
//
//        // Atualizar o status do frete
//        freight.updateStatus(FreightStatus.ROTA_DE_ENTREGA);
//
//        // Verificar o status atual
//        System.out.println("Status do frete: " + freight.getStatus());
		
//        List<Freight> Freights = new ArrayList<>();
//
//        // Criar Frete
//        @SuppressWarnings("unused")
//		Freight frete1 = Freight.createShipping(Freights, "1", 10, 50, "Caminhonete");
//        Freight frete2 = Freight.createShipping(Freights, "2", 20, 150, "Furg�o");
//
//        // Ler Frete
//        Freight foundFreight = Freight.readShipping(Freights, "1");
//        System.out.println("Frete encontrado: " + foundFreight.getValueShipping());
//
//        // Atualizar Frete
//        Freight updatedFreight = Freight.updateShipping(Freights, "2", 25, 180, "Caminh�o");
//        System.out.println("Frete atualizado: " + updatedFreight.getValueShipping() + ", Valor Entregador: " + updatedFreight.getValueDelivery());
//
//        // Deletar Frete
//        Freight.deleteShipping(Freights, "1");
//        System.out.println("Frete com id '1' deletado.");
//
//        // Tentativa de leitura de frete deletado
//        try {
//        	Freight.readShipping(Freights, "1");
//        } catch (IllegalArgumentException e) {
//            System.out.println(e.getMessage());  // Frete n�o encontrado!
//        }
//        
//        List<VehicleType> vehicles = new ArrayList<>();
//        
//        VehicleType vehicle = VehicleType.createVehicle(vehicles, "1", "Caminhonete", "ABC-1234", "Caminhonete");
//        VehicleType vehicle1 = VehicleType.createVehicle(vehicles, "2", "Furg�o", "XYZ-5678", "Furg�o");
//        
//        VehicleType encontrado = VehicleType.readVehicle(vehicles, "1");
//        System.out.println("Ve�culo encontrado: " + encontrado.getModel());
//        
//        VehicleType atualizado = VehicleType.updateVehicle(vehicles, "2", "Furg�o Atualizado", "XYZ-5679", "Furg�o");
//        System.out.println("Ve�culo atualizado: " + atualizado.getModel() + ", Nova Placa: " + atualizado.getPlate());
//        
//        VehicleType.deleteVehicle(vehicles, "1");
//        System.out.println("Ve�culo com id '1' deletado.");
//        
//        try {
//        	VehicleType.readVehicle(vehicles, "1");
//        } catch (IllegalArgumentException e) {
//            System.out.println(e.getMessage());  // Ve�culo n�o encontrado!
//        }
//        
//        List<User> users = new ArrayList<>();
//
//        // Criar um novo usu�rio
//        User usuario1 = User.createUser(users, "1", "Jo�o", "joao@example.com", "senha123");
//
//        // Ler um usu�rio
//        User foundUser = User.readUser(users, "1");
//        System.out.println("Usu�rio encontrado: " + foundUser.getName());
//
//        // Atualizar um usu�rio
//        User updatedUser = User.updateUser(users, "1", "Jo�o da Silva", "joao.silva@example.com", "novaSenha123");
//        System.out.println("Usu�rio atualizado: " + updatedUser.getName());
//
//        // Deletar um usu�rio
//        User.deleteUser(users, "1");
//        System.out.println("Usu�rio com id '1' deletado.");
//        
//        
//        PostageShipping frete3 = new PostageShipping("1", "Entrega de m�veis", "Caminhonete", 150, 5);
//
//        // Exibe os detalhes do frete
//        System.out.println(frete3.toString());
//
//        // Alterando a dist�ncia e recalculando os valores
//        frete3.setDistanceKm(300);
//        System.out.println("Ap�s mudan�a de dist�ncia:");
//        System.out.println(frete3.toString());
    }
}
