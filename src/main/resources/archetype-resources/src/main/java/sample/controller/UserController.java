#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.sample.controller;

import com.querydsl.core.types.Predicate;
import io.swagger.annotations.Api;
import ${package}.sample.controller.generic.PrivateCrudController;
import ${package}.sample.domain.User;
import ${package}.sample.domain.dto.UserDTO;
import ${package}.sample.repository.UserRepository;
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
@RequestMapping("/api/user")
@Api(value = "Gestione User")
public class UserController extends PrivateCrudController<UserDTO> {

    @Override
    public Page<UserDTO> getAll(
            @QuerydslPredicate(root = User.class, bindings = UserRepository.class) Predicate predicate,
            @RequestParam(defaultValue = "20") Integer pageSize,
            @RequestParam(defaultValue = "0") Integer pageNumber,
            @RequestParam(defaultValue = "ASC") Direction direction,
            @RequestParam(defaultValue = "id") String sortField) {
        return service.getAll(predicate, PageRequest.of(pageNumber, pageSize, direction, sortField));
    }

}
