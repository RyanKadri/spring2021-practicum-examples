package xyz.rk0.practicum.state.management;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class UnsafeSharingTest {

    @Test
    public void testUnsafeSharing() {
        List<Product> products = Inventory.fetchProducts();
        ProductDatabase.setProducts(products); // Stores parameter in a member variable
        List<Product> defective = QualityChecker.identifyDefects(products); // Removes non-defective products
        ReportGenerator.defectiveItemsReport(defective); // Stores defective products

        Assertions.assertEquals(1, ReportGenerator.defectiveProducts.size());
        Assertions.assertEquals(3, ReportGenerator.defectiveProducts.get(0).id);

        Assertions.assertEquals(3, ProductDatabase.products.size());
    }

    public static class Product {

        public final Integer id;
        public final boolean isDefective;
        public Product(Integer id, boolean isDefective) {
            this.id = id;
            this.isDefective = isDefective;
        }
    }

    public static class Inventory {
        public static List<Product> fetchProducts() {
            List<Product> products = new ArrayList<>();
            products.add(new Product(1, false));
            products.add(new Product(2, false));
            products.add(new Product(3, true));
            return products;
        }
    }

    public static class ProductDatabase {
        public static List<Product> products;
        public static void setProducts(List<Product> myProducts) {
            products = myProducts;
        }
    }

    public static class QualityChecker {
        public static List<Product> identifyDefects(List<Product> myProducts) {
            List<Product> defectiveProducts = new ArrayList<>();
            for(Product p : myProducts) {
                if(p.isDefective) {
                    defectiveProducts.add(p);
                }
            }
            return defectiveProducts;
        }
    }

    public static class ReportGenerator {

        public static List<Product> defectiveProducts;
        public static void defectiveItemsReport(List<Product> myDefectiveProducts) {
            defectiveProducts = myDefectiveProducts;
        }
    }
}
