package bai16_io_text_file.thuc_hanh;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ReadFileCSV {
    private static final String PATH = "src/bai16_io_text_file/thuc_hanh/countries.csv";
    private static final String COMMA_DELIMITER = ","; // Split by comma

    public static void main(String[] args) {
        BufferedReader bufferedReader = null;
        String line;
        try {
            bufferedReader = new BufferedReader(new FileReader(PATH));
            while ((line = bufferedReader.readLine()) != null) {
                printCountry(parseCsvLine(line));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (bufferedReader != null)
                    bufferedReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static List<String> parseCsvLine(String csvLine) {
        List<String> result = new ArrayList<>();
        if (csvLine != null) {
            String[] splitData = csvLine.split(COMMA_DELIMITER);
            result.addAll(Arrays.asList(splitData));
        }
        return result;
    }

    private static void printCountry(List<String> country) {
        System.out.println("Country code = " + country.get(4) + ", Country name: " + country.get(5));
    }
}
