package project;

import java.util.List;

public class User {
    private int id;
    private String email;
    private String passwordHash;
    private String name;
    private UserProfile profile;
    
    public User(int id, String email, String passwordHash, String name, UserProfile profile) {
    	this.id = id;
    	this.email = email;
    	this.passwordHash = passwordHash;
    	this.name = name;
    	this.profile = profile;
    }
    
    public int getId() {
    	return id;
    }
    
    public void setId(int id) {
    	this.id = id;
    }
    
    public String getName() {
    	return name;
    }
    
    public void setName(String name) {
    	this.name = name;
    }
    
    public String getEmail() {
    	return email;
    }
    
    public void setEmail(String email) {
    	this.email = email;
    }
    
    public String getPasswordHash() {
    	return passwordHash;
    }
    
    public void setPasswordHash(String passwordHash) {
    	this.passwordHash = passwordHash;
    }
    
    public UserProfile getProfile() {
    	return profile;
    }
    
    public void setProfile(UserProfile profile) {
    	this.profile = profile;
    }
    
    public static User createUser(List<User> users, int id, String name, String email, String passwordHash, UserProfile profile) {
    	if(existingUser(users, email)) {
    		throw new IllegalArgumentException("User already registered with this email!");
    	}
    	User newUser = new User(id, email, passwordHash, name, profile);
    	users.add(newUser);
    	return newUser;
    }
    
    public static User readUser(List<User> users, int id) {
        return users.stream()
                .filter(user -> user.getId() == id)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("User not found!"));
    }
    
    public static User updateUser(List<User> users, int id, String newName, String newEmail, String newPassword) {
    	User user = readUser(users, id);
    	if(!user.getEmail().equals(newEmail) && existingUser(users, newEmail)) {
    		throw new IllegalArgumentException("Another user is already registered with this email!");
    	}
    	user.setName(newName);
    	user.setEmail(newEmail);
    	user.setPasswordHash(newPassword);
    	return user;
    }
    
    public static void deleteUser(List<User> users, int id) {
    	User user = readUser(users, id);
    	users.remove(user);
    }
    
    private static boolean existingUser(List<User> users, String email) {
    	return users.stream().anyMatch(user -> user.getEmail().equals(email));
    }
}









