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

    public Product saveProduct(Product productToSave) {

        productToSave.setId(new Random().nextLong());
        return productToSave;
    }
}
