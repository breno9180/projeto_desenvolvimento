package repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import project.User;
import project.UserProfile;
import project.UserProfileType;

public class UserRepository {
    // M�todo para obter uma conex�o com o banco de dados
    private Connection getConnection() throws SQLException {
        final String URL = "jdbc:postgresql://glumly-glowing-mink.data-1.use1.tembo.io:5432/postgres";
        final String USER = "postgres";
        final String PASSWORD = "BeYeRfCora1tuQLQ";
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    // M�todo para criar um novo usu�rio
    public void createUser(User user) {
        String sql = "INSERT INTO users (id, email, password_hash, profile_type_id, name) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, user.getId());
            pstmt.setString(2, user.getEmail());
            pstmt.setString(3, user.getPasswordHash());
            pstmt.setInt(4, user.getProfile().getId()); // Usa profile_type_id
            pstmt.setString(5, user.getName());
            pstmt.executeUpdate();
            System.out.println("Usuário criado com sucesso!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public User readUser(String id) {
        String sql = "SELECT * FROM users WHERE id = ?";

        try (Connection conn = getConnection(); 
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, Integer.parseInt(id));
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                int profileTypeId = rs.getInt("profile_type_id");
                UserProfile profile = getUserProfile(profileTypeId); // Obtendo perfil do banco de dados

                return new User(
                    rs.getInt("id"),
                    rs.getString("email"),
                    rs.getString("password_hash"),
                    rs.getString("name"),
                    profile
                );
            } else {
                throw new IllegalArgumentException("User not found.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    // M�todo para atualizar um usu�rio
    public void updateUser(User user) {
        String sql = "UPDATE users SET email = ?, password_hash = ?, name = ?, profile_type_id = ? WHERE id = ?";

        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, user.getEmail());
            pstmt.setString(2, user.getPasswordHash());
            pstmt.setString(3, user.getName());
            pstmt.setInt(4, user.getProfile().getId()); // Usa profile_type_id
            pstmt.setInt(5, user.getId());

            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // M�todo para deletar um usu�rio
    public void deleteUser(int id) {
        String sql = "DELETE FROM users WHERE id = ?";
        
        try (Connection conn = getConnection(); 
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id); // Ajuste para o tipo de ID
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public UserProfile getUserProfile(int profileTypeId) {
        String sql = "SELECT * FROM user_profiles WHERE id = ?";
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, profileTypeId);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                String name = rs.getString("name");
                String type = rs.getString("type");
                UserProfile userProfile = new UserProfile(profileTypeId, name, type);
                return userProfile;
            } else {
                throw new IllegalArgumentException("Perfil não encontrado!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
    
    private User getUserById(int id) {
        String sql = "SELECT * FROM users WHERE id = ?";
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                return new User(
                    rs.getInt("id"),
                    rs.getString("email"),
                    rs.getString("password_hash"),
                    rs.getString("name"),
                    getUserProfile(rs.getInt("profile_type_id")) // Obtendo perfil do banco de dados
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    private List<String> loadPermissions(int profileId) {
        String sql = "SELECT permission FROM user_profile_permissions WHERE profile_id = ?";
        List<String> permissions = new ArrayList<>();

        try (Connection conn = getConnection(); 
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, profileId);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                permissions.add(rs.getString("permission"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return permissions;
    }

    // M�todo para listar todos os usu�rios
    public List<User> getAllUsers() {
        List<User> users = new ArrayList<>();
        String sql = "SELECT * FROM users";

        try (Connection conn = getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                int id = rs.getInt("id");
                String email = rs.getString("email");
                String passwordHash = rs.getString("password_hash");
                String name = rs.getString("name");
                int profileTypeId = rs.getInt("profile_type_id"); // Obtendo o ID do tipo de perfil

                // Recuperar o perfil do usuário usando o ID do tipo de perfil
                UserProfile profile = getUserProfile(profileTypeId);

                // Criar o objeto User e adicioná-lo à lista
                User user = new User(id, email, passwordHash, name, profile);
                users.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }
}
