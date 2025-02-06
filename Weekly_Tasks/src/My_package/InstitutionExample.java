package My_assignments;

import java.util.*;

class Institution {
    private int institutionId;
    private String institutionName;
    private int noOfStudentsPlaced;
    private int noOfStudentsCleared;
    private String location;
    private String grade;

    public Institution(int institutionId, String institutionName, int noOfStudentsPlaced, int noOfStudentsCleared, String location) {
        this.institutionId = institutionId;
        this.institutionName = institutionName;
        this.noOfStudentsPlaced = noOfStudentsPlaced;
        this.noOfStudentsCleared = noOfStudentsCleared;
        this.location = location;
        this.grade = "";
    }

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

    public void setGrade(String grade) {
        this.grade = grade;
    }
}

public class InstitutionExample {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Institution[] institutions = new Institution[4];
        
        for (int i = 0; i < 4; i++) {
            int institutionId = Integer.parseInt(sc.nextLine());
            String institutionName = sc.nextLine();
            int noOfStudentsPlaced = Integer.parseInt(sc.nextLine());
            int noOfStudentsCleared = Integer.parseInt(sc.nextLine());
            String location = sc.nextLine();
            
            institutions[i] = new Institution(institutionId, institutionName, noOfStudentsPlaced, noOfStudentsCleared, location);
        }
        
        String searchLocation = sc.nextLine().trim();
        String searchInstitutionName = sc.nextLine().trim();
        sc.close();
        
        int totalCleared = findNumClearancedByLoc(institutions, searchLocation);
        if (totalCleared > 0) {
            System.out.println(totalCleared);
        } else {
            System.out.println("There are no cleared students in this particular location");
        }
        
        Institution resultInstitution = updateInstitutionGrade(institutions, searchInstitutionName);
        if (resultInstitution != null) {
            System.out.println(resultInstitution.getInstitutionName() + "::" + resultInstitution.getGrade());
        } else {
            System.out.println("No Institute is available with the specified name");
        }
    }
    
    public static int findNumClearancedByLoc(Institution[] instArray, String location) {
        int sum = 0;
        for (Institution inst : instArray) {
            if (inst.getLocation().equalsIgnoreCase(location)) {
                sum += inst.getNoOfStudentsCleared();
            }
        }
        return sum;
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
