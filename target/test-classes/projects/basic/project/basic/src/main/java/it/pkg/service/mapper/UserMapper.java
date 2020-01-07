package it.pkg.service.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import it.pkg.domain.User;
import it.pkg.domain.dto.UserDTO;
import it.pkg.service.mapper.generic.IMapper;

/**
 *
 * @author Vittorio Valent
 */
@Mapper(componentModel = "spring")
public interface UserMapper extends IMapper<User, UserDTO> {

}
