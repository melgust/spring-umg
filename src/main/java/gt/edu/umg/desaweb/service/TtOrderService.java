package gt.edu.umg.desaweb.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import gt.edu.umg.desaweb.model.TtOrder;
import gt.edu.umg.desaweb.model.TtOrderDetail;
import gt.edu.umg.desaweb.repository.TtOrderDetailRepository;
import gt.edu.umg.desaweb.repository.TtOrderRepository;
import gt.edu.umg.desaweb.utils.ApiResponse;
import gt.edu.umg.desaweb.utils.RegisterStatus;
import gt.edu.umg.desaweb.utils.ResponseResult;

@Service
public class TtOrderService {
	
	@Autowired
	TtOrderRepository ttOrderRepository;
	
	@Autowired
	TtOrderDetailRepository ttOrderDetailRepository;
	
	@Autowired
	ErrorManagerService errorManagerService;
	
	public ApiResponse getAll() {
		ApiResponse res;
		try {
			List<TtOrder> data = ttOrderRepository.findAll();
			res = new ApiResponse(ResponseResult.success.getValue(), ResponseResult.success.getMessage(), data);
		} catch (Exception e) {
			res = new ApiResponse(ResponseResult.fail.getValue(), errorManagerService.exceptionManager(e), null);
		}
		return res;
	}
	
	public ApiResponse get(long orderId) {
		ApiResponse res;
		try {
			Optional<TtOrder> io = ttOrderRepository.findById(orderId);
			TtOrder o = io.get();
			List<TtOrderDetail> detail = ttOrderDetailRepository.findAllByTtOrderAndStatusId(o, RegisterStatus.enable.value);
			o.setDetail(detail);
			res = new ApiResponse(ResponseResult.success.getValue(), ResponseResult.success.getMessage(), o);
		} catch (Exception e) {
			res = new ApiResponse(ResponseResult.fail.getValue(), errorManagerService.exceptionManager(e), null);
		}
		return res;
	}
	
	@Transactional
	public ApiResponse setOrder(TtOrder item) {
		ApiResponse apiResponse;
		try {
			item = ttOrderRepository.save(item);
			List<TtOrderDetail> detail = item.getDetail();
			for (TtOrderDetail od : detail) {
				od.setTtOrder(item);
				ttOrderDetailRepository.save(od);
			}
			apiResponse = new ApiResponse(ResponseResult.success.getValue(), "Orden creada exitosamente", null);
		} catch (Exception e) {
			apiResponse = new ApiResponse(ResponseResult.fail.getValue(), errorManagerService.exceptionManager(e), null);
		}
		return apiResponse;
	}
	
	public TtOrder updOrder(TtOrder item) {
		item = ttOrderRepository.save(item);
		return item;
	}
	
	public void delOrder(Long orderId) {
		TtOrder i = new TtOrder();
		i.setOrderId(orderId);
		ttOrderRepository.delete(i);
	}

}
