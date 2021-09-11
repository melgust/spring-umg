package gt.edu.umg.desaweb.service;

import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

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
	
	public ApiResponse login(User user) {
		ApiResponse apiResponse;
		try {
			byte[] tmpBPass = Base64.decodeBase64(user.getUsername());
			String tmpPass = new String(tmpBPass);
			Authentication authentication = authenticationManager
					.authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(), tmpPass));
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

}
