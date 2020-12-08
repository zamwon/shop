package pl.karnecki.homeworks;

import org.springframework.context.annotation.Scope;

import java.util.HashMap;

@Scope(scopeName = "session")
public class ShoppingCart {

    HashMap<Product, Integer> zawartoscKoszyka;
}
