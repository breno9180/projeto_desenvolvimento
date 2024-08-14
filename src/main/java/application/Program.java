package application;

import project.User;
import project.UserProfile;
import project.UserProfileType;
import repository.UserRepository;


public class Program {
    public static void main(String[] args) {
        UserRepository userRepository = new UserRepository();

        // Obtenha o perfil de usuário existente com o ID definido (por exemplo, 3 para Cliente)
        UserProfile profile = userRepository.getUserProfile(3); // Usando o ID de Cliente

        // Crie um novo usuário com o perfil existente
        User newUser = new User(3, "cliente@example.com", "cliente_password_hash", "João Cliente", profile);

        // Adicione o usuário ao repositório
        userRepository.createUser(newUser);
    }
}
