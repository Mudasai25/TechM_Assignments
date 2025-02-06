package My_assignments;
import java.util.*;
public class Unique_characters {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner Sc=new Scanner(System.in);
		String str=Sc.nextLine().toLowerCase();
		StringBuilder pqr=new StringBuilder();
		LinkedHashSet<Character> S=new LinkedHashSet<>();
		for(char p: str.toCharArray()) {
			if(!S.contains(p)) {
				S.add(p);
				pqr.append(p);
			}
		}
		System.out.println(pqr);
		Sc.close();
	}

}
