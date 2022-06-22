package utils;

import view.InputOption;
import view.StudentViewManager;

import java.util.Scanner;

public class AppUtils {
    static Scanner scanner = new Scanner(System.in);

    public static int retryChoose(int min, int max) {
        int option;
        do {
            System.out.print("⭆");
            try {
                option = Integer.parseInt(scanner.nextLine());
                if (option > max || option < min) {
                    System.out.println("Chức năng không đúng ! Vui lòng chọn lại");
                    continue;
                }
                break;
            } catch (Exception ex) {
                System.out.println("Nhập sai! Vui lòng nhập lại");
            }
        } while (true);
        return option;
    }

    public static int retryParseInt() {
        int result;
        do {
            System.out.print("⭆ ");
            try {
                result = Integer.parseInt(scanner.nextLine());
                return result;
            } catch (Exception ex) {
                System.out.println("Nhập sai! Vui lòng nhập lại");
            }
        } while (true);
    }

    public static String retryString(String fieldName) {
        String result;
        System.out.print(" ⭆ ");
        while ((result = scanner.nextLine()).isEmpty()) {
            System.out.printf("%s không được để trống\n", fieldName);
            System.out.print(" ⭆ ");
        }
        return result;
    }

    public static double retryParseDouble() {
        double result;
        do {
            System.out.print(" ⭆ ");
            try {
                result = Double.parseDouble(scanner.nextLine());
                return result;
            } catch (Exception ex) {
                System.out.println("Nhập sai! vui lòng nhập lại");
            }
        } while (true);
    }



    public static boolean isRetry(InputOption inputOption) {
        do {
            switch (inputOption) {
                case ADD:
                    System.out.println("Press 'y' to add more \t|\t Press 'q' to go back \t|\t press 't' to exit the program");
                    break;
                case UPDATE:
                    System.out.println("Press 'y' to continue editing \t|\t Press 'q' to go back\t|\t press 't' to exit the program");
                    break;
                case DELETE:
                    System.out.println("Press 'q' to go back\t|\t press 't' to exit the program");
                    break;
                case SHOW:
                    System.out.println("Press 'q' to go back \t|\t press 't' to exit the program");
                    break;
                default:
                    throw new IllegalStateException("Unexpected value: " + inputOption);
            }

            System.out.print(" ⭆ ");
            String option = scanner.nextLine();
            switch (option) {
                case "y":
                    return true;

                case "q":
                    return false;
                case "t":
                    exit();
                    break;
                default:
                    System.out.println("Choose the wrong function! Please choose again");
                    break;
            }
        } while (true);
    }

    public static void exit() {
        System.out.println("\tBye. See you again!");
        System.exit(0);
    }
}
