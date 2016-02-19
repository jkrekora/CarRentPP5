package pp5.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pp5.domain.User;
import pp5.domain.UserRole;
import pp5.respositories.UserRepository;
import pp5.respositories.UserRoleRepository;
import pp5.validation.UserExistsException;

/**
 * Created by Rafał on 2016-02-19.
 */
@Service
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;

    @Autowired
    UserRoleRepository userRoleRepository;

    @Override
    public User registerNewUserAccount(PersonForm accountForm) throws UserExistsException {
        if (userExist(accountForm.getUsername())) {
            throw new UserExistsException("There is an account with this login.");
        }
        User user = new User();
        user.setUsername(accountForm.getUsername());
        user.setPassword(new BCryptPasswordEncoder().encode(accountForm.getPassword()));
        user.setEmail(accountForm.getEmail());
        return createAccount(user);
    }

    private User createAccount(User user) {
        User registered = userRepository.save(user);
        if (registered != null) {
            UserRole userRole = new UserRole(user.getUsername(), "ROLE_USER");
            userRoleRepository.save(userRole);
            return registered;
        }
        return null;
    }


    private boolean userExist(String userName) {
        final User user = userRepository.findOne(userName);
        if (user != null) {
            return true;
        }
        return false;
    }
}
