package application.utils;

import java.util.Scanner;

public class Input {
    private static Scanner scanner = new Scanner(System.in);



    public static int getInt() {
        if (scanner.hasNextInt()) {
            int number = scanner.nextInt();
            scanner.nextLine();
            return number;
        }
        System.out.println(scanner.nextLine() + " - это не целое число. Поаторите ввод.");
        return getInt();
    }

    public static int getInt(String massage) {
        System.out.println(massage);
        return getInt();
    }



    public static double getDouble() {
        if (scanner.hasNextDouble()) {
            double number = scanner.nextDouble();
            scanner.nextLine();
            return number;
        }
        System.out.println(scanner.nextLine() + " - это не число с плавающей точкой. Поаторите ввод.");
        return getDouble();
    }

    public static double getDouble(String massage) {
        System.out.println(massage);
        return getDouble();
    }



    public static String getString() {
        return scanner.nextLine();
    }

    public static String getString(String massage) {
        System.out.println(massage);
        return getString();
    }
}
