#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.service;

import ${package}.domain.Role;
import ${package}.domain.dto.RoleDTO;
import ${package}.service.generic.ProtectedService;
import org.springframework.stereotype.Service;

/**
 * @author Vittorio Valent
 *
 */
@Service
public class RoleService extends ProtectedService<Role, RoleDTO> {

}
