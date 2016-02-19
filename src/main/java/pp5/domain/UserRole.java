package pp5.domain;

import javax.management.relation.Role;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by Rafał on 2016-02-19.
 */
@Entity
@Table(name = "authorities")
public class UserRole {
    @Id
    private String username;
    private String authority;

    public UserRole() {
    }

    public UserRole(String username, String authority) {
        this.username = username;
        this.authority = authority;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }
}
