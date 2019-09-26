package calculator;

/**
 * Using this exception the calculator can indicate calculation problems 
 */
public class CalculatorException extends Exception {
	private static final long serialVersionUID = -4034841497981830473L;

	public CalculatorException() {
		super();
	}

	public CalculatorException(String message) {
		super(message);
	}
	
	public CalculatorException(Throwable cause) {
		super(cause);
	}
	
	public CalculatorException(String message, Throwable cause) {
		super(message, cause);
	}
}
