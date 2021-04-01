package com.product.repository.impl;

import com.product.model.Product;
import com.product.repository.ProductRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Repository
public class ProductRepositoryImpl implements ProductRepository {
    private static HashMap<Integer, Product> mapProduct;
    private static List<String> productType;

    static {
        mapProduct = new HashMap<>();
        mapProduct.put(1, new Product(1, "Asus ROG Zephyrus G15", 64990000, "Laptop"));
        mapProduct.put(2, new Product(2, "Acer PREDATOR", 46990000, "Laptop"));
        mapProduct.put(3, new Product(3, "Intel Core i9 - 11900K", 157990000, "CPU"));
        mapProduct.put(4, new Product(4, "MSI GS66", 69990000, "Laptop"));
        mapProduct.put(5, new Product(5, "AMD Ryzen Threadripper Pro 3995WX", 141000000, "CPU"));
        mapProduct.put(6, new Product(6, "Alienware M15 R3", 49990000, "Laptop"));
        mapProduct.put(7, new Product(7, "ASUS ROG Strix RTX 3090", 61990000, "GPU"));
        mapProduct.put(8, new Product(8, "Samsung 970 EVO PLUS 2TB PCIe NVMe", 12890000, "SSD"));
        mapProduct.put(9, new Product(9, "Quadro RTX P4000", 23480000, "GPU"));
        mapProduct.put(10, new Product(10, "Gigabyte AORUS GeForce RTX 3080 MASTER", 33490000, "GPU"));

        productType = new ArrayList<>();
        productType.add("Laptop");
        productType.add("CPU");
        productType.add("GPU");
        productType.add("SSD");
    }

    @Override
    public List<Product> findAll() {
        return new ArrayList<>(mapProduct.values());
    }

    @Override
    public void create(Product product) {
        List<Product> listProduct = findAll();
        int id = listProduct.get(listProduct.size() - 1).getId() + 1;
        // if listProduct is empty -> IndexOutOfBoundsException
        product.setId(id);
        mapProduct.put(id, product);
    }

    @Override
    public Product findById(int id) {
        return mapProduct.get(id);
    }

    @Override
    public void update(int id, Product product) {
        mapProduct.put(id, product);
    }

    @Override
    public void delete(int id) {
        mapProduct.remove(id);
    }

    @Override
    public List<String> getTypeProduct() {
        return productType;
    }
}
