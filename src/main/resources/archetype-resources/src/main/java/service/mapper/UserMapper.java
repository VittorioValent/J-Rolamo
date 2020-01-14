#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.service.mapper;

import org.mapstruct.Mapper;

import ${package}.domain.User;
import ${package}.domain.dto.UserDTO;
import ${package}.service.mapper.generic.IMapper;

/**
 *
 * @author Vittorio Andreoni
 */
@Mapper(componentModel = "spring")
public interface UserMapper extends IMapper<User, UserDTO> {	

}
