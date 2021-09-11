package gt.edu.umg.desaweb.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gt.edu.umg.desaweb.utils.ConfigProperty;

@Service
public class ErrorManagerService {
	private static final Logger logger = LoggerFactory.getLogger(ErrorManagerService.class);
	
	private boolean showException;
	
	@Autowired
	public ErrorManagerService(ConfigProperty p) {
		this.showException = p.isShowExecption();
	}
	
	public String exceptionManager(Exception e) {
		String msg;
		msg = "Ha ocurrido un error";
		logger.info(e.getMessage());
		if (this.showException) {
			msg += e.getMessage();
		}
		if (e.getMessage().contains("Bad credentials")) {
			msg ="El usuario o la clave no son correctas";
		}
		return msg;
	}
	
}
