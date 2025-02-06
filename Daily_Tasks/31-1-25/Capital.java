package Sample;

public class Capital {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str="Anurag";
		    StringBuilder result = new StringBuilder();
		    int count = 0; // Counter for alternation (ignoring spaces)

		    for (char c=0;c<str.length();c++) {
		        if (c != ' ') {
		            if (count % 2 == 0) {
		                result.append(Character.toUpperCase(c));
		            } else {
		                result.append(Character.toLowerCase(c));
		            }
		            count++; // Only increment for non-space characters
		        } else {
		            result.append(c); // Keep spaces as they are
		        }
		    }

		    System.out.println(result.toString());


	}

}
