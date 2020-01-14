#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.service;

import ${package}.domain.User;
import ${package}.domain.dto.UserDTO;
import ${package}.service.generic.PrivateService;
import org.springframework.stereotype.Service;

/**
 * @author Vittorio Valent
 *
 */
@Service
public class UserService extends PrivateService<User, UserDTO> {

}
