#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.service.mapper;

import org.mapstruct.Mapper;

import ${package}.domain.Role;
import ${package}.domain.dto.RoleDTO;
import ${package}.service.mapper.generic.IMapper;

/**
 * @author Vittorio Valent
 *
 */
@Mapper(componentModel = "spring")
public interface RoleMapper extends IMapper<Role, RoleDTO> {

}
