package calculator;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class CalcualtorGuiController implements Initializable {

	@FXML
	Button add;
	@FXML
	Button subtract;
	@FXML
	Button multiply;
	@FXML
	Button divide;
	@FXML
	Button powerOf;
	@FXML
	TextField xField;
	@FXML
	TextField yField;
	@FXML
	TextField resField;

	private CalculatorModel model;
	private boolean allClear;
	private Double result;
	private String err;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		this.model = new CalculatorModelImpl();

		this.add.setOnAction(event -> {
			checkInputValues();
			try {
				if (allClear) {
					result = model.getResult((a, b) -> a + b);
					checkEdges();
					resField.setText("" + result);
				} else {
					throw new CalculatorException("invalid info");
				}
			} catch (CalculatorException e) {
				resField.setText(err);
				e.printStackTrace();
			}
		});

		this.subtract.setOnAction(event -> {
			checkInputValues();
			try {
				if (allClear) {
					result = model.getResult((a, b) -> a - b);
					checkEdges();
					resField.setText("" + result);
				} else {
					throw new CalculatorException("invalid info");
				}
			} catch (CalculatorException e) {
				resField.setText(err);
				e.printStackTrace();
			}
		});

		this.multiply.setOnAction(event -> {
			checkInputValues();
			try {
				if (allClear) {
					result = model.getResult((a, b) -> a * b);
					checkEdges();
					resField.setText("" + result);
				} else {
					throw new CalculatorException("Invalid information");
				}
			} catch (CalculatorException e) {
				resField.setText(err);
				e.printStackTrace();
			}
		});

		this.divide.setOnAction(event -> {
			checkInputValues();
			try {
				if (allClear) {
					if (Double.parseDouble(yField.getText()) == 0) {
						err = "Cannot be divided by zero.";
						throw new CalculatorException(err);
					}
					result = model.getResult((a, b) -> a / b);
					checkEdges();
					resField.setText("" + result);
				} else {
					throw new CalculatorException("invalid info");
				}
			} catch (CalculatorException e) {
				resField.setText(err);
				e.printStackTrace();
			}
		});

		this.powerOf.setOnAction(event -> {
			checkInputValues();
			try {
				if (allClear) {
					result = model.getResult((a, b) -> Math.pow(a, b));
					checkEdges();
					resField.setText("" + result);
				} else {
					throw new CalculatorException("invalid info");
				}
			} catch (CalculatorException e) {
				resField.setText(err);
				e.printStackTrace();
			}
		});
	}

	public void checkEdges() throws CalculatorException {
		if (result.isNaN() || result.isInfinite()) {
			err = "Invalid operation";
			throw new CalculatorException(err);
		}
	}

	public void checkInputValues() {
		allClear = true;
		err = "";
		try {
			model.setX(Double.parseDouble(xField.getText()));
			if (xField.getText().charAt(xField.getText().length() - 1) == 'D'
					|| xField.getText().charAt(xField.getText().length() - 1) == 'd'
					|| xField.getText().charAt(xField.getText().length() - 1) == 'f'
					|| xField.getText().charAt(xField.getText().length() - 1) == 'F') {
				throw new CalculatorException("d/f value in field X");
			}
		} catch (Exception e1) {
			e1.printStackTrace();
			allClear = false;
			err += "Invalid X value ";
		}
		try {
			if (xField.getText().charAt(yField.getText().length() - 1) == 'D'
					|| yField.getText().charAt(yField.getText().length() - 1) == 'd'
					|| yField.getText().charAt(yField.getText().length() - 1) == 'f'
					|| yField.getText().charAt(yField.getText().length() - 1) == 'F') {
				throw new CalculatorException("d/f value in field Y");
			}
			model.setY(Double.parseDouble(yField.getText()));
		} catch (Exception e1) {
			e1.printStackTrace();
			allClear = false;
			err += "Invalid Y value";
		}
	}

}
