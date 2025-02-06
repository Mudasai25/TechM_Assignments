package Sample;
import java.util.Scanner;
public class Assign_root {
	    public static void main(String[] args) {
	        Scanner sc = new Scanner(System.in);
	        int num = sc.nextInt();
	        sc.close();

	        // Calculate square root
	        int sqrt = (int) Math.sqrt(num);

	        // Check if it is a perfect square
	        if (sqrt * sqrt == num) {
	            System.out.println("TRUE");
	        } else {
	            System.out.println("FALSE");
	        }
	    }

}
