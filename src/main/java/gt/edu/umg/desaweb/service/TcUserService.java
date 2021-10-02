package gt.edu.umg.desaweb.service;

import java.util.List;
import java.util.Optional;

import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import gt.edu.umg.desaweb.jwt.JwtProvider;
import gt.edu.umg.desaweb.model.TcUser;
import gt.edu.umg.desaweb.model.User;
import gt.edu.umg.desaweb.repository.TcUserRepository;
import gt.edu.umg.desaweb.utils.ApiResponse;
import gt.edu.umg.desaweb.utils.RegisterStatus;
import gt.edu.umg.desaweb.utils.ResponseResult;

@Service
public class TcUserService {
	
	@Autowired
	TcUserRepository tcUserRepository;
	
	@Autowired
	AuthenticationManager authenticationManager;
	
	@Autowired
	JwtProvider jwtProvider;
	
	@Autowired
	EncryptService encryptService;
	
	@Autowired
	ErrorManagerService errorManagerService;
	
	@Autowired
	PasswordEncoder passwordEncoder;
	
	public ApiResponse login(User user) {
		ApiResponse apiResponse;
		try {
			//byte[] tmpBPass = Base64.decodeBase64(user.getUsername());
			//String tmpPass = new String(tmpBPass);
			Authentication authentication = authenticationManager
					.authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));
			SecurityContextHolder.getContext().setAuthentication(authentication);
			Optional<TcUser> found = tcUserRepository.findByUsername(user.getUsername());
			TcUser tcUser = found.get();
			if (tcUser.getStatusId() == RegisterStatus.enable.getValue()) {
				String token = jwtProvider.generateJwtToken(authentication, String.valueOf(tcUser.getUserId()));
				apiResponse = new ApiResponse(ResponseResult.success.getValue(), "Acceso correcto", token);
			} else {
				apiResponse = new ApiResponse(ResponseResult.fail.getValue(), "El usuario no se encuentra activo, favor de comunicarse con el administrador del sistema", null);				
			}
		} catch (Exception e) {
			apiResponse = new ApiResponse(ResponseResult.fail.getValue(), errorManagerService.exceptionManager(e), null);
		}
		return apiResponse;
	}
	
	public ApiResponse setUser(TcUser user) {
		ApiResponse apiResponse;
		try {
			user.setPassword(passwordEncoder.encode(user.getPassword()));
			user = tcUserRepository.save(user);
			apiResponse = new ApiResponse(ResponseResult.success.getValue(), "Usuario creado", user);
		} catch (Exception e) {
			apiResponse = new ApiResponse(ResponseResult.fail.getValue(), errorManagerService.exceptionManager(e), null);
		}
		return apiResponse;		
	}
	
	public ApiResponse getAll() {
		ApiResponse res;
		try {
			List<TcUser> data = tcUserRepository.findAll();
			res = new ApiResponse(ResponseResult.success.getValue(), ResponseResult.success.getMessage(), data);
		} catch (Exception e) {
			res = new ApiResponse(ResponseResult.fail.getValue(), errorManagerService.exceptionManager(e), null);
		}
		return res;
	}

}
