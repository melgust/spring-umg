package gt.edu.umg.desaweb.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import gt.edu.umg.desaweb.model.TcClient;
import gt.edu.umg.desaweb.model.TtOrder;

public interface TtOrderRepository extends JpaRepository<TtOrder, Long> {
	
	List<TtOrder> findAllByTcClient(TcClient tcClient);
	
	List<TtOrder> findAllByTcClientAndStatusId(TcClient tcClient, Byte statusId);

}
