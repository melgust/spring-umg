package gt.edu.umg.desaweb.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import gt.edu.umg.desaweb.model.User;
import gt.edu.umg.desaweb.service.TcUserService;
import gt.edu.umg.desaweb.utils.ApiResponse;
import gt.edu.umg.desaweb.utils.ResponseResult;

@RestController
@RequestMapping("/user")
public class TcUserController {
	
	@Autowired
	TcUserService tcUserService;
	
	@PostMapping("/login")
	public ResponseEntity<ApiResponse> setSupplier(@Valid @RequestBody User user) {
		ApiResponse r;
		try {
			r = tcUserService.login(user);
			return new ResponseEntity<ApiResponse>(r, HttpStatus.OK);
		} catch (Exception e) {
			r = new ApiResponse(ResponseResult.fail.getValue(), e.getMessage(), null);
			return new ResponseEntity<ApiResponse>(r, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
