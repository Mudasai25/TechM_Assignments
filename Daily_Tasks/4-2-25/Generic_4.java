package Files;
import java.util.ArrayList;
import java.util.List;
		// TODO Auto-generated method stub

		public class Generic_4 {

		  public static < T > List < T > reverseList(List < T > originalList) {
		    List < T > reversedList = new ArrayList < > ();

		    for (int i = originalList.size() - 1; i >= 0; i--) {
		      reversedList.add(originalList.get(i));
		    }

		    return reversedList;
		  }

		  public static void main(String[] args) {
		    List < Integer > numbers = List.of(11, 21, 31, 41, 51, 61);
		    List < String > colors = List.of("Red", "Green", "Orange");

		    List < Integer > reversedNumbers = reverseList(numbers);
		    System.out.println("Original list of numbers: " + numbers);
		    System.out.println("Reversed numbers: " + reversedNumbers); // Output: [6, 5, 4, 3, 2, 1]

		    List < String > reversedWords = reverseList(colors);
		    System.out.println("\nOriginal list of colors: " + colors);
		    System.out.println("Reversed colors: " + reversedWords); // Output: [Orange, Green, Red]
		  }
		}

