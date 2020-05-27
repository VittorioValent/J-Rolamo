#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.controller.generic;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import ${package}.domain.generic.AbstractDTO;
import ${package}.service.generic.ICrudService;

/**
 * This controller contains all CRUD methods. Notice that method
 * {@code create(<DTO> dto)} needs a @Valid input.
 *
 * @author Vittorio
 *
 * @param <DTO>
 * @see ReadController
 * @see ICrudService
 * @since 1.0
 */
public abstract class ProtectedCrudController<DTO extends AbstractDTO> extends PublicReadController<DTO> {

	@PostMapping("/create")
	public DTO create(@Valid @RequestBody DTO dto) {
		return service.create(dto);
	}

	@DeleteMapping("/delete/{id}")
	public void delete(@RequestParam("id") Long id) {
		service.delete(id);
	}

	@PutMapping("/update")
	public DTO update(@RequestBody DTO dto) {
		return service.update(dto);
	}

	@PatchMapping("/update")
	public DTO merge(@RequestParam Long id, @RequestBody DTO dto) {

		return service.merge(id, dto);
	}
}
