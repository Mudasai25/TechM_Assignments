package My_assignments;
import java.util.Scanner;

public class Odd_Character {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		String str=sc.nextLine().toLowerCase();
		StringBuilder p=new StringBuilder();
		for(int i=0;i<str.toCharArray().length;i++) {
			if(i%2==1) {
				p.append(str.charAt(i));
			}
		}
		System.out.println(p.toString());
		sc.close();
	}

}
