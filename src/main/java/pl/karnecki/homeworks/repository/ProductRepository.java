package pl.karnecki.homeworks.repository;

import org.springframework.stereotype.Repository;
import pl.karnecki.homeworks.Product;

import java.util.ArrayList;


@Repository
public class ProductRepository {

    public ArrayList<Product> allProducts() {

        var result = new ArrayList<Product>();

        var pyry = Product.builder()
                .id(1L)
                .name("pyry")
                .price(2)
                .build();
        result.add(pyry);

        var ser = Product.builder()
                .id(2L)
                .name("ser")
                .price(10)
                .build();
        result.add(ser);
        var mleko = Product.builder()
                .id(3L)
                .name("mleko")
                .price(4)
                .build();
        result.add(mleko);

        return result;
    }
}
