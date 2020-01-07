package it.pkg.service.mapper;

import org.mapstruct.Mapper;

import it.pkg.domain.Role;
import it.pkg.domain.dto.RoleDTO;
import it.pkg.service.mapper.generic.IMapper;

/**
 * @author Vittorio Valent
 *
 */
@Mapper(componentModel = "spring")
public interface RoleMapper extends IMapper<Role, RoleDTO> {

}
