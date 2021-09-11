package gt.edu.umg.desaweb.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import gt.edu.umg.desaweb.model.TcSupplier;
import gt.edu.umg.desaweb.service.TcSupplierService;
import gt.edu.umg.desaweb.utils.ApiResponse;
import gt.edu.umg.desaweb.utils.ResponseResult;

@RestController
@RequestMapping("/supplier")
public class TcSupplierController {
	
	@Autowired
	TcSupplierService tcSupplierService;
	
	@GetMapping("/all")
	public ResponseEntity<ApiResponse> getAll() {
		ApiResponse r;
		try {
			r = tcSupplierService.getAll();
			return new ResponseEntity<ApiResponse>(r, HttpStatus.OK);
		} catch (Exception e) {
			r = new ApiResponse(ResponseResult.fail.getValue(), e.getMessage(), null);
			return new ResponseEntity<ApiResponse>(r, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping("/add")
	public TcSupplier setSupplier(@Valid @RequestBody TcSupplier item) {
		return tcSupplierService.setSupplier(item);
	}
	
	@PutMapping("/{supplierId}")
	public TcSupplier updSupplier(@PathVariable("supplierId") Long supplierId, 
			@Valid @RequestBody TcSupplier item) {
		if (supplierId == item.getSupplierId()) {
			return tcSupplierService.updSupplier(item);
		} else {
			return null;
		}
	}
	
	/*
	@DeleteMapping("/{supplierId}")
	public List<TcSupplier> delSupplier(@PathVariable("supplierId") Long supplierId) {
		tcSupplierService.delSupplier(supplierId);
		return tcSupplierService.getAll();
	}*/

}
