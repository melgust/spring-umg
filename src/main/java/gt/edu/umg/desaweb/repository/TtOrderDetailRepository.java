package gt.edu.umg.desaweb.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import gt.edu.umg.desaweb.model.TtOrder;
import gt.edu.umg.desaweb.model.TtOrderDetail;

public interface TtOrderDetailRepository extends JpaRepository<TtOrderDetail, Long> {
	
	List<TtOrderDetail> findAllByTtOrder(TtOrder ttOrder);
	
	List<TtOrderDetail> findAllByTtOrderAndStatusId(TtOrder ttOrder, Byte statusId);

}
