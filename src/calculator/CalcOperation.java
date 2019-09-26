package calculator;

/**
 * A interface defining an operation that can be used by the calculator
 */
public interface CalcOperation {
	
	/**
	 * Depending on the implementation, this method should return the calculation result or throw an exception
	 * @param x - first argument of the calculation
	 * @param y - second argument of the calculation
	 * @return - the result of the calculation
	 * @throws CalculatorException - an error indicating a problem with the calculation
	 */
	public double calculate (double x, double y) throws CalculatorException;
}
