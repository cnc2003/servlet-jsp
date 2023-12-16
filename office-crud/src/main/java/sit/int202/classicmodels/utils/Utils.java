package sit.int202.classicmodels.utils;

public class Utils {
    public static boolean validateIsNotEmpty(String officeCode, String city, String phone, String addressLine1,
                                             String country, String postalCode, String territory) {
        if (officeCode != null && city != null && phone != null && addressLine1 != null &&
                country != null && postalCode != null && territory != null && !officeCode.isEmpty() &&
                !city.isEmpty() && !phone.isEmpty() && !addressLine1.isEmpty() && !country.isEmpty() &&
                !postalCode.isEmpty() && !territory.isEmpty()) {
            return true;
        }
        return false;
    }

    public static boolean validateIsInteger(String input) {
        boolean flag=true;
        for (int i = 0; i < input.length(); i++) {
            if(!Character.isDigit(input.charAt(i)))
                flag=false;
        }
        return flag;
    }

    public static boolean validateIsLetter(String input) {
        boolean flag = true;
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == ' ') continue;
            if(!Character.isLetter(input.charAt(i))) {
                flag = false;
            }
        }
        return flag;
    }

    public static boolean validateHaveSomeSpecial(String postalCode) {
        boolean flag = false;
        for (int i = 0; i < postalCode.length(); i++) {
            if (postalCode.charAt(i) == ' ' || postalCode.charAt(i) == '-') continue;
            if(!Character.isLetter(postalCode.charAt(i)) && !Character.isDigit(postalCode.charAt(i))) {
                flag = true;
            }
        }
        return flag;
    }

    public static boolean validateIsPhone(String phone) {
        boolean flag=true;
        for (int i = 0; i < phone.length(); i++) {
            if (phone.charAt(i) == '+' || phone.charAt(i) == '-' || phone.charAt(i) == ' ') {
                continue;
            }
            if(!Character.isDigit(phone.charAt(i)))
                flag=false;
        }
        return flag;
    }

    public static boolean validateHaveSomeLetter(String addressLine1) {
        for (int i = 0; i < addressLine1.length(); i++) {
            if(Character.isLetter(addressLine1.charAt(i)) || addressLine1.charAt(i) == '\'' ||
                    addressLine1.charAt(i) == '-') {
                return true;
            }
        }
        return false;
    }

    public static boolean validateHaveSomeInteger(String addressLine1) {
        for (int i = 0; i < addressLine1.length(); i++) {
            if(Character.isDigit(addressLine1.charAt(i)) || addressLine1.charAt(i) == '\'' ||
                    addressLine1.charAt(i) == '-') {
                return true;
            }
        }
        return false;
    }
}
