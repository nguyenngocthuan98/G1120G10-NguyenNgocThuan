package bai16_io_text_file.thuc_hanh;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class WriteFileCSV {
    private static final String PATH = "src/bai16_io_text_file/thuc_hanh/countries.csv";
    private static final String COMMA_DELIMITER = ","; // Split by comma
    private static final String NEW_LINE = "\n";

//    public static void createCountry(String startIP, String endIP, int codeOne, int codeTwo, String countryCode, String countryName) {
//        Country country = new Country(startIP, endIP, codeOne, codeTwo, countryCode, countryName);
//        List<Country> countries = new ArrayList<>();
//        countries.add(country);
//    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Country country = new Country();

        System.out.println("Enter startIP: ");
        country.setStartIP(scan.nextLine());
        System.out.println("Enter endIP: ");
        country.setEndIP(scan.nextLine());
        System.out.println("Enter codeOne: ");
        country.setCodeOne(Integer.parseInt(scan.nextLine()));
        System.out.println("Enter codeTwo: ");
        country.setCodeTwo(Integer.parseInt(scan.nextLine()));
        System.out.println("Enter country code: ");
        country.setCountryCode(scan.nextLine());
        System.out.println("Enter country name: ");
        country.setCountryName(scan.nextLine());
        ArrayList<Country> countries = new ArrayList<>();
        countries.add(country);

        FileWriter fileWriter = null;
        try {
            File file;
            fileWriter = new FileWriter(PATH);
            // not yet done

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
