import java.util.HashMap;

class Product {
    int productId;
    String productName;
    int quantity;
    double price;

    Product(int productId, String productName, int quantity, double price) {
        this.productId = productId;
        this.productName = productName;
        this.quantity = quantity;
        this.price = price;
    }

    void showDetails() {
        System.out.println("Product ID   : " + productId);
        System.out.println("Name         : " + productName);
        System.out.println("Quantity     : " + quantity);
        System.out.println("Price        : INR " + price);
       
    }
}

public class InventoryManager {
    public static void main(String[] args) {
        HashMap<Integer, Product> inventory = new HashMap<>();

        
        Product p1 = new Product(101, "Laptop", 10, 55000.00);
        Product p2 = new Product(102, "Headphones", 25, 1999.50);
        Product p3 = new Product(103, "Monitor", 5, 12000.75);

        inventory.put(p1.productId, p1);
        inventory.put(p2.productId, p2);
        inventory.put(p3.productId, p3);

        
        Product updatedP2 = new Product(102, "Bluetooth Headphones", 30, 2499.99);
        inventory.put(102, updatedP2); 

        
        inventory.remove(103); 

        
        System.out.println("Inventory List:");
        for (Product p : inventory.values()) {
            p.showDetails();
        }
    }
}
