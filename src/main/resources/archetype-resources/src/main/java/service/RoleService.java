#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.service;

import org.springframework.stereotype.Service;

import ${package}.domain.Role;
import ${package}.domain.dto.RoleDTO;
import ${package}.service.generic.PublicService;

/**
 * @author Vittorio Valent
 *
 */
@Service
public class RoleService extends PublicService<Role, RoleDTO> {

}
