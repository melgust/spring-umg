package gt.edu.umg.desaweb.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import gt.edu.umg.desaweb.model.TcClient;

public interface TcClientRepository extends JpaRepository<TcClient, Long> {
	
	List<TcClient> findAllByClientDescLike(String clientDesc);
	
	Optional<TcClient> findByNit(String nit);

}
