package Utils;

import Utils.Product;

import java.util.List;

public interface ProductRepository {
    List<Product> returnProduct();
    Product getProductById(int id);
}
