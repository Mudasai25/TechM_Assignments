package intro;

import java.util.Scanner;

public class q6 {
	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		int num=sc.nextInt();
		int reversed = 0;
	        
	     while (num != 0)
	    	 
	        {
	            int lastDigit = num % 10; 
	            reversed = reversed * 10 + lastDigit; 
	            num /= 10; 
	        }
	     System.out.println(reversed);
		
	}

}
