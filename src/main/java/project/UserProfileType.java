package project;

import java.util.Set;

public enum UserProfileType {
	 ADMIN(Set.of("READ", "WRITE", "DELETE")),
	    ENTREGADOR(Set.of("READ"));

	    private final Set<String> permissions;

	    UserProfileType(Set<String> permissions) {
	        this.permissions = permissions;
	    }

	    public Set<String> getPermissions() {
	        return permissions;
	    }
}
