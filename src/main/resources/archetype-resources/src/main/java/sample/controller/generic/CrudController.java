#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.sample.controller.generic;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import ${package}.sample.service.generic.ICrudService;

/**
 * This controller contains all CRUD methods. Notice that method
 * {@code create(<DTO> dto)} needs a @Valid input.
 * 
 * @author Vittorio Valent
 *
 * @param <DTO>
 * @see ReadController
 * @see ICrudService
 */
public abstract class CrudController<DTO> extends ReadController<DTO> {

	@PostMapping("/create")
	public DTO create(@Valid @RequestBody DTO dto) {
		return service.create(dto);
	}

	@DeleteMapping("/delete")
	public void delete(@RequestBody DTO dto) {
		service.delete(dto);
	}

	@PutMapping("/update")
	public DTO update(@RequestBody DTO dto) {
		return service.update(dto);
	}
}
