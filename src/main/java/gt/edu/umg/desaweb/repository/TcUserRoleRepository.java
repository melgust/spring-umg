package gt.edu.umg.desaweb.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import gt.edu.umg.desaweb.model.TcRole;
import gt.edu.umg.desaweb.model.TcUser;
import gt.edu.umg.desaweb.model.TcUserRole;

public interface TcUserRoleRepository extends JpaRepository<TcUserRole, Long> {
	
	@Query("SELECT r FROM TcUserRole ur INNER JOIN ur.tcRole r WHERE ur.tcUser = :tcUser")
	List<TcRole> findAllByTcUser(@Param("tcUser") TcUser tcUser);

}
