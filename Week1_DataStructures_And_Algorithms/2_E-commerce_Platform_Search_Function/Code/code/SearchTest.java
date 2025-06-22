import java.util.Arrays;
import java.util.Comparator;

// Main class to run the test
public class SearchTest {
    public static void main(String[] args) {
        Product[] products = {
            new Product("P003", "Laptop", "Electronics"),
            new Product("P001", "Shampoo", "Health & Beauty"),
            new Product("P005", "Coffee Maker", "Home Appliances"),
            new Product("P002", "T-shirt", "Apparel"),
            new Product("P004", "Book", "Books")
        };

        // --- Linear Search Demonstration ---
        System.out.println("--- Linear Search ---");
        Product foundProductLinear = Search.linearSearch(products, "T-shirt");
        if (foundProductLinear != null) {
            System.out.println("Found: " + foundProductLinear);
        } else {
            System.out.println("Product not found.");
        }
        System.out.println();

        // --- Binary Search Demonstration ---
        System.out.println("--- Binary Search ---");
        Product foundProductBinary = Search.binarySearch(products, "Laptop");
        if (foundProductBinary != null) {
            System.out.println("Found: " + foundProductBinary);
        } else {
            System.out.println("Product not found.");
        }
    }
}

// Product class definition (in the same file)
class Product {
    private String productId;
    private String productName;
    private String category;

    public Product(String productId, String productName, String category) {
        this.productId = productId;
        this.productName = productName;
        this.category = category;
    }

    public String getProductId() { return productId; }
    public String getProductName() { return productName; }
    public String getCategory() { return category; }

    @Override
    public String toString() {
        return "Product{" +
                "productId='" + productId + '\'' +
                ", productName='" + productName + '\'' +
                ", category='" + category + '\'' +
                '}';
    }
}

// Search class definition (in the same file)
class Search {
    // Linear Search
    public static Product linearSearch(Product[] products, String searchTerm) {
        for (Product product : products) {
            if (product.getProductName().equalsIgnoreCase(searchTerm)) {
                return product;
            }
        }
        return null; // Not found
    }

    // Binary Search
    public static Product binarySearch(Product[] products, String searchTerm) {
        Arrays.sort(products, Comparator.comparing(Product::getProductName));
        int left = 0;
        int right = products.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int comparison = searchTerm.compareToIgnoreCase(products[mid].getProductName());

            if (comparison == 0) {
                return products[mid];
            } else if (comparison < 0) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return null; // Not found
    }
} 