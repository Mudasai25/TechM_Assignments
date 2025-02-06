package My_package;
import java.io.FileNotFoundException;
import java.io.File;
import java.util.Scanner;
public class Exception_3 {

	public static void main(String[] args) {
		        try {
		            // Call the method to read the file
		            readFile("C:\\Users\\krish\\OneDrive\\Desktop\\Tech M Training COE.txt");
		        } catch (FileNotFoundException e) {
		            // Handle the exception if the file is not found
		            System.out.println("Error: " + e.getMessage());
		        }
		    }

		    // Method to read a file
		    public static void readFile(String fileName) throws FileNotFoundException {
		        File file = new File(fileName);

		        // Check if the file exists
		        if (!file.exists()) {
		            // Throw an exception if the file is not found
		            throw new FileNotFoundException("File '" + fileName + "' not found.");
		        }

		        // Read the file using Scanner
		        try (Scanner scanner = new Scanner(file)) {
		            System.out.println("Reading file: " + fileName);
		            while (scanner.hasNextLine()) {
		                System.out.println(scanner.nextLine());
		            }
		        }
		    }

}
