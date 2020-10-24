package exception;

public class TrocoInsuficienteException extends RuntimeException {

	private String message;
		
	public TrocoInsuficienteException(String message) {
		this.message = message;
	}

	@Override
	public String getMessage() {
		return message;
	}
}
