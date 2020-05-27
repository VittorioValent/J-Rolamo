#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.service;

import org.springframework.stereotype.Service;

import ${package}.domain.User;
import ${package}.domain.dto.UserDTO;
import ${package}.service.generic.PrivateService;

/**
 * @author JRolamo
 *
 * @since 1.0
 */
@Service
public class UserService extends PrivateService<User, UserDTO> {

}
