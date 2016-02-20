package pp5.services;

import pp5.domain.User;
import pp5.validation.UserExistsException;

/**
 * Created by Rafał on 2016-02-19.
 */
public interface UserService {
    User registerNewUserAccount(PersonForm accountDto) throws UserExistsException;
    User findUserByUsername(String string);
}
