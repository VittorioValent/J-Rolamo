#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.sample.service;

import ${package}.sample.domain.Role;
import ${package}.sample.domain.dto.RoleDTO;
import ${package}.sample.service.generic.ProtectedService;
import org.springframework.stereotype.Service;

/**
 * @author Vittorio Valent
 *
 */
@Service
public class RoleService extends ProtectedService<Role, RoleDTO> {

}
