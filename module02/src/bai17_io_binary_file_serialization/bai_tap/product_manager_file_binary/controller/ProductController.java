package bai17_io_binary_file_serialization.bai_tap.product_manager_file_binary.controller;

import bai17_io_binary_file_serialization.bai_tap.product_manager_file_binary.service.ProductManager;

import java.util.Scanner;

public class ProductController {
    static ProductManager productManager = new ProductManager();

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        boolean flg = true;
        while (flg) {
            System.out.println("PRODUCT MENU:\t1.Add new product | 2.Show list products | 3.Search product | x.Exit");
            String choose = "";
            try {
                choose = scan.nextLine();
            } catch (NullPointerException|NumberFormatException npe) {
                System.out.println("You not choose yet!");
//                npe.getMessage();
            }
            switch (choose) {
                case "1":
                    productManager.addProduct();
                    break;
                case "2":
                    productManager.showListProduct();
                    break;
                case "3":
                    productManager.searchProduct();
                    break;
                case "x":
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

