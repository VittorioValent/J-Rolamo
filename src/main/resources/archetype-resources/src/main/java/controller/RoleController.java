#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.controller;

import com.querydsl.core.types.Predicate;
import io.swagger.annotations.Api;
import ${package}.controller.generic.ProtectedCrudController;
import ${package}.domain.Role;
import ${package}.domain.dto.RoleDTO;
import ${package}.repository.RoleRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.querydsl.binding.QuerydslPredicate;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Vittorio Valent
 *
 */
@CrossOrigin
@RestController
@RequestMapping("/api/role")
@Api(value = "Gestione Roles")
public class RoleController extends ProtectedCrudController<RoleDTO> {

    @Override
    public Page<RoleDTO> getAll(@QuerydslPredicate(root = Role.class, bindings = RoleRepository.class) Predicate predicate,
            @RequestParam(defaultValue = "20") Integer pageSize,
            @RequestParam(defaultValue = "0") Integer pageNumber,
            @RequestParam(defaultValue = "ASC") Direction direction,
            @RequestParam(defaultValue = "id") String sortField) {
        return service.getAll(predicate, PageRequest.of(pageNumber, pageSize, direction, sortField));
    }
}
