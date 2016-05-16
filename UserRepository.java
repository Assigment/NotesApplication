package org.gotprint.repositories;

import org.gotprint.model.User;
import org.springframework.data.repository.CrudRepository;

/**
 * @author dheeraj
 *
 */
public interface UserRepository extends CrudRepository<User, Long> {
	
	User findById(final Long id);

}
