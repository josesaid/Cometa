package com.mx.development;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * @author josesaidolanogarcia
 */
@Repository
public interface UserRepository extends CrudRepository<User, Integer> {

	Optional<User> findByUsername(String username);
	
}
