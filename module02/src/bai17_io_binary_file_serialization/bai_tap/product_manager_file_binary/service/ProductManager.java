package bai17_io_binary_file_serialization.bai_tap.product_manager_file_binary.service;

import bai17_io_binary_file_serialization.bai_tap.product_manager_file_binary.common.FuncReadWrite;
import bai17_io_binary_file_serialization.bai_tap.product_manager_file_binary.model.Product;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProductManager {
    Scanner scanner = new Scanner(System.in);

    public void addProduct() {
        List<Product> productList = new ArrayList<>();
        String id = null;
        String name = null;
        String brand = null;
        float price = 0;
        String description = null;
        boolean flgLoopInput = false;

        System.out.print("\t--NEW PRODUCT--\n");
        do{
            try {
                System.out.print("Enter id: ");
                id = scanner.nextLine();
                System.out.print("Enter name: ");
                name = scanner.nextLine();
                System.out.print("Enter brand: ");
                brand = scanner.nextLine();
                System.out.print("Enter price: ");
                price = Float.parseFloat(scanner.nextLine());
                System.out.print("Enter description: ");
                description = scanner.nextLine();
            } catch (NumberFormatException e) {
                System.out.println("Input values must be not null!");
                flgLoopInput = true;
            }
        } while (flgLoopInput);

        Product product = new Product(id, name, brand, price, description);
        productList.add(product);

        FuncReadWrite.writeProduct(productList, true);
    }

    public void showListProduct() {
        List<Product> productList = FuncReadWrite.readProduct();
        System.out.print("\t--LIST PRODUCT--\n");
        for (int i = 0; i < productList.size(); i++) {
            System.out.println((i + 1) + ". " + productList.get(i));
        }
    }

    public void searchProduct() {
        List<Product> productList = FuncReadWrite.readProduct();
        System.out.println("Name search: ");
        String nameSearch = scanner.nextLine();
        System.out.print("\t--PRODUCT: " + nameSearch + "--\n");
        for (Product product : productList) {
            if (product.getNameProduct().contains(nameSearch)) {
                System.out.println(product);
            }
        }
    }
}
