package pp5.domain;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class User {

	@Id
    private String username;
    private String password;
    private String email;
	private int enabled = 1;
	
	public User(){
		
	}
	
	public User(User user) {
		this.username = user.username;
		this.email = user.email;
		this.password = user.password;
		this.enabled=user.enabled;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getEnabled() {
		return enabled;
	}

	public void setEnabled(int enabled) {
		this.enabled = enabled;
	}

}