package pl.karnecki.homeworks.service;


import org.springframework.stereotype.Service;
import pl.karnecki.homeworks.Product;
import pl.karnecki.homeworks.repository.ProductRepository;

import java.util.List;
import java.util.Random;

@Service
public class ProductService {

    private final ProductRepository productRepository;


    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> giveAllProducts() {

        var list = productRepository.allProducts();
        return list;
    }

    public Product findProductById(Long id) {
        var result = productRepository.allProducts().stream()
                .filter(product -> product.getId() == id)
                .findFirst()
                .orElse(null);
        return result;
    }

    public void saveProduct(Product productToSave) {
        productRepository.allProducts().add(productToSave);
    }

    public void deleteProduct(Long id) {
        productRepository.allProducts().remove(id);
    }

    public void updateProduct(Product product, Long id) {
        for (int i = 0; i < giveAllProducts().size(); i++) {
            Product p = giveAllProducts().get(i);
            if (p.getId().equals(id)) {
                giveAllProducts().set(i, product);
            }
        }
    }
}
