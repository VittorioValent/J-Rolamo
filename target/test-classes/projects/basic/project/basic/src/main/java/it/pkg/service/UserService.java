package it.pkg.service;

import org.springframework.stereotype.Service;

import it.pkg.domain.User;
import it.pkg.domain.dto.UserDTO;
import it.pkg.service.generic.AbstractService;

/**
 * @author Vittorio Valent
 *
 */
@Service
public class UserService extends AbstractService<User, UserDTO> {

}
