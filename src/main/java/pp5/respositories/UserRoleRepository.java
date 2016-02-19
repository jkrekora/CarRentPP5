package pp5.respositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pp5.domain.UserRole;

/**
 * Created by Rafał on 2016-02-19.
 */
@Repository
public interface UserRoleRepository extends JpaRepository<UserRole, String> {
}
