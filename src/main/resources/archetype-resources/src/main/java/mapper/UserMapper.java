#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.mapper;

import it.jrolamo.generics.mapper.IMapper;
import ${package}.domain.User;
import ${package}.dto.UserDTO;
import org.mapstruct.Mapper;

/**
 *
 * @author JRolamo
 * @since 1.0
 */
@Mapper(componentModel = "spring")
public interface UserMapper extends IMapper<User, UserDTO> {

}
