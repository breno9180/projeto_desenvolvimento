package project;

import java.util.List;

public class User {
    private String id;
    private String email;
    private String password;
    private String name;
    
    public User(String id, String email, String password, String name) {
    	this.id = id;
    	this.email = email;
    	this.password = password;
    	this.name = name;
    }
    
    public String getId() {
    	return id;
    }
    
    public void setId(String id) {
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
    
    public String getpassword() {
    	return password;
    }
    
    public void setpassword(String password) {
    	this.password = password;
    }
    
    public static User createUser(List<User> users, String id, String name, String email, String password) {
    	if(existingUser(users, email)) {
    		throw new IllegalArgumentException("User already registered with this email!");
    	}
    	User newUser = new User(id, name, email, password);
    	users.add(newUser);
    	return newUser;
    }
    
    public static User readUser(List<User> users, String id) {
    	return users.stream()
    			.filter(user -> user.getId().equals(id))
    			.findFirst()
    			.orElseThrow(() -> new IllegalArgumentException("User not found!"));
    }
    
    public static User updateUser(List<User> users, String id, String newName, String newEmail, String newPassword) {
    	User user = readUser(users, id);
    	if(!user.getEmail().equals(newEmail) && existingUser(users, newEmail)) {
    		throw new IllegalArgumentException("Another user is already registered with this email!");
    	}
    	user.setName(newName);
    	user.setEmail(newEmail);
    	user.setpassword(newPassword);
    	return user;
    }
    
    public static void deleteUser(List<User> users, String id) {
    	User user = readUser(users, id);
    	users.remove(user);
    }
    
    private static boolean existingUser(List<User> users, String email) {
    	return users.stream().anyMatch(user -> user.getEmail().equals(email));
    }
}









