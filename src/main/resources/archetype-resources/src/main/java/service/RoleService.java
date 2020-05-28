#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.service;

import it.contrader.jrolamo.generics.service.ProtectedService;
import ${package}.domain.Role;
import ${package}.dto.RoleDTO;
import org.springframework.stereotype.Service;

/**
 * @author JRolamo
 *
 * @since 1.0
 */
@Service
public class RoleService extends ProtectedService<Role, RoleDTO> {

}
