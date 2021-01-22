package bai12_java_collection_framework.bai_tap.practice_arraylist;

import java.util.ArrayList;
import java.util.Scanner;

public class ProductManager {
    Scanner sc = new Scanner(System.in);
    ArrayList<Product> productArrayList = new ArrayList<>();

    public void addProduct(Product products) {
        productArrayList.add(products);
    }

    public void editProduct(int id) {
        String name;
        int price;
        for (Product product : productArrayList) {
            if (id == product.getId()) {
                System.out.print(product.getName() + " -> Enter new name:");
                name = sc.nextLine();
                product.setName(name);
                System.out.print(product.getPrice() + " -> Enter new price:");
                price = Integer.parseInt(sc.nextLine());
                product.setPrice(price);
                System.out.println("\t--> Add success!");
                return;
            }
        }
        System.out.println("\t" + id + " not exist!");
    }

    public void deleteProduct(int id) {
        for (Product product : productArrayList) {
            if (id == product.getId()) {
                productArrayList.remove(product);
                System.out.println("\t-->" + product + " deleted!");
                return;
            }
        }
        System.out.println("\t-->" + id + " not exist!");
    }

    public void displayAllProduct() {
        for (Product product : productArrayList) {
            System.out.println("\t-->" + product);
        }
    }

    public void findProductByName(String name) {
        boolean checkFind = true;
        for (Product product : productArrayList) {
            if (product.getName().contains(name)) {
                System.out.println(product);
                checkFind = false;
            }
        }
        if (checkFind) {
            System.out.println("\t-->" + name + " not exist!");
        }
    }
}
