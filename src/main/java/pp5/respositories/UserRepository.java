package pp5.respositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pp5.domain.User;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
}