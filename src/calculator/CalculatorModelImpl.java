package calculator;

public class CalculatorModelImpl implements CalculatorModel {
	private double x;
	private double y;

	@Override
	public double getX() {
		return x;
	}

	@Override
	public void setX(double x) {
		this.x = x;	
	}

	@Override
	public double getY() {
		return y;
	}

	@Override
	public void setY(double y) {
		this.y = y;
	}

	@Override
	public double getResult(CalcOperation operation) throws CalculatorException {
		return operation.calculate(x, y);
	}

}
