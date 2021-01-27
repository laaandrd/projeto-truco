package exceptions;

public class TrucoException extends RuntimeException{
	private static final long serialVersionUID = 1L;
	
	public TrucoException(String msg) {
		super(msg);
	}

}
