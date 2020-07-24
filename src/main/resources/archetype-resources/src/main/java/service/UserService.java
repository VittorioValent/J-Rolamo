#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.service;

import it.jrolamo.generics.service.PrivateService;
import ${package}.domain.User;
import ${package}.dto.UserDTO;
import org.springframework.stereotype.Service;

/**
 * @author JRolamo
 *
 * @since 1.0
 */
@Service
public class UserService extends PrivateService<User, UserDTO> {

}
