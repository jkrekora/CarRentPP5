package pp5.domain;

import javax.management.relation.Role;
import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Rafał on 2016-02-19.
 */
@Entity
@Table(name = "authorities")
public class UserRole implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="username")
    private User username;
    private String authority;

    public UserRole() {
    }

    public UserRole(User username, String authority) {
        this.username = username;
        this.authority = authority;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public User getUsername() {
        return username;
    }

    public void setUsername(User username) {
        this.username = username;
    }

    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }
}
