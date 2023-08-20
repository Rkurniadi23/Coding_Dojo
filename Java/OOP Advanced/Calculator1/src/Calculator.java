
public class Calculator {
	private double result;
	private double number1;
	private double number2;
	private char operator; 
	
	public Calculator() {
		
	}
	public void setNum1(double input) {
		this.number1 = input;
	}
	public void setNum2(double input) {
		this.number2 = input;
	}
	public void setOperator(char input) {
		this.operator = input;
	}
	public void performOperation() {
		if( this.operator == '+') {
			result = (number1) + (number2);
		}
		if( this.operator == '-') {
			result = (number1) - (number2);
		}
	}
	public void getResults() {
		System.out.println(result);
	}
}
