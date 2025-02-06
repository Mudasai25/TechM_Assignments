package My_assignments;
import java.util.Scanner;
public class Rev_String {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        Scanner Sc=new Scanner(System.in);
        String str=Sc.nextLine();
        String rev= new StringBuilder(str).reverse().toString().toLowerCase();
        System.out.println(rev);
        Sc.close();
	}

}
