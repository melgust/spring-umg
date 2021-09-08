package gt.edu.umg.desaweb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import gt.edu.umg.desaweb.model.TcSupplier;
import gt.edu.umg.desaweb.repository.TcSupplierRepository;
import gt.edu.umg.desaweb.utils.ApiResponse;
import gt.edu.umg.desaweb.utils.ResponseResult;

@Service
public class TcSupplierService {
	
	@Autowired
	TcSupplierRepository tcSupplierRepository;
	
	@Autowired
	ErrorManagerService errorManagerService;
	
	public ApiResponse getAll() {
		ApiResponse res;
		try {
			List<TcSupplier> data = tcSupplierRepository.findAll();
			res = new ApiResponse(ResponseResult.success.getValue(), ResponseResult.success.getMessage(), data);
		} catch (Exception e) {
			res = new ApiResponse(ResponseResult.fail.getValue(), errorManagerService.exceptionManager(e), null);
		}
		return res;
	}
	
	public TcSupplier setSupplier(TcSupplier item) {
		item = tcSupplierRepository.save(item);
		return item;
	}
	
	public TcSupplier updSupplier(TcSupplier item) {
		item = tcSupplierRepository.save(item);
		return item;
	}
	
	public void delSupplier(Long supplierId) {
		TcSupplier i = new TcSupplier();
		i.setSupplierId(supplierId);
		tcSupplierRepository.delete(i);
	}

}
