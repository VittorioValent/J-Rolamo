#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.sample.service.mapper;

import org.mapstruct.Mapper;

import ${package}.sample.domain.User;
import ${package}.sample.domain.dto.UserDTO;
import ${package}.sample.service.mapper.generic.IMapper;

/**
 *
 * @author Vittorio Andreoni
 */
@Mapper(componentModel = "spring")
public interface UserMapper extends IMapper<User, UserDTO> {	

}
