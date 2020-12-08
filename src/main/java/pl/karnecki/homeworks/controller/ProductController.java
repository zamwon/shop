package pl.karnecki.homeworks.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.karnecki.homeworks.Product;
import pl.karnecki.homeworks.service.ProductService;

import java.net.URI;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api/shop")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/products")
    public List<Product> allProducts(){
        return productService.giveAllProducts();
    }

    @GetMapping("/product/{id}")
    public Optional<Product> findProductById(@PathVariable ("id") Long id){
        return productService.findProductById(id);
    }

    @PostMapping("/products")
    public ResponseEntity<Product> addNewProduct(@RequestBody Product productToAdd){

        productService.saveProduct(productToAdd);
        return ResponseEntity.created(URI.create("/products" + productToAdd.getId())).body(productToAdd);
    }

    @DeleteMapping("/products")
    public void deleteProduct(@RequestParam Long id){
        productService.deleteProduct(id);
    }

    @PutMapping("/products/{id}")
    public void updateProduct(@RequestBody Product product, @PathVariable Long id){
        productService.updateProduct(product, id);
    }
}
