package pl.karnecki.homeworks.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.karnecki.homeworks.Product;
import pl.karnecki.homeworks.service.ProductService;

import java.net.URI;
import java.util.List;


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
    public Product findProductById(@PathVariable ("id") Long id){
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
}
