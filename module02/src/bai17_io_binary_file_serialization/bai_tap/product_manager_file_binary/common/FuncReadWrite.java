package bai17_io_binary_file_serialization.bai_tap.product_manager_file_binary.common;

import bai17_io_binary_file_serialization.bai_tap.product_manager_file_binary.model.Product;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FuncReadWrite {
    static final String PATH_PRODUCT = "src/bai17_io_binary_file_serialization/bai_tap/product_manager_file_binary/data/Product.csv";
    static File file = new File(PATH_PRODUCT);

    public static void writeProduct(List<Product> list, boolean selection) {
        FileWriter fileWriter = null;
        BufferedWriter bufferedWriter = null;
        try {
            fileWriter = new FileWriter(file, selection);
            bufferedWriter = new BufferedWriter(fileWriter);
            for (Product product : list) {
                bufferedWriter.write(product.getInfo());
                bufferedWriter.newLine();
            }
        } catch (IOException e) {
            System.out.println("Writing file error");
            e.printStackTrace();
        } finally {
            try {
                bufferedWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static List<Product> readProduct() {
        List<Product> list = new ArrayList<>();
        FileReader fileReader = null;
        BufferedReader bufferedReader = null;
        try {
            fileReader = new FileReader(file);
            bufferedReader = new BufferedReader(fileReader);
            String line = "";
            String[] arr = null;
            while ((line = bufferedReader.readLine()) != null) {
                arr = line.split(",");
                Product product = new Product(arr[0], arr[1], arr[2], Float.parseFloat(arr[3]), arr[4]);
                list.add(product);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Reading file error");
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                bufferedReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return list;
    }
}
