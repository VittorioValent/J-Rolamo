package it.pkg.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.querydsl.binding.QuerydslPredicate;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.querydsl.core.types.Predicate;

import io.swagger.annotations.Api;
import it.pkg.controller.generic.CrudController;
import it.pkg.domain.Role;
import it.pkg.domain.dto.RoleDTO;
import it.pkg.repository.RoleRepository;

/**
 * @author Vittorio Valent
 *
 */
@CrossOrigin
@RestController
@RequestMapping("/api/public/role")
@Api(value = "Gestione Roles")
public class RoleController extends CrudController<RoleDTO> {

	@Override
	public Page<RoleDTO> getAll(@QuerydslPredicate(root = Role.class, bindings = RoleRepository.class) Predicate predicate,
			@RequestParam(defaultValue = "20") Integer pageSize,
			@RequestParam(defaultValue = "0") Integer pageNumber,
			@RequestParam(defaultValue = "ASC") Direction direction,
			@RequestParam(defaultValue = "id") String sortField) {
		return service.getAll(predicate, PageRequest.of(pageNumber, pageSize, direction, sortField));
	}
}
