package gt.edu.umg.desaweb.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class ErrorManagerService {
	private static final Logger logger = LoggerFactory.getLogger(ErrorManagerService.class);
	
	public String exceptionManager(Exception e) {
		String msg;
		msg = "Ha ocurrido un error";
		logger.info(e.getMessage());
		return msg;
	}
	
}
