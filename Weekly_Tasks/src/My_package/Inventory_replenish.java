package My_assignments;
import java.util.*;

class Inventory {
    String inventoryId;
    int maximumQuantity;
    int currentQuantity;
    int threshold;
    
    public Inventory(String inventoryId, int maximumQuantity, int currentQuantity, int threshold) {
        this.inventoryId = inventoryId;
        this.maximumQuantity = maximumQuantity;
        this.currentQuantity = currentQuantity;
        this.threshold = threshold;
    }
    
    public String getInventoryId() {
        return inventoryId;
    }
    
    public int getThreshold() {
        return threshold;
    }
}

public class Inventory_replenish {
	public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Inventory[] inventories = new Inventory[4];
        
        for (int i = 0; i < 4; i++) {
            String inventoryId = scanner.nextLine().trim();
            int maximumQuantity = Integer.parseInt(scanner.nextLine().trim());
            int currentQuantity = Integer.parseInt(scanner.nextLine().trim());
            int threshold = Integer.parseInt(scanner.nextLine().trim());
            
            inventories[i] = new Inventory(inventoryId, maximumQuantity, currentQuantity, threshold);
        }
        
        int limit = Integer.parseInt(scanner.nextLine().trim());
        scanner.close();
        
        Inventory[] result = replenish(inventories, limit);
        
        for (Inventory inv : result) {
            System.out.println(inv.getInventoryId() + " " + getFillingStatus(inv.getThreshold()));
        }
    }
    
    public static Inventory[] replenish(Inventory[] inventories, int limit) {
        List<Inventory> filteredList = new ArrayList<>();
        
        for (Inventory inv : inventories) {
            if (inv.getThreshold() >= limit) {  
                filteredList.add(inv);
            }
        }
        
        return filteredList.toArray(new Inventory[0]);
    }
    
    public static String getFillingStatus(int threshold) {
        if (threshold > 75) {
            return "Critical Filling";
        } else if (threshold >= 50) {  
            return "Moderate Filling";
        } else {
            return "Non-Critical Filling";
        }
    }
}
