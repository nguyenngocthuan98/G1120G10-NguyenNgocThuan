package bai17_io_binary_file_serialization.bai_tap.product_manager_file_binary.controller;

import bai17_io_binary_file_serialization.bai_tap.product_manager_file_binary.model.Product;
import bai17_io_binary_file_serialization.bai_tap.product_manager_file_binary.service.ProductManager;

import java.util.Scanner;

public class ProductController {
    static ProductManager productManager = new ProductManager();

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        boolean flg = true;
        while (flg){
            System.out.println("PRODUCT MENU\n" +
                    "1.Add new product -- 2.Show list products -- 3.Search product -- 0.Exit");
            int choosen = Integer.parseInt(scan.nextLine());
            switch (choosen){
                case 1:
                    productManager.addProduct();
                    break;
                case 2:
                    productManager.showListProduct();
                    break;
                case 3:
                    productManager.searchProduct();
                    break;
                case 0:
                    System.exit(-1);
                    break;
                default:
                    System.out.println("\tThis choice is wrong!");
                    flg = true;
                    break;
            }
        }
    }
}
