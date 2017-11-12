package login;

public class User {
	
	
	String username ="";
	public enum Role {
			ADMIN,EMPLOYEE,HR
			};
	Role role;
	
	
	public User(String username, Role role) {
		this.username = username;
		this.role = Role.ADMIN;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public Role getRole() {
		return role;
	}


	public void setRole(Role role) {
		this.role = role;
	}
	
	
	
	
	
	
}
