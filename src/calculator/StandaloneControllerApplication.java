package calculator;

import java.util.Scanner;

public class StandaloneControllerApplication {
	public static void main(String[] args) {
		CalculatorModel calculator = new CalculatorModelImpl();
		
		try (Scanner scanner = new Scanner(System.in)){
			try {
				System.out.print("type argument x: ");
				double x = Double.parseDouble(scanner.nextLine().trim());
				checkValue(x);
				
				System.out.print("type argument y: ");
				double y = Double.parseDouble(scanner.nextLine().trim());
				checkValue(y);
				
				System.out.print("type operation (+ - * / ^): ");
				String operationType = scanner.nextLine().trim();
				CalcOperation operation = null;
				switch (operationType) {
					case "+":
						operation = (a,b)->a+b;
						break;
	
					case "-":
						operation = (a,b)->a-b;
						break;
						
					case "*":
						operation = (a,b)->a*b;
						break;

					case "/":
				/*		if(y==0) {
							throw new Exception("The value of Y cannot be zero.");
						}*/
						operation = (a,b)->a/b;
						break;

					case "^":
						operation = (a,b)->Math.pow(a, b);
						break;

					default:
						throw new Exception("Illegal operation: " + operationType);
						//break;
				}
				
				calculator.setX(x);
				calculator.setY(y);
				double result = calculator.getResult(operation);
				Double tempRes = result;
				if(tempRes.isInfinite() || tempRes.isNaN()) {
					throw new CalculatorException("Invalid input");
				}
				
				System.out.println(
						"The result of " + 
						x + " " + 
						operationType + " " +  
						y + 
						" is: " + result);

			} catch (Exception e) {
				System.out.println("Error while calculating: " + e.getMessage());
			}
		}
	}

	private static void checkValue(double num) throws CalculatorException {
		 String temp = num +"";
			if (temp.charAt(temp.length() - 1) == 'D'
					|| temp.charAt(temp.length() - 1) == 'd'
					|| temp.charAt(temp.length() - 1) == 'f'
					|| temp.charAt(temp.length() - 1) == 'F') {
				throw new CalculatorException("Invalid value");
			}
		
	}
}
