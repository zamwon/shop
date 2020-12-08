package pl.karnecki.homeworks.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import pl.karnecki.homeworks.Product;
import pl.karnecki.homeworks.service.ProductService;

import java.net.URI;
import java.util.List;

@Controller
@RestController
@RequestMapping("/api/shop")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/product/{id}")
    public Product findProductById(@PathVariable ("id") Long id){
        return productService.findProductById(id);
    }

    @GetMapping("/products")
    public List<Product> allProducts(){
        return productService.giveAllProducts();
    }

    @PostMapping("/products")
    public ResponseEntity<Product> addNewProduct(@RequestBody Product productToAdd){

        var newProduct = productService.saveProduct(productToAdd);
        return ResponseEntity.created(URI.create("/products" + newProduct.getId())).body(newProduct);
    }

    @DeleteMapping("/products")
    public void deleteProduct(@RequestParam Long id){
        allProducts().remove(id);
    }
}
