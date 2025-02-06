package Sample;

import java.util.Scanner;

	class Institution {
	    private int institutionId;
	    private String institutionName;
	    private int noOfStudentsPlaced;
	    private int noOfStudentsCleared;
	    private String location;
	    private String grade;

	    // Constructor
	    public Institution(int institutionId, String institutionName, int noOfStudentsPlaced, int noOfStudentsCleared, String location) {
	        this.institutionId = institutionId;
	        this.institutionName = institutionName;
	        this.noOfStudentsPlaced = noOfStudentsPlaced;
	        this.noOfStudentsCleared = noOfStudentsCleared;
	        this.location = location;
	        this.grade = ""; // Default grade
	    }

	    // Getters
	    public int getInstitutionId() {
	        return institutionId;
	    }

	    public String getInstitutionName() {
	        return institutionName;
	    }

	    public int getNoOfStudentsPlaced() {
	        return noOfStudentsPlaced;
	    }

	    public int getNoOfStudentsCleared() {
	        return noOfStudentsCleared;
	    }

	    public String getLocation() {
	        return location;
	    }

	    public String getGrade() {
	        return grade;
	    }

	    // Setters
	    public void setGrade(String grade) {
	        this.grade = grade;
	    }
	}

	public class Assign_Instistution {
	    public static void main(String[] args) {
	        Scanner sc = new Scanner(System.in);

	        // Read institution details
	        Institution[] institutions = new Institution[4];
	        for (int i = 0; i < 4; i++) {
	            int id = sc.nextInt();
	            sc.nextLine(); // Consume newline
	            String name = sc.nextLine();
	            int placed = sc.nextInt();
	            int cleared = sc.nextInt();
	            sc.nextLine(); // Consume newline
	            String location = sc.nextLine();
	            institutions[i] = new Institution(id, name, placed, cleared, location);
	        }

	        // Read location for clearance check
	        String searchLocation = sc.nextLine();

	        // Read institution name for grade update
	        String searchInstitution = sc.nextLine();
	        sc.close();

	        // Call and print results for findNumClearancedByLoc
	        int clearanceCount = findNumClearancedByLoc(institutions, searchLocation);
	        if (clearanceCount > 0) {
	            System.out.println(clearanceCount);
	        } else {
	            System.out.println("There are no cleared students in this particular location");
	        }

	        // Call and print results for updateInstitutionGrade
	        Institution updatedInstitution = updateInstitutionGrade(institutions, searchInstitution);
	        if (updatedInstitution != null) {
	            System.out.println(updatedInstitution.getInstitutionName() + "::" + updatedInstitution.getGrade());
	        } else {
	            System.out.println("No Institute is available with the specified name");
	        }
	    }

	    public static int findNumClearancedByLoc(Institution[] instArray, String location) {
	        int totalCleared = 0;
	        for (Institution inst : instArray) {
	            if (inst.getLocation().equalsIgnoreCase(location)) {
	                totalCleared += inst.getNoOfStudentsCleared();
	            }
	        }
	        return totalCleared;
	    }

	    public static Institution updateInstitutionGrade(Institution[] instArray, String instName) {
	        for (Institution inst : instArray) {
	            if (inst.getInstitutionName().equalsIgnoreCase(instName)) {
	                int rating = (inst.getNoOfStudentsPlaced() * 100) / inst.getNoOfStudentsCleared();
	                inst.setGrade(rating >= 80 ? "A" : "B");
	                return inst;
	            }
	        }
	        return null;
	    }
	}

