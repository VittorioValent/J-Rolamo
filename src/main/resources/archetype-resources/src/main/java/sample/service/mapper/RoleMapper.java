#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.sample.service.mapper;

import org.mapstruct.Mapper;

import ${package}.sample.domain.Role;
import ${package}.sample.domain.dto.RoleDTO;
import ${package}.sample.service.mapper.generic.IMapper;

/**
 * @author Vittorio Valent
 *
 */
@Mapper(componentModel = "spring")
public interface RoleMapper extends IMapper<Role, RoleDTO> {

}
