package My_assignments;

import java.util.*;

class Phone {
    private int phoneId;
    private String os;
    private String brand;
    private int price;

    public Phone(int phoneId, String os, String brand, int price) {
        this.phoneId = phoneId;
        this.os = os;
        this.brand = brand;
        this.price = price;
    }

    public int getPhoneId() {
        return phoneId;
    }

    public String getOs() {
        return os;
    }

    public String getBrand() {
        return brand;
    }

    public int getPrice() {
        return price;
    }
}

public class Device_Management {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Phone[] phones = new Phone[4];

        for (int i = 0; i < 4; i++) {
            int phoneId = Integer.parseInt(sc.nextLine());
            String os = sc.nextLine();
            String brand = sc.nextLine();
            int price = Integer.parseInt(sc.nextLine());
            phones[i] = new Phone(phoneId, os, brand, price);
        }

        String searchBrand = sc.nextLine();
        String searchOs = sc.nextLine();
        sc.close();

        int priceSum = findPriceForGivenBrand(phones, searchBrand);
        if (priceSum > 0) {
            System.out.println(priceSum);
        } else {
            System.out.println("The given Brand is not available");
        }

        Phone resultPhone = getPhoneIdBasedOnOs(phones, searchOs);
        if (resultPhone != null) {
            System.out.println(resultPhone.getPhoneId());
        } else {
            System.out.println("No phones are available with specified os and price range");
        }
    }

    public static int findPriceForGivenBrand(Phone[] phones, String brand) {
        int sum = 0;
        for (Phone phone : phones) {
            if (phone.getBrand().equalsIgnoreCase(brand)) {
                sum += phone.getPrice();
            }
        }
        return sum;
    }

    public static Phone getPhoneIdBasedOnOs(Phone[] phones, String os) {
        for (Phone phone : phones) {
            if (phone.getOs().equalsIgnoreCase(os) && phone.getPrice() >= 50000) {
                return phone;
            }
        }
        return null;
    }
}
