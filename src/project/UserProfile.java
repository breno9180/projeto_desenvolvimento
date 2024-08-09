package project;

import java.util.ArrayList;
import java.util.List;

public class UserProfile {

	private String id;
    private String name;
    private List<String> permissions;
    
    public UserProfile(String id, String name) {
    	this.id = id;
    	this.name = name;
    	this.permissions = new ArrayList<>();
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
    
    public static UserProfile createProfile(List<UserProfile> profiles, String id, String name) {
    	if(profileExisting(profiles, name)) {
    		throw new IllegalArgumentException("Profile already registered with this name!");
    	}
    	UserProfile newProfile = new UserProfile(id, name);
    	profiles.add(newProfile);
    	return newProfile;
    }
    
    public static UserProfile readProfile(List<UserProfile> profiles, String id) {
    	return profiles.stream()
    			.filter(profile -> profile.getId().equals(id))
    			.findFirst()
    			.orElseThrow(()-> new IllegalArgumentException("Profile not found!"));
    }
    
    public static UserProfile updateProfile(List<UserProfile> profiles, String id,String newName) {
    	UserProfile profile = readProfile(profiles, id);
		if(!profile.getName().equals(newName) && profileExisting(profiles, newName)) {
    		throw new IllegalArgumentException("Another profile is already registered with this name!");
    	}
    	profile.setName(newName);
    	return profile;
    }
    
    public static void deleteProfile(List<UserProfile> profiles, String id) {
    	UserProfile profile = readProfile(profiles, id);
    	profiles.remove(profile);
    }
    
    private static boolean profileExisting(List<UserProfile> profiles, String name) {
    	return profiles.stream().anyMatch(profile -> profile.getName().equals(name));
    }

    
}
