package Sample;
import java.io.FileNotFoundException;
import java.io.File;
import java.util.Scanner;
public class Exception_3 {

	public static void main(String[] args) {
		        try {
		            readFile("C://Users//Medha Trust//OneDrive//Desktop//Tech M Training COE.txt");
		        } catch (FileNotFoundException e) {
		            System.out.println("Error: " + e.getMessage());
		        }
		    }

		    public static void readFile(String fileName) throws FileNotFoundException {
		        File file = new File(fileName);

		        if (!file.exists()) {
		            throw new FileNotFoundException("File '" + fileName + "' not found.");
		        }

		        try (Scanner scanner = new Scanner(file)) {
		            System.out.println("Reading file: " + fileName);
		            while (scanner.hasNextLine()) {
		                System.out.println(scanner.nextLine());
		            }
		        }
		    }

}
