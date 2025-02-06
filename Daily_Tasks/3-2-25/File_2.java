package Files;
import java.io.File;
public class File_2 {

	public static void main(String[] args) {
		        String directoryPath = "C://Users//Medha Trust//OneDrive//Desktop";
		        String extension = ".pdf"; 
		        File directory = new File(directoryPath);

		        if (directory.exists() && directory.isDirectory()) {
		            File[] files = directory.listFiles((dir, name) -> name.endsWith(extension));

		            if (files != null && files.length > 0) {
		                for (File file : files) {
		                    System.out.println(file.getName());
		                }
		            } else {
		                System.out.println("No files with " + extension + " extension found.");
		            }
		        } else {
		            System.out.println("Invalid directory.");
		        }

	}

}
