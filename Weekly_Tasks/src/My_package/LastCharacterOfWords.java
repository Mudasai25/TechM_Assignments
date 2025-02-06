package My_assignments;
public class LastCharacterOfWords {
	public static void main(String[] args) {
		String input = "Hey3 Java   Learners";
		input = input.replaceAll("[0-9]", "");
        String[] words = input.split("\\s+");
        for (String word : words) {
            if (!word.isEmpty()) {
                System.out.print(word.charAt(word.length() - 1));
            }
        }
     }
}
