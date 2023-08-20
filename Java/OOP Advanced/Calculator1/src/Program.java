
public class Program {

	public static void main(String[] args) {
		Calculator c = new Calculator();
        c.setNum1(10.5);
        c.setOperator('+');
        c.setNum2(5.2);
        c.performOperation();
        c.getResults();
	}

}
