package project;

import java.util.List;

public class Authentication {

	public static User authenticate(List<User> users, String email, String password) {
		for (User user : users) {
			if(user.getEmail().equals(email) && user.getpassword().equals(password)) {
				return user;
			}
		}
		throw new IllegalArgumentException("Invalid email or password");
	}
	
	public static boolean checkPermission(User user, String permission){
		if(user.getProfile().getPermissions().contains(permission)) {
			return true;
		}
		return false;
	}
	
	public static void logout() {
		System.out.println("User logged out.");
	}

}
