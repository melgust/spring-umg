package gt.edu.umg.desaweb.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import gt.edu.umg.desaweb.model.TtOrder;
import gt.edu.umg.desaweb.service.TtOrderService;
import gt.edu.umg.desaweb.utils.ApiResponse;
import gt.edu.umg.desaweb.utils.ResponseResult;

@RestController
@RequestMapping("/order")
public class TtOrderController {
	
	@Autowired
	TtOrderService ttOrderService;
	
	@PostMapping("/add")
	public ResponseEntity<ApiResponse> setOrder(@Valid @RequestBody TtOrder order) {
		ApiResponse r;
		try {
			r = ttOrderService.setOrder(order);
			return new ResponseEntity<ApiResponse>(r, HttpStatus.OK);
		} catch (Exception e) {
			r = new ApiResponse(ResponseResult.fail.getValue(), e.getMessage(), null);
			return new ResponseEntity<ApiResponse>(r, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/all")
	public ResponseEntity<ApiResponse> getAll() {
		ApiResponse r;
		try {
			r = ttOrderService.getAll();
			return new ResponseEntity<ApiResponse>(r, HttpStatus.OK);
		} catch (Exception e) {
			r = new ApiResponse(ResponseResult.fail.getValue(), e.getMessage(), null);
			return new ResponseEntity<ApiResponse>(r, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/{orderId}")
	public ResponseEntity<ApiResponse> getAll(@PathVariable("orderId") Long orderId) {
		ApiResponse r;
		try {
			r = ttOrderService.get(orderId);
			return new ResponseEntity<ApiResponse>(r, HttpStatus.OK);
		} catch (Exception e) {
			r = new ApiResponse(ResponseResult.fail.getValue(), e.getMessage(), null);
			return new ResponseEntity<ApiResponse>(r, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
