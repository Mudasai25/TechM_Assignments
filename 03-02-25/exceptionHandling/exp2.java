package exceptionHandling;

public class exp2 {
	public static void main(String[] args) {
		try {
			int[] number= {10,20,30};
			int h=number[26];
		}
		finally {
			System.out.println("Before scanner close");
		}
		System.out.println("Just before closing of main");
	}

}
