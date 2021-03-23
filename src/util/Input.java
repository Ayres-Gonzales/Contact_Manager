package util;

import java.util.Scanner;

public class Input {

    public static Object toLowerCase;
    private Scanner scanner;

    public Input() {

        this.scanner = new Scanner(System.in);
    }

    public String getString() {

        return scanner.nextLine();
    }

    public boolean yesNo() {
        String input = scanner.next();
        return input.equalsIgnoreCase("y") || input.equalsIgnoreCase("yes");
    }

    public int getInt() {
        if (scanner.hasNextInt()){
            return scanner.nextInt();
        } else {
            System.out.println("Invalid input; please enter an integer");
            scanner.nextLine();
            return getInt();
        }
    }

    public double getDouble() {
        if(scanner.hasNextDouble()) {
            return scanner.nextDouble();
        } else {
            System.out.println("Invalid double. Please enter a double.");
            scanner.nextLine();
            return getDouble();
        }
    }

    public int getInt(int min, int max) {
        int userInt = getInt();
        if (userInt >= min && userInt <= max) {
            return userInt;
        } else {
            System.out.println("Out of range; please enter a number between " + min + " and " + max);
            return getInt(min, max);
        }
    }




    public int getInt(int i) {
        return 0;
    }

}