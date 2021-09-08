package gt.edu.umg.desaweb.utils;

public enum RegisterStatus {
	
	disable((byte)0), enable((byte)1);
	
	public final Byte value;
	
	private RegisterStatus(Byte value) {
		this.value = value;
	}
	
	public Byte getValue() {
		return this.value;
	}

}
