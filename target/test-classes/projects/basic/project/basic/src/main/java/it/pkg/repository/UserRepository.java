package it.pkg.repository;

import org.springframework.stereotype.Repository;

import it.pkg.domain.User;
import it.pkg.repository.generic.IRepository;

/**
 * @author Vittorio Valent
 *
 */
@Repository
public interface UserRepository extends IRepository<User> {

	public User findByUsername(String username);

}
