package pl.karnecki.homeworks.service;


import org.springframework.stereotype.Service;
import pl.karnecki.homeworks.Product;
import pl.karnecki.homeworks.repository.ProductRepo;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class ProductService {

    private final ProductRepo productRepo;


    public ProductService(ProductRepo productRepo) {
        this.productRepo = productRepo;
    }

    public List<Product> giveAllProducts() {
        List<Product> products = new ArrayList<>();
        productRepo.findAll().forEach(products::add);
        return products;
    }

    public Optional<Product> findProductById(Long id) {
        return productRepo.findById(id);
    }

    public void saveProduct(Product productToSave) {
        productRepo.save(productToSave);
    }

    public void deleteProduct(Long id) {
        productRepo.deleteById(id);
    }

    public void updateProduct(Product product, Long id) {
        productRepo.save(product);
    }
}

