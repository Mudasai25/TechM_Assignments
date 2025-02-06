package My_assignments;
import java.util.*;
public class Rev_Num {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner Sc=new Scanner(System.in);
		int n=Sc.nextInt();
		int rev=0;
		int rem=0;
		while(n>0) {
			rem=n%10;
			rev=rev*10+rem;
			n=n/10;
		}
		System.out.println(rev);
		Sc.close();
	}

}
