package Sample;
import java.util.Scanner;
public class Assign_StrReverse {
	    public static void main(String[] args) {
	        Scanner sc = new Scanner(System.in);
	        System.out.println("Entre the String:");
	        String s = sc.next();
	        sc.close();

	        s = s.toLowerCase();
	        String reversed = "";

	        for (int i = s.length() - 1; i >= 0; i--) {
	            reversed += s.charAt(i);
	        }

	        System.out.println(reversed);
	    }
	}

