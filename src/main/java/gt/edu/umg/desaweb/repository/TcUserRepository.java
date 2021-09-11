package gt.edu.umg.desaweb.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import gt.edu.umg.desaweb.model.TcUser;

public interface TcUserRepository extends JpaRepository<TcUser, Long> {
	
	Optional<TcUser> findByUsername(String username);

	Optional<TcUser> findByEmail(String email);

}
