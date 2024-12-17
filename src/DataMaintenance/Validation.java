package DataMaintenance;

public final class Validation {

    public static boolean validatePhoneNumber(char[] phoneNumber) {
        if (phoneNumber.length > 10) return false;
        for (int i = 0; i <phoneNumber.length; i++) {
            if(!Character.isDigit(phoneNumber[i])){
                return false;
            }
        }
        return true;
    }
    public static boolean validateNumber(int number, int max, int min){
        return max>=number&&number>=min;
    }

}
