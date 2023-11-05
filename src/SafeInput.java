import java.util.Scanner;
public class SafeInput {
    public static String getNonZeroLenString(Scanner pipe, String prompt) {
        String retString = "";
        do
        {
            System.out.print("\n" + prompt + ": ");
            retString = pipe.nextLine();
        } while(retString.length() == 0);
        return retString;
    }
    public static int getInt(Scanner pipe, String prompt) {
        int returnInt = 0;
        String trash = "";
        boolean validInput = false;
        while (!validInput) {
            System.out.print("\n" + prompt + ": ");
            if(pipe.hasNextInt()) {

                validInput = true;
                returnInt = pipe.nextInt();
            } else {
                trash = pipe.next();
                System.out.println("Invalid entry: " + trash + ". Please inter a valid whole integer.");
            }
            pipe.nextLine();
        }
        return returnInt;
    }

    public static double getDouble(Scanner pipe, String prompt) {
        double returnDouble = 0;
        boolean validInput = false;
        String trash = "";

        while (!validInput) {

            System.out.print("\n" + prompt + ": ");
            if (pipe.hasNextDouble()) {
                validInput = true;
                returnDouble = pipe.nextDouble();
            } else {
                trash = pipe.next();
                System.out.println("Invalid entry: " + trash + ". Please enter a valid number.");
            }
            pipe.nextLine();
        }
        return returnDouble;
    }
    public static int getRangedInt(Scanner pipe, String prompt, int low, int high) {
        int input = 0;
        String trash = "";
        boolean validInput = false;

        while (!validInput) {
            System.out.print("\n" + prompt + " [" + low + " - " + high + "]: ");
            if (pipe.hasNextInt()) {
                input = pipe.nextInt();
                if (input >= low && input <= high) {
                    validInput = true;
                } else {
                    System.out.println("Error: Input has to be between " + low + " and " + high);
                }
            } else {
                trash = pipe.next();
                System.out.println("Error: non-integer input. You entered" + trash);
            }
            pipe.nextLine();
        }
        return input;
    }
    public static double getRangedDouble(Scanner pipe, String prompt, double low, double high) {
        double input = 0;
        String trash = "";
        boolean validInput = false;

        while (!validInput) {
            System.out.println("\n" + prompt + " [" + low + " - " + high + "]: ");
            if (pipe.hasNextDouble()) {
                input = pipe.nextDouble();
                if (input >= low && input <= high) {
                    validInput = true;
                } else {
                    System.out.println("Error: Input has to be between " + low + " and " + high);
                }
            } else {
                trash = pipe.next();
                System.out.println("Error: non-integer input. You entered" + trash);
            }
            pipe.nextLine();
        }
        return input;
    }
    public static boolean getYNConfirm(Scanner pipe, String prompt) {
        String input = "";
        String trash = "";
        boolean validInput = false;

        while (!validInput) {
            System.out.println("\n" + prompt + ": ");
            input = pipe.next();
            if (input.equalsIgnoreCase("Y") || input.equalsIgnoreCase("N")) {
                validInput = true;
            } else {
                trash = input;
                System.out.println("Error, enter Y or N. You entered " + trash);
            }
            pipe.nextLine();
        }
        if (input.equalsIgnoreCase("Y")) {
            return true;
        } else {
            return false;
        }
    }


    public static String getRegExString(Scanner pipe, String prompt, String regEx) {
        String input = "";
        boolean validInput = false;
        String trash = "";

        while (!validInput) {
            System.out.print(prompt + ": ");
            if (pipe.hasNext(regEx)) {
                input = pipe.next(regEx);
                validInput = true;
            } else {
                trash = pipe.next();
                System.out.println("Error: Input must match the pattern " + regEx + ".");
            }
            pipe.nextLine();
        }
        return input;
    }
    public static void prettyHeader(String msg) {
        int totalLength = 60;
        int msgLength = msg.length();
        int spaceLength = (totalLength - msgLength - 6) / 2;
        String middle = "";
        String starsTop = "";
        String spacesMid = "";
        String starsMid = "***";

        for (int i = 0; i < totalLength; i++) {
            starsTop += "*";
        }
        for (int i = 0; i < spaceLength; i++) {
            spacesMid += " ";
        }
        middle = starsMid + spacesMid + msg + spacesMid + starsMid;

        System.out.println(starsTop);
        System.out.println(middle);
        System.out.println(starsTop);
    }
}