package bai17_io_binary_file_serialization.bai_tap.product_manager_file_binary.service;

import bai17_io_binary_file_serialization.bai_tap.product_manager_file_binary.model.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProductManager {
    Scanner scanner = new Scanner(System.in);

    public void addProduct() {
        List<Product> productList = new ArrayList<>();
        System.out.print("\t--NEW PRODUCT--");
        System.out.print("Enter ID: ");
        String id = scanner.nextLine();
        System.out.print("Enter Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter brand: ");
        String brand = scanner.nextLine();
        System.out.print("Enter price: ");
        float price = Float.parseFloat(scanner.nextLine());
        System.out.print("Enter description: ");
        String description = scanner.nextLine();

        Product product = new Product(id, name, brand, price, description);
        productList.add(product);
    }

    public void showListProduct() {
        List<Product> productList = new ArrayList<>();
        for (int i = 0; i < productList.size(); i++) {
            System.out.println((i + 1) + ". " + productList.get(i));
        }
    }

    public void searchProduct() {
        List<Product> productList = new ArrayList<>();
        System.out.println("nhập tên sp cần tìm");
        String nameSearch = scanner.nextLine();
        for ( Product product: productList) {
            if (product.getNameProduct().contains(nameSearch)){
                System.out.println(product);
            }
        }
    }
}
