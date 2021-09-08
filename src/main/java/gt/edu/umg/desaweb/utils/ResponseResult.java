package gt.edu.umg.desaweb.utils;

public enum ResponseResult {
	
	fail(-1), success(1), warning(0);
	private final int value;

	ResponseResult(int value) {
		this.value = value;
	}
	
	public int getValue() { 
		return this.value;
	}
	
	public String getMessage() {
		String msg;
		switch (this.value) {
		case -1:
			msg = "Problemas en la ejecucion";
			break;
		case 1:
			msg = "Proceso exitoso";
			break;
		case 0:
			msg = "Hay informacion con el que debe tener precaucion";
			break;
		default:
			msg = "Problemas en la ejecucion";
			break;
		}
		return msg;
	}

}
