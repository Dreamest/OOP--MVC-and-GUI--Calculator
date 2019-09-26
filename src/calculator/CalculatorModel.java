package calculator;

/**
 * This interface is based on the CalcOperation operation to perform calculations
 * @see CalcOperation 
 */
public interface CalculatorModel {
	/** 
	 * @return - the value of x that was set using setX.<BR/>
	 * If the user did not set x, the method returns zero
	 */
	public double getX ();
	
	/**
	 * Set the value of x 
	 * @param x - the first argument of the calculation
	 */
	public void setX (double x);
	
	/** 
	 * @return - the value of y that was set using setY.<BR/>
	 * If the user did not set y, the method returns zero
	 */
	public double getY ();
	/**
	 * Set the value of y 
	 * @param y - the second argument of the calculation
	 */
	public void setY (double y);
	
	/**
	 * @param operation - an implementation of the concrete operation used to perform the calcualtion
	 * @return - the result of the calculation, based on x and y arguments and the operation
	 * @throws CalculatorException - an error indicating a calculation problem. 
	 * The origin of this exception should be the <B>calculate</B> of the <B>operation</B> argument
	 * @see CalcOperation
	 */
	public double getResult (CalcOperation operation) throws CalculatorException;
	
}
