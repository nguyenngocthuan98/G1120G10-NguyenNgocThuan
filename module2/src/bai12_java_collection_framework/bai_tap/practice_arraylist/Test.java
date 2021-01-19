package bai12_java_collection_framework.bai_tap.practice_arraylist;

import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ProductManager productManager = new ProductManager();
        Product products1 = new Product(1, "cola", 16);
        Product products2 = new Product(2, "cake", 120);
        Product products3 = new Product(3, "milk", 52);
        Product products4 = new Product(4, "vegetable", 10);
        Product products5 = new Product(5, "milk", 10);

        productManager.addProduct(products1);
        productManager.addProduct(products2);
        productManager.addProduct(products3);
        productManager.addProduct(products4);
        productManager.addProduct(products5);

        int id;
        String name;
        int price;
        int menuNumber;

        do {
            System.out.println("Menu:\n1.Add | 2.Edit | 3.Delete | 4.Show list | 5.Find | Exit with any number else");
            menuNumber = Integer.parseInt(sc.nextLine());
            switch (menuNumber) {
                case 1:
                    Product product = new Product();
                    System.out.print("Enter Id: ");
                    product.setId(Integer.parseInt(sc.nextLine()));
                    System.out.print("Enter name: ");
                    product.setName(sc.nextLine());
                    System.out.print("Enter price: ");
                    product.setPrice(Integer.parseInt(sc.nextLine()));
                    productManager.addProduct(product);
                    break;
                case 2:
                    System.out.print("EDIT\tEnter id: ");
                    productManager.editProduct(id = Integer.parseInt(sc.nextLine()));
                    break;
                case 3:
                    System.out.print("DELETE\tEnter id: ");
                    productManager.deleteProduct(id = Integer.parseInt(sc.nextLine()));
                    break;
                case 4:
                    productManager.displayAllProduct();
                    break;
                case 5:
                    System.out.print("FIND NAME\tEnter name: ");
                    productManager.findProductByName(name = sc.nextLine());
                    break;
                case 6:
                    System.out.print("SORT(1.ascending | 2.descending)\tEnter type: ");
                    break;
                default:
//                    throw new IllegalStateException("Unexpected value: " + menuNumber);
                    System.out.println("--Exited program--");
                    System.exit(0);
            }

        } while (menuNumber > 0);
    }
}

