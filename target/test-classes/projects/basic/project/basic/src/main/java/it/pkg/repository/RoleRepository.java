package it.pkg.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import it.pkg.domain.Role;
import it.pkg.repository.generic.IRepository;

/**
 * @author Vittorio Valent
 *
 */
@Repository
public interface RoleRepository extends IRepository<Role> {

	public List<Role> findByName(String name);
}
