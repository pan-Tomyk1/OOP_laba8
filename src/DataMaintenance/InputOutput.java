package DataMaintenance;

import java.util.Scanner;

public final class InputOutput {
    static Scanner scanner;

    public static int enterInt(int max, int min) {
        scanner = new Scanner(System.in);
        boolean checkNumber = false;
        int number = 0;
        while (!checkNumber) {
            try {
                number = scanner.nextInt();
            } catch (Exception e) {
                System.out.println("Invalid input. Please, enter a number");
                scanner.next();
                continue;
            }
            checkNumber = Validation.validateNumber(number, max, min);
            if (!checkNumber) {
                System.out.println("Invalid input, please enter " +
                        "number between " + max + " and " + min);
            }
        }
        return number;
    }

    public static String enterString() {
        scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        return input;
    }
    public static boolean enterBooleanData() {
        scanner = new Scanner(System.in);
        return scanner.nextBoolean();
    }

}
