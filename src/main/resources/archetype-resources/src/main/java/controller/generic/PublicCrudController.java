#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.controller.generic;

import ${package}.service.generic.ICrudService;
import javax.validation.Valid;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * This controller contains all CRUD methods. Notice that method
 * {@code create(<DTO> dto)} needs a @Valid input.
 *
 * @author Vittorio
 *
 * @param <DTO>
 * @see ReadController
 * @see ICrudService
 */
public abstract class PublicCrudController<DTO> extends PublicReadController<DTO> {

    @PostMapping("/public/create")
    public DTO create(@Valid @RequestBody DTO dto) {
        return service.create(dto);
    }

    @DeleteMapping("/public/delete")
    public void delete(@RequestBody DTO dto) {
        service.delete(dto);
    }

    @PutMapping("/public/update")
    public DTO update(@RequestBody DTO dto) {
        return service.update(dto);
    }

    @PatchMapping("/public/update")
    public DTO merge(@RequestParam Long id, @RequestBody DTO dto) {

        return service.merge(id, dto);
    }
}
