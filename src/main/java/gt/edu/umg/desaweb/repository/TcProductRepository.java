package gt.edu.umg.desaweb.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import gt.edu.umg.desaweb.model.TcProduct;

public interface TcProductRepository extends JpaRepository<TcProduct, Long> {
	
	List<TcProduct> findAllByProductDescLike(String productDesc);

}
