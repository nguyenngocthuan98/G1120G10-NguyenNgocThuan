package bai17_io_binary_file_serialization.bai_tap.copy_file_binary;

import java.io.*;

public class CopyFileBinary {
    private static final String PATH = "src/bai17_io_binary_file_serialization/bai_tap/copy_file_binary";
    private static final int BUFFER_SIZE = 1; // số byte mỗi lần buffer

    public static void main(String[] args) {
        FileInputStream fileInputStream = null;
        FileOutputStream fileOutputStream = null;
        try {
            File file = new File(PATH + "/" + "data.dat");
            File file_copy = new File(PATH + "/" + "data_copy.dat");
            fileInputStream = new FileInputStream(file);
            fileOutputStream = new FileOutputStream(file_copy);

            byte[] buffer = new byte[BUFFER_SIZE]; // copy 1 lần BUFFER_SIZE byte
            int count = 0;
            while (fileInputStream.read(buffer) != -1) {
                fileOutputStream.write(buffer);
                count++;
            }
            System.out.println("\t--Copy complete!--\nSize = " + count + " byte.");
        } catch (IOException e) {
            System.out.println("Exception while copying file: " + e);
        } finally {
            try {
                fileInputStream.close();
                fileOutputStream.close();
            } catch (IOException e) {
                System.out.println("Close error: " + e);
            }
        }
    }

}
