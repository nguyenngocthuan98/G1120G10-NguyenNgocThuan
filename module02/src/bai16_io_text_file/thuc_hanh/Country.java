package bai16_io_text_file.thuc_hanh;

public class Country {
    private String startIP;
    private String endIP;
    private int codeOne;
    private int codeTwo;
    private String countryCode;
    private String countryName;

    public Country() {
    }

    public Country(String startIP, String endIP, int codeOne, int codeTwo, String countryCode, String countryName) {
        this.startIP = startIP;
        this.endIP = endIP;
        this.codeOne = codeOne;
        this.codeTwo = codeTwo;
        this.countryCode = countryCode;
        this.countryName = countryName;
    }

    public String getStartIP() {
        return startIP;
    }

    public void setStartIP(String startIP) {
        this.startIP = startIP;
    }

    public String getEndIP() {
        return endIP;
    }

    public void setEndIP(String endIP) {
        this.endIP = endIP;
    }

    public int getCodeOne() {
        return codeOne;
    }

    public void setCodeOne(int codeOne) {
        this.codeOne = codeOne;
    }

    public int getCodeTwo() {
        return codeTwo;
    }

    public void setCodeTwo(int codeTwo) {
        this.codeTwo = codeTwo;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    @Override
    public String toString() {
        return "countryCode = " + countryCode + ", countryName: " + countryName;
    }
}
