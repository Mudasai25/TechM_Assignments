package My_assignments;
import java.util.Scanner;
public class Space_count {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		String str=sc.nextLine();
		
		int s=0,c=0;
		for(char ch: str.toCharArray()) {
			if(ch==' ') {
				s++;
			}else {
				c++;
			}
		}
		System.out.println("No of spaces : "+s+" and characters : "+c);
		sc.close();
	}

}
