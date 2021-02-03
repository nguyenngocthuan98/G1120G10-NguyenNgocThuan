package case_study.commons;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FuncReadWrite<T> {
    static final String PATH = "src/case_study/data";
    static final String COMMA = ",";

    public List<String[]> readFile(String fileName) {
        List<String[]> list = new ArrayList<>();
        File file = new File(PATH + "/" + fileName);
        BufferedReader bufferedReader = null;
        try {
            if (!file.exists()) {
                file.createNewFile();
            }
            bufferedReader = new BufferedReader(new FileReader(file));
            String line = "";
            String[] temp;
            while ((line = bufferedReader.readLine()) != null) {
                temp = line.split(COMMA);
                list.add(temp);
            }
        } catch (IOException e) {
            System.out.println("Reading error");
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

    public void writeFile(String fileName, List<T> list, boolean selection) {
        File file = new File(PATH + "/" + fileName);
        BufferedWriter bufferedWriter = null;
        try {
            if (!file.exists()) {
                file.createNewFile();
            }
            bufferedWriter = new BufferedWriter(new FileWriter(file, selection));
            for (T t : list) {
                bufferedWriter.write(t.toString());
                bufferedWriter.newLine();
            }
        } catch (IOException e) {
            System.out.println("Writing error");
            e.printStackTrace();
        } finally {
            try {
                bufferedWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
