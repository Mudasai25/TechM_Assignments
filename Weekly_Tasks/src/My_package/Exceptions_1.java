package Sample;

public class Exceptions_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int num=12;
		int subb=0;
		try {
			int res=num/subb;
			System.out.println("Computed result is "+ res);
		}
		catch(ArithmeticException e) {
			System.out.println("zero divide erro");
		}
		finally {
			System.out.println("Finally block");
		}

	}

}
