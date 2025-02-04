package intro;
import java.util.Scanner;
public class q5 {
	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int x= (int)Math.sqrt(n);
		if(x*x==n)
			System.out.println("perfect square");
		else
			System.out.println("not perfect square");
	}

}
