package pl.karnecki.homeworks.repository;

import org.springframework.data.repository.CrudRepository;
import pl.karnecki.homeworks.Product;

public interface ProductRepo extends CrudRepository<Product, Long> {
}
