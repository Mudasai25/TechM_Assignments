package Sample;
import java.util.Scanner;
public class Assign_Reverse {

	    public static void main(String[] args) {
	        Scanner sc = new Scanner(System.in);
	        System.out.println("Entre the Number:");
	        int num = sc.nextInt();

	        int reversed = 0;
	        while (num > 0) {
	            int digit = num % 10;  // Get the last digit
	            reversed = reversed * 10 + digit; // Append digit
	            num /= 10;  // Remove last digit
	        }

	        System.out.println(reversed);
	    }

}
