package pp5.domain;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class User {

	@Id
    private String userName;
    private String password;
    private String email;
	private int enabled;
	
	public User(){
		
	}
	
	public User(User user) {
		this.userName = user.userName;
		this.email = user.email;
		this.password = user.password;
		this.enabled=user.enabled;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
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