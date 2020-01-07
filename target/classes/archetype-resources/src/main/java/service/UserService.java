#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.service;

import org.springframework.stereotype.Service;

import ${package}.domain.User;
import ${package}.domain.dto.UserDTO;
import ${package}.service.generic.AbstractService;

/**
 * @author Vittorio Valent
 *
 */
@Service
public class UserService extends AbstractService<User, UserDTO> {

}
