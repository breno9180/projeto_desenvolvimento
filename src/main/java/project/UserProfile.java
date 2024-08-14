package project;

import java.util.ArrayList;
import java.util.List;

public class UserProfile {

	private int id;
    private String name;
    private String type;
    private List<String> permissions;
    
    public UserProfile(int id, String name, String type) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.permissions = new ArrayList<>();
    }
    
    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        throw new UnsupportedOperationException("ID cannot be changed.");
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
    
    // Removed setType as it's not appropriate to change the type after initialization
    
    public List<String> getPermissions() {
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
    
    public static UserProfile createProfile(List<UserProfile> profiles, int id, String name, String type) {
        if (profileExisting(profiles, name)) {
            throw new IllegalArgumentException("Profile already registered with this name!");
        }
        UserProfile newProfile = new UserProfile(id, name, type); // Alterado para UserProfileType
        profiles.add(newProfile);
        return newProfile;
    }
    
    public static UserProfile readProfile(List<UserProfile> profiles, int id) {
        return profiles.stream()
                .filter(profile -> profile.getId() == id)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Profile not found!"));
    }
    
    public static UserProfile updateProfile(List<UserProfile> profiles, int id, String newName) {
        UserProfile profile = readProfile(profiles, id);
        if (!profile.getName().equals(newName) && profileExisting(profiles, newName)) {
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
