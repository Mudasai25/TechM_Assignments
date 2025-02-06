package My_assignments;
import java.util.*;
import java.lang.Math;
public class Perfect_Square {
	public static void main(String[] args) {
		Scanner Sc=new Scanner(System.in);
		int n=Sc.nextInt();
		
		int p=(int)Math.sqrt(n);
		
		System.out.println(p*p == n);
		Sc.close();
	}
}
