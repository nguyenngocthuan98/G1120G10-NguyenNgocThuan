package case_study.commons;

import case_study.models.Villa;
import case_study.services.VillaManager;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.regex.Pattern;

public class Validate {
    private static final int SERVICE_VILLA = 1;
    private static final int SERVICE_HOUSE = 2;
    private static final int SERVICE_ROOM = 3;
    private static final String REGEX_SERVICE_ID_VILLA = "^SVVL-\\d{4}$";
    private static final String REGEX_SERVICE_ID_HOUSE = "^SVHO-\\d{4}$";
    private static final String REGEX_SERVICE_ID_ROOM = "^SVRO-\\d{4}$";
    private static final String REGEX_STRING = "^[A-Z][a-z]*(\\s[A-Z][a-z]*)*$";
    private static final String REGEX_NOT_EMPTY = "^[A-Z][\\w+\\s]*$";
    private static final String REGEX_AREA = "^(30\\.\\d*[1-9]|((3[1-9])|([4-9]\\d)|([1-9]\\d{2,}))(\\.\\d+)?)$"; //real number > 30
    private static final String REGEX_RENT_PRICE = "^0\\.\\d*[1-9]|[1-9][\\d]*(\\.[\\d]+)?$"; //real number > 0
    private static final String REGEX_MAX_PEOPLE = "^([2-9]|1\\d|1)$"; // 0 < max people < 20
    private static final String REGEX_EXTERNAL_SERVICE = "^(massage|karaoke|food|drink|car)$";
    private static final String REGEX_FLOORS = "^[1-9][\\d]*$"; // floors > 0
    private static final String REGEX_BIRTHDAY = "^([0-2][1-9]|[1-3]0|31)/(0[1-9]|1[0-2])/(190[1-9]|19[1-9]\\d|2\\d{3})$"; // year > 1900
    private static final String REGEX_GENDER = "^(male|female|unknown)$";
    private static final String REGEX_ID_CARD = "^\\d{3}(\\s\\d{3}){2}$"; // number: xxx xxx xxx
    private static final String REGEX_PHONE = "^0[0-9]{9}$";
    private static final String REGEX_EMAIL = "^[\\w]+@[\\w]+(\\.\\w{1,3})+$";
    private static final String REGEX_ADDRESS = "^[A-Z\\d][a-z\\d]*(\\s[A-Z][a-z\\d]*)*$";


    public static boolean validateServiceID(String inputID, int serviceType) {
        boolean result = false;
        switch (serviceType) {
            case SERVICE_VILLA:
                result = validateVillaID(inputID);
                break;
            case SERVICE_HOUSE:
                result = validateHouseID(inputID);
                break;
            case SERVICE_ROOM:
                result = validateRoomID(inputID);
        }
        return result;
    }

    public static boolean validateVillaID(String inputID) {
        try {
            if (Pattern.matches(REGEX_SERVICE_ID_VILLA, inputID)) {
                List<Villa> listVilla = new VillaManager().findAll();
                for (Villa villa : listVilla) {
                    if (villa.getIdService().equals(inputID)) {
                        throw new Exception("\t--ID duplicate!--");
                    }
                }
                return true;
            }
            throw new Exception("\t--Wrong format ID: SVVL-YYYY (YYYY is numbers)");
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public static boolean validateHouseID(String inputID) {
        try {
            if (Pattern.matches(REGEX_SERVICE_ID_HOUSE, inputID)) {
                List<Villa> listVilla = new VillaManager().findAll();
                for (Villa villa : listVilla) {
                    if (villa.getIdService().equals(inputID)) {
                        throw new Exception("\t--ID duplicate!--");
                    }
                }
                return true;
            }
            throw new Exception("\t--Wrong format ID: SVHO-YYYY (YYYY is numbers)");
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public static boolean validateRoomID(String inputID) {
        try {
            if (Pattern.matches(REGEX_SERVICE_ID_ROOM, inputID)) {
                List<Villa> listVilla = new VillaManager().findAll();
                for (Villa villa : listVilla) {
                    if (villa.getIdService().equals(inputID)) {
                        throw new Exception("\t--ID duplicate!--");
                    }
                }
                return true;
            }
            throw new Exception("\t--Wrong format ID: SVRO-YYYY (YYYY is numbers)");
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public static boolean validateString(String string) {
        try {
            if (Pattern.matches(REGEX_STRING, string)) {
                return true;
            }
            throw new Exception("Capitalized first letter of each word");
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public static boolean notEmpty(String string) {
        try {
            if (Pattern.matches(REGEX_NOT_EMPTY, string)) {
                return true;
            }
            throw new Exception("\t--Capitalized first letter.");
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public static boolean validateArea(String number){
        try {
            if (Pattern.matches(REGEX_AREA, number)) {
                return true;
            }
            throw new Exception("Area must over than 30");
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public static boolean validateRentPrice(String number){
        try {
            if (Pattern.matches(REGEX_RENT_PRICE, number)) {
                return true;
            }
            throw new Exception("\t--Must positive number");
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public static boolean validateMaxPeople(String number){
        try {
            if (Pattern.matches(REGEX_MAX_PEOPLE, number)) {
                return true;
            }
            throw new Exception("Must positive number less than 20");
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public static boolean validateExternalService(String number){
        try {
            if (Pattern.matches(REGEX_EXTERNAL_SERVICE, number)) {
                return true;
            }
            throw new Exception("\t--Must be massage | karaoke | food | drink | car");
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public static boolean validateFloors(String number){
        try {
            if (Pattern.matches(REGEX_FLOORS, number)) {
                return true;
            }
            throw new Exception("\t--Must positive number");
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public static boolean validateBirthday(String birthday) {
        try {
            if (!Pattern.matches(REGEX_BIRTHDAY, birthday)) {
                throw new Exception("\t--Must format dd/mm/YYYY and over than 1900");
            } else {
                String[] date = birthday.split("/");
                int year = Integer.parseInt(date[2]);
                String temp = date[0] + "/" + date[1] + "/" + (year + 18);
                Date dateTemp = new SimpleDateFormat("dd/MM/yyyy").parse(temp);
                if (dateTemp.compareTo(new Date()) <= 0) {
                    return true;
                }
                throw new Exception("\t--Birthday must be at least 18 years before the current date");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public static boolean validateGender(String customerGender) {
        try {
            if (Pattern.matches(REGEX_GENDER, customerGender.toLowerCase())) {
                return true;
            }
            throw new Exception("\t--Must Male|Female|Unknown");
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public static boolean validateIdCard(String customerIdNumber) {
        try {
            if (Pattern.matches(REGEX_ID_CARD, customerIdNumber)) {
                return true;
            }
            throw new Exception("\t--Must have 9 digits format XXX XXX XXX");
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public static boolean validatePhone(String customerPhone) {
        try {
            if (Pattern.matches(REGEX_PHONE, customerPhone)) {
                return true;
            }
            throw new Exception("\t--Must start by 0 and have 9 digits before");
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public static boolean validateEmail(String customerEmail) {
        try {
            if (Pattern.matches(REGEX_EMAIL, customerEmail)) {
                return true;
            }
            throw new Exception("\t--Wrong format example@example.xyz");
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public static boolean validateAddress(String customerAddress) {
        try {
            if (Pattern.matches(REGEX_ADDRESS, customerAddress)) {
                return true;
            }
            throw new Exception("\t--Capitalized first letter.");
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
}
