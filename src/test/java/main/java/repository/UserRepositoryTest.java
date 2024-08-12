//package main.java.repository;
//
//import static org.junit.Assert.assertEquals;
//import static org.junit.Assert.assertNotNull;
//import static org.junit.Assert.assertNull;
//
//import java.util.List;
//
//import org.junit.Before;
//
//import project.User;
//import project.UserProfileType;
//import repository.UserRepository;
//
//public class UserRepositoryTest {
//
//    private UserRepository userRepository;
//
//    @Before
//    public void setUp() {
//        userRepository = new UserRepository();
//    }
//
//    @org.junit.Test
//    public void testCreateAndReadUser() {
//        User user = new User("1", "admin", "admin_password_hash", "ADMIN", UserProfileType.ADMIN);
//        userRepository.createUser(user);
//        User retrievedUser = userRepository.readUser("1");
//        assertNotNull(retrievedUser);
//        assertEquals("admin", retrievedUser.getName());
//        assertEquals(UserProfileType.ADMIN, retrievedUser.getProfile());
//    }
//
//    @org.junit.Test
//    public void testUpdateUser() {
//        User user = new User("1", "admin", "admin_password_hash", "ADMIN", UserProfileType.ADMIN);
//        userRepository.createUser(user);
//        user.setName("admin_updated");
//        userRepository.updateUser(user);
//        User updatedUser = userRepository.readUser("1");
//        assertNotNull(updatedUser);
//        assertEquals("admin_updated", updatedUser.getName());
//    }
//
//    @org.junit.Test
//    public void testDeleteUser() {
//        User user = new User("1", "admin", "admin_password_hash", "ADMIN", UserProfileType.ADMIN);
//        userRepository.createUser(user);
//        userRepository.deleteUser("1");
//        User deletedUser = userRepository.readUser("1");
//        assertNull(deletedUser);
//    }
//
//    @org.junit.Test
//    public void testGetAllUsers() {
//        User user1 = new User("1", "admin1", "admin1_password_hash", "ADMIN1", UserProfileType.ADMIN);
//        User user2 = new User("2", "admin2", "admin2_password_hash", "ADMIN2", UserProfileType.ADMIN);
//        userRepository.createUser(user1);
//        userRepository.createUser(user2);
//        List<User> users = userRepository.getAllUsers();
//        assertEquals(2, users.size());
//    }
//}
