#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.mapper;

import it.contrader.jrolamo.generics.mapper.IMapper;
import ${package}.domain.Role;
import ${package}.dto.RoleDTO;
import org.mapstruct.Mapper;

/**
 * @author JRolamo
 * @since 1.0
 *
 */
@Mapper(componentModel = "spring")
public interface RoleMapper extends IMapper<Role, RoleDTO> {

}
