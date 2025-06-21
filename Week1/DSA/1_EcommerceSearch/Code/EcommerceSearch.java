import java.util.Arrays;
import java.util.Comparator;


class Product {
    int productId;
    String productName;
    String productCategory;

    public Product(int id, String name, String category) {
        this.productId = id;
        this.productName = name;
        this.productCategory = category;
    }

    @Override
    public String toString() {
        return "ID: " + productId + ", Name: " + productName + ", Category: " + productCategory;
    }
}


public class EcommerceSearch {
    public static void main(String[] args) {
        Product[] products = {
            new Product(101, "Mouse", "Electronics"),
            new Product(102, "Keyboard", "Electronics"),
            new Product(103, "Monitor", "Electronics"),
            new Product(104, "Laptop", "Computers")
        };

        String searchName = "Monitor";

       
        System.out.println("Using Linear Search:");
        boolean found = false;
        for (Product item : products) {
            if (item.productName.equalsIgnoreCase(searchName)) {
                System.out.println("Found: " + item);
                found = true;
                break;
            }
        }
        if (!found) System.out.println("Product not found.");

       
        Arrays.sort(products, Comparator.comparing(p -> p.productName.toLowerCase()));

        
        System.out.println("\nUsing Binary Search:");
        int left = 0, right = products.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            int cmp = products[mid].productName.compareToIgnoreCase(searchName);

            if (cmp == 0) {
                System.out.println("Found: " + products[mid]);
                break;
            } else if (cmp < 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
    }
}
