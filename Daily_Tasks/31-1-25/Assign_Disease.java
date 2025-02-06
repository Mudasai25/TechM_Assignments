package Sample;
import java.util.*;

class Medicine {
    private String medicineName;
    private String batch;
    private String disease;
    private int price;

    // Constructor
    public Medicine(String medicineName, String batch, String disease, int price) {
        this.medicineName = medicineName;
        this.batch = batch;
        this.disease = disease;
        this.price = price;
    }

    // Getters and Setters
    public String getMedicineName() {
        return medicineName;
    }

    public void setMedicineName(String medicineName) {
        this.medicineName = medicineName;
    }

    public String getBatch() {
        return batch;
    }

    public void setBatch(String batch) {
        this.batch = batch;
    }

    public String getDisease() {
        return disease;
    }

    public void setDisease(String disease) {
        this.disease = disease;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}

class Sol {
    // Static method to get prices of medicines by disease
    public static Integer[] getPriceByDisease(Medicine[] medicines, String disease) {
        List<Integer> prices = new ArrayList<>();
        
        // Filter medicines with the given disease (case insensitive)
        for (Medicine medicine : medicines) {
            if (medicine.getDisease().equalsIgnoreCase(disease)) {
                prices.add(medicine.getPrice());
            }
        }
        
        // Sort the prices in ascending order
        Collections.sort(prices);
        
        // Convert List to Integer[] and return
        return prices.toArray(new Integer[0]);
    }
}

public class Assign_Disease {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // Reading data for 4 Medicine objects
        Medicine[] medicines = new Medicine[4];
        
        for (int i = 0; i < 4; i++) {
            String medicineName = sc.next();
            String batch = sc.next();
            String disease = sc.next();
            int price = sc.nextInt();
            medicines[i] = new Medicine(medicineName, batch, disease, price);
        }
        
        // Reading the disease to search for
        String disease = sc.next();
        
        // Calling the getPriceByDisease method
        Integer[] result = Sol.getPriceByDisease(medicines, disease);
        
        // Printing the result (sorted prices)
        for (Integer price : result) {
            System.out.println(price);
        }
    }
}
