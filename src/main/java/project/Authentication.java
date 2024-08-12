package project;

import java.util.List;
import java.util.Optional;

public class Authentication {

    public static User authenticate(List<User> users, String email, String password) {
        // Validar entradas
        if (email == null || password == null) {
            throw new IllegalArgumentException("Email and password must not be null.");
        }

        // Procurar o usuário com o email fornecido
        Optional<User> userOptional = users.stream()
                .filter(user -> user.getEmail().equals(email))
                .findFirst();

        // Verificar se o usuário foi encontrado e se a senha está correta
        User user = userOptional.orElseThrow(() -> new IllegalArgumentException("Invalid email or password"));
        if (user.getPasswordHash().equals(hashPassword(password))) {
            return user;
        } else {
            throw new IllegalArgumentException("Invalid email or password");
        }
    }

    public static boolean checkPermission(User user, String permission) {
        if (user == null || permission == null) {
            throw new IllegalArgumentException("User and permission must not be null.");
        }
        return user.getProfile().getPermissions().contains(permission);
    }

    public static void logout(User user) {
        if (user == null) {
            throw new IllegalArgumentException("User must not be null.");
        }
        // Adicionar lógica para encerrar a sessão, se necessário
        System.out.println("User " + user.getEmail() + " logged out.");
    }

    // Método para simular o hash da senha (substitua com um método real de hash)
    private static String hashPassword(String password) {
        // Substitua com a implementação real de hashing, por exemplo, BCrypt
        return password; // Isso é apenas um placeholder
    }
}
