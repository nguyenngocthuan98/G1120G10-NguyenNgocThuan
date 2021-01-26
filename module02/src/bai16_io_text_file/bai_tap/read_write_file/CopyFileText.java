package bai16_io_text_file.bai_tap.read_write_file;

import java.io.*;
import java.util.Scanner;

/*
* Mô tả bài toán:
    Viết một chương trình cho phép người dùng sao chép các tập tin.
    Người sử dụng cần phải cung cấp một tập tin nguồn (source file) và một tập tin đích (target file).
    Chương trình sao chép tệp nguồn vào tệp tin đích và hiển thị số ký tự trong tệp.
    Chương trình nên cảnh báo người dùng nếu tệp nguồn không tồn tại hoặc nếu tập tin đích đã tồn tại.
    Để sao chép nội dung từ tệp tin nguồn đến tệp tin đích, bạn nên sử dụng luồng đầu vào để đọc ký tự từ tệp nguồn và luồng đầu ra để gửi byte đến tệp tin đích, bất kể nội dung của tệp.
*/

public class CopyFileText {
    private static final String PATH_SOURCE = "src/bai16_io_text_file/bai_tap/read_write_file/source_folders";
    private static final String PATH_TARGET = "src/bai16_io_text_file/bai_tap/read_write_file/target_folders";

    public static void createFile(String nameFile, String path) {
        File file = new File(path, nameFile); //Tạo đối tượng file trỏ tới đường dẫn path
        try {
            if (file.createNewFile()) { //Tạo file có tên = nameFile
                System.out.println("\t--File " + nameFile + " created!--");
            } else {
                System.out.println("\t--File " + nameFile + " already exists!--");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        File dir_source = new File(PATH_SOURCE);    //Tạo đối tượng directory trỏ tới đường dẫn PATH_SOURCE
        dir_source.mkdir();                         //Tạo thư mục nếu đường dẫn PATH_SOURCE không tồn tại

        File dir_target = new File(PATH_TARGET);    //Tạo đối tượng directory trỏ tới đường dẫn PATH_TARGET
        dir_target.mkdir();                         //Tạo thư mục nếu đường dẫn PATH_TARGET không tồn tại

        System.out.print("Enter source file name: ");
        String sourceFileName = sc.nextLine();
        createFile(sourceFileName, PATH_SOURCE);

        // Viết nội dung cho file sourceFileName
        FileWriter fileWriterSource = null;
        try {
            fileWriterSource = new FileWriter(PATH_SOURCE + "/" + sourceFileName);
            System.out.print("Write content for " + sourceFileName + " : ");
            String inputContent = sc.nextLine();
            fileWriterSource.write(inputContent);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fileWriterSource != null) {
                try {
                    fileWriterSource.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        // Sao chép, bản chất là write target file
        /*  cách thức:
            read file nguồn, đưa nội dung của nó vào BufferedReader
            rồi write file đích bằng nội dung của file nguồn (tức là write bằng BufferedReader)
        */
//        FileReader fileReader;
        BufferedReader bufferReader;
        FileWriter fileWriterTarget = null;
        try {
            // read source file
//            fileReader = new FileReader(PATH_SOURCE + "/" + sourceFileName);
//            bufferReader = new BufferedReader(fileReader);
            bufferReader = new BufferedReader(new FileReader(PATH_SOURCE + "/" + sourceFileName)); // replace for 2 line above.
            StringBuffer result = new StringBuffer();
            String line;
            while ((line = bufferReader.readLine()) != null) {
                result.append(line);
            }
            bufferReader.close();
//            fileReader.close();
            // end read source file
            System.out.print("Enter target file name: ");
            String targetFileName = sc.nextLine();
            createFile(targetFileName, PATH_TARGET);

            fileWriterTarget = new FileWriter(PATH_TARGET + "/" + targetFileName);
            fileWriterTarget.write(String.valueOf(result)); // sao chép nội dung từ file nguồn
            System.out.println("\t--Copy complete!--");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fileWriterTarget != null) {
                try {
                    fileWriterTarget.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
