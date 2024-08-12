package project;

import java.util.ArrayList;
import java.util.List;

public class UserProfile {

	private int id;
    private String name;
    private String type;
    private List<String> permissions;
    
    public UserProfile(int string, String name, String type) {
    	this.id = string;
    	this.name = name;
    	this.type = type;
    	this.permissions = new ArrayList<>();
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
    
    public String getType() {
        return type;
    }
    
    public void setType(String type) {
        this.type = type;
    }
    
    public List<String> getPermissions(){
    	return permissions;
    }
    
    public void setPermissions(List<String> permissions) {
    	this.permissions = permissions;
    }
    
    public void addPermission(String permission) {
    	if (!permissions.contains(permission)) {
    		permissions.add(permission);
    	}
    }
    
    public void removePermission(String permission) {
    	permissions.remove(permission);
    }
    
    public static UserProfile createProfile(List<UserProfile> profiles, int id, String name, String role) {
    	if(profileExisting(profiles, name)) {
    		throw new IllegalArgumentException("Profile already registered with this name!");
    	}
    	UserProfile newProfile = new UserProfile(id, name, role);
    	profiles.add(newProfile);
    	return newProfile;
    }
    
    public static UserProfile readProfile(List<UserProfile> profiles, int id) {
    	return profiles.stream()
    			.filter(profile -> profile.getId() == id)
    			.findFirst()
    			.orElseThrow(()-> new IllegalArgumentException("Profile not found!"));
    }
    
    public static UserProfile updateProfile(List<UserProfile> profiles, int id,String newName) {
    	UserProfile profile = readProfile(profiles, id);
		if(!profile.getName().equals(newName) && profileExisting(profiles, newName)) {
    		throw new IllegalArgumentException("Another profile is already registered with this name!");
    	}
    	profile.setName(newName);
    	return profile;
    }
    
    public static void deleteProfile(List<UserProfile> profiles, int id) {
    	UserProfile profile = readProfile(profiles, id);
    	profiles.remove(profile);
    }
    
    private static boolean profileExisting(List<UserProfile> profiles, String name) {
    	return profiles.stream().anyMatch(profile -> profile.getName().equals(name));
    }

    
}
