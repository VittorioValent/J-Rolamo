#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.sample.service;

import ${package}.sample.domain.User;
import ${package}.sample.domain.dto.UserDTO;
import ${package}.sample.service.generic.PrivateService;
import org.springframework.stereotype.Service;

/**
 * @author Vittorio Valent
 *
 */
@Service
public class UserService extends PrivateService<User, UserDTO> {

}
