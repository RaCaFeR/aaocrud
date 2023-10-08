package me.crud.database;

import me.crud.model.Product;

import java.util.HashMap;

public class ProductManager {
    private ProductManager instance;
    private HashMap<Integer, Product> products;

    public HashMap<Integer, Product> getProducts() {
        return products;
    }

    public ProductManager getInstance() {
        return instance;
    }
}