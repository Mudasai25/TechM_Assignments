package Files;
import java.io.File;
public class File_1 {

	public static void main(String[] args) {
		        String directoryPath = "C:\Users\Medha Trust\OneDrive\Desktop";

		        File directory = new File(directoryPath);

		        if (directory.exists() && directory.isDirectory()) {
		            String[] files = directory.list();

		            if (files != null && files.length > 0) {
		                System.out.println("Files and directories in " + directoryPath + ":");
		                for (String file : files) {
		                    System.out.println(file);
		                }
		            } else {
		                System.out.println("The directory is empty.");
		            }
		        } else {
		            System.out.println("The specified path is not a valid directory.");
		        }


	}

}
